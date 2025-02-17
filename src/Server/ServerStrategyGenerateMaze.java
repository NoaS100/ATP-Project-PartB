package Server;

import IO.MyCompressorOutputStream;
import IO.SimpleCompressorOutputStream;
import IO.SimpleDecompressorInputStream;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy{

    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {
        try{
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

            int[] mazeDimensions = (int[])fromClient.readObject();

            IMazeGenerator mazeGenerator = Configurations.generateMazeAlgorithmConfig();
            Maze newMaze = mazeGenerator.generate(mazeDimensions[0], mazeDimensions[1]);

            ByteArrayOutputStream outClient = new ByteArrayOutputStream();

            MyCompressorOutputStream compressedOutput  = new MyCompressorOutputStream(outClient);
            compressedOutput.write(newMaze.toByteArray());

            toClient.writeObject(outClient.toByteArray());
            toClient.flush();

            fromClient.close();
            toClient.close();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
