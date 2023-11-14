import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteArray implements Runnable {

    private int buffer_size;
    private File fileinput;

    public ByteArray(int buffer_size, File fileinput) {
        this.buffer_size = buffer_size;
        this.fileinput = fileinput;
    }

    @Override
    public void run() {
        File fileoutput = new File("Output_ByteArray.txt");
        try (FileInputStream in = new FileInputStream(fileinput); FileOutputStream out = new FileOutputStream(fileoutput)) {

            byte[] buffer = new byte[buffer_size];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
