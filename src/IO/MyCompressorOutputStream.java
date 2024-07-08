package IO;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream{
    protected OutputStream outputStream;

    public MyCompressorOutputStream(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        // Write initial 24 bytes directly
        for (int i = 0; i < 24; i++) {
            write(b[i]);
        }

        // Compress the remaining bytes
        for (int i = 24; i < b.length; i += 8) {
            StringBuilder binaryString = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                if (i + j < b.length) {
                    binaryString.append(b[i + j]);
                } else {
                    binaryString.append("0");
                }
            }
            write(binaryStringToByte(binaryString.toString()));
        }
    }

    public static Byte binaryStringToByte(String binaryString) {
        if (binaryString == null || binaryString.length() != 8) {
            throw new IllegalArgumentException("Binary string must be 8 characters long.");
        }
        int intValue = Integer.parseInt(binaryString, 2);
        return (byte) intValue;
    }
}
