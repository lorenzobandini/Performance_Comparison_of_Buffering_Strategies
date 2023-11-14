import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransferTo_FileChannel implements Runnable{

    private File fileinput;

    public TransferTo_FileChannel(File fileinput) {
        this.fileinput = fileinput;
    }
    
    @Override
    public void run() {
        File fileoutput = new File("Output_TransferTo_FileChannel.txt");

        try (FileChannel sourceChannel = new FileInputStream(fileinput).getChannel();FileChannel destinationChannel = new FileOutputStream(fileoutput).getChannel()){
            fileoutput.createNewFile();
            sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
