package Server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    private final int port;
    private final int listeningIntervalMS;
    private final IServerStrategy strategy;
    private volatile boolean stop;
    private final ThreadPoolExecutor threadPoolExecutor;

    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        this.threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        threadPoolExecutor.setCorePoolSize(Configurations.getInstance().getThreadPoolSize());
    }

    public void start() {
        new Thread(this::startServer).start();
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(this.listeningIntervalMS);
            System.out.println("Starting server at port " + port + "\n");
            while (!stop) {
                try {
                    Socket clientSocket = serverSocket.accept();//waiting for a client
                    System.out.println("Client accepted " + clientSocket.toString() + "\n");
                    threadPoolExecutor.execute(() -> handleClient(clientSocket));
                    //Thread.sleep(2000);
                } catch (SocketTimeoutException e) {
                    continue;
                }
                //System.out.println("Socket timeout");}
//                } catch (InterruptedException e) {
//                    //throw new RuntimeException(e);
//                }
            }
            threadPoolExecutor.shutdown();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            strategy.ServerStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            System.out.println("Done handling client: " + clientSocket + "\n");
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();

//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        }

    }
    public void stop() {
        System.out.println("Server stopped");
        this.stop = true;
    }
}

