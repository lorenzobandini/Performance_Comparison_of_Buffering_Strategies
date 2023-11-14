import java.io.File;
import java.util.Scanner;


public class Channel_Comparison {

    final static String smallfilepath = "FileInput.txt";
    final static String bigfilepath = "FileInputBig.txt";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want to use the small file or the big file? (S/B): ");
        String filechoice = sc.next();
        String filepath = "";
        
        if(filechoice.equals("S") || filechoice.equals("s")) {
            filepath = smallfilepath;
        } else if(filechoice.equals("B") || filechoice.equals("b")) {
            filepath = bigfilepath;
        } else {
            System.out.println("Please enter a valid choice!");
            System.exit(0);
        }

        File fileinput = new File(filepath);
        if(!fileinput.exists() || !fileinput.isFile() ) {
            System.out.println("File does not exist!");
            System.exit(0);
        }


        
        System.out.print("Enter the dimension of buffer: ");
        
        while(!sc.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            sc.next();
        }
        int buffer_size = sc.nextInt();
        sc.close();


        long init_indirect = System.currentTimeMillis();
        Thread indirect = new Thread(new Indirect_FileChannel(buffer_size, fileinput));
        indirect.start();
        indirect.join();
        long final_indirect = System.currentTimeMillis();

        long init_direct = System.currentTimeMillis();
        Thread direct = new Thread(new Direct_FileChannel(buffer_size,fileinput));
        direct.run();
        direct.join();
        long final_direct = System.currentTimeMillis();

        long init_transfer = System.currentTimeMillis();
        Thread transfer = new Thread(new TransferTo_FileChannel(fileinput));
        transfer.run();
        transfer.join();
        long final_transfer = System.currentTimeMillis();

        long init_bufferstream = System.currentTimeMillis();
        Thread bufferstream = new Thread(new BufferStream_IO(buffer_size, fileinput));
        bufferstream.run();
        bufferstream.join();
        long final_bufferstream = System.currentTimeMillis();

        long init_byte = System.currentTimeMillis();
        Thread array = new Thread(new ByteArray(buffer_size, fileinput));
        array.run();
        array.join();
        long final_byte = System.currentTimeMillis();

        System.out.println("Time elapsed with buffer size of " + buffer_size + " bytes:");
        System.out.println("Indirect FileChannel: " + (final_indirect - init_indirect) + " ms");
        System.out.println("Direct FileChannel: " + (final_direct - init_direct) + " ms");
        System.out.println("TransferTo FileChannel: " + (final_transfer - init_transfer) + " ms");
        System.out.println("BufferStream IO: " + (final_bufferstream - init_bufferstream) + " ms");
        System.out.println("ByteArray: " + (final_byte - init_byte) + " ms");

    }
}
