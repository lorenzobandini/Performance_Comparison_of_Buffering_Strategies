import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Direct_FileChannel implements Runnable {

    private int buffer_size;
    private File fileinput;

    public Direct_FileChannel(int buffer_size, File fileinput) {
        this.buffer_size = buffer_size;
        this.fileinput = fileinput;
    }

    @Override
    public void run() {
        File fileoutput = new File("Output_Direct_FileChannel.txt");
        
        try (FileChannel sourceChannel = new FileInputStream(fileinput).getChannel();FileChannel destinationChannel = new FileOutputStream(fileoutput).getChannel()){
            ByteBuffer buffer = ByteBuffer.allocateDirect(buffer_size);
            fileoutput.createNewFile();

            while (sourceChannel.read(buffer) > 0) {
                buffer.flip(); 
                destinationChannel.write(buffer);
                buffer.clear(); 
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
