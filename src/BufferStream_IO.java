import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferStream_IO implements Runnable {
    
    private int buffer_size;
    private File fileinput;

    public BufferStream_IO(int buffer_size, File fileinput) {
        this.buffer_size = buffer_size;
        this.fileinput = fileinput;
    }

    @Override
    public void run() {
        File fileoutput = new File("Output_BufferStream_IO.txt");
        
        try(FileInputStream input = new FileInputStream(fileinput);FileOutputStream output = new FileOutputStream(fileoutput)) {
            byte[] buffer = new byte[buffer_size];
            fileoutput.createNewFile();

            while (input.read(buffer) > 0) {
                output.write(buffer);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
