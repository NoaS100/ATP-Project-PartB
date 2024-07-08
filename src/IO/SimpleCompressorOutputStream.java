package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class SimpleCompressorOutputStream extends OutputStream{
    protected OutputStream outputStream;

    public SimpleCompressorOutputStream(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    @Override
    public void write(int b){
        try {
            this.outputStream.write(b);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void write(byte[] b){
        int index = 0;

        for(int i = 0; i<24; i++){
            write(b[i]);
        }

        boolean zeroFlag = true;
        int counter = 0;

        for(int i = 24; i < b.length; i++){
            if(counter < 255 && ((zeroFlag && b[i] == (byte) 0) || (!zeroFlag && b[i] == (byte) 1))){
                counter++;
            }
            else{
                write(counter);
                zeroFlag = !zeroFlag;
                counter = 1;
            }
        }
    }
}
