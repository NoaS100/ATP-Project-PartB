package IO;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {
    protected InputStream inputStream;

    public MyDecompressorInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        int byteIndex = 0;
        while (byteIndex < 24) {
            b[byteIndex++] = (byte) read();
        }

        int nextByte = read();
        while (nextByte != -1) {
            String nextBinary = byteToBinaryString((byte) nextByte);
            for (int i = 0; i < 8 && byteIndex < b.length; i++) {
                b[byteIndex++] = charToByte(nextBinary.charAt(i));
            }
            nextByte = read();
        }
        return byteIndex;
    }

    public static String byteToBinaryString(Byte b) {
        int intValue = b & 0xFF;
        String binaryString = Integer.toBinaryString(intValue);
        while (binaryString.length() < 8) {
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }

    public static byte charToByte(char val) {
        return (byte) (val == '1' ? 1 : 0);
    }
}

