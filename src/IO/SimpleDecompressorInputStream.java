package IO;

import java.io.IOException;
import java.io.InputStream;

public class SimpleDecompressorInputStream extends InputStream{
    protected InputStream inputStream;

    public SimpleDecompressorInputStream(InputStream inputStream) {
        this.inputStream = inputStream;

    }

    @Override
    public int read(){
        try {
            return inputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int read(byte[] b){
        int byteIndex = 0;
        while (byteIndex < 24) {
            b[byteIndex] = (byte) read();
            byteIndex++;
        }
        int nextBinary = 0;
        int amount = read();
        while (amount != -1) {
            for (int i = amount; i > 0; i--) {
                b[byteIndex] = (byte) nextBinary;
                byteIndex++;
            }
            nextBinary = ((nextBinary == 1) ? 0 : 1);
            amount = read();
        }
        return byteIndex;
    }
}
