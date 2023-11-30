import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BitOutPutStream extends FilterOutputStream {
    private int buffer;
    private int count;

    public BitOutPutStream(OutputStream out) {
        super(out);
        buffer = 0;
        count = 0;
    }

    public void writeBit(char bit) throws IOException {
        if (!(bit == '0' || bit == '1')) {
            throw new IllegalArgumentException("Input must be '0' or '1'");
        }

        buffer = (buffer << 1) | (bit - '0');
        count++;

        if (count == 8) {
            out.write(buffer);
            buffer = 0;
            count = 0;
        }
    }

    public void writeBit(String bits) throws IOException {
        for (char bit: bits.toCharArray()) {
            writeBit(bit);

        }
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("Use writeBit methods to write bits");
    }

    @Override
    public void flush() throws IOException {
        if (count > 0 && count < 8) {
            // Fill the remaining bits with zeros
            buffer <<= (8 - count);
            out.write(buffer);
            buffer = 0;
            count = 0;
        }
        super.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        super.close();
    }

    public static void main(String[] args) {
        try (BitOutPutStream bos = new BitOutPutStream(new FileOutputStream("Exercise17_17.dat"))) {
            for (int i = 0; i < 10; i++) {
                bos.writeBit('0');
                bos.writeBit('1');
            }
            bos.writeBit("01010101010101011");
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
