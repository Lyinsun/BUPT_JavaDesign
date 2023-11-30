import java.io.*;

public class BitOutPutStreamTest {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        BitOutPutStream bos;
        try {
            fos = new FileOutputStream("output");
            bos = new BitOutPutStream(fos);
            for (int i = 0; i < 10; i++) {
                bos.writeBit('0');
                bos.writeBit('1');
            }
            bos.writeBit("01010101010101011");
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

