import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Indirect_FileChannel implements Runnable{

    private int buffer_size;
    private File fileinput;

    public Indirect_FileChannel(int buffer_size, File fileinput) {
        this.buffer_size = buffer_size;
        this.fileinput = fileinput;
    }

    @Override
    public void run() {
        File fileoutput = new File("Output_Indirect_FileChannel.txt");

        try (FileChannel sourceChannel = new FileInputStream(fileinput).getChannel();FileChannel destinationChannel = new FileOutputStream(fileoutput).getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(buffer_size);
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
