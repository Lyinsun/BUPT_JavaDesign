import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 摩尔斯电码实验
 * @author Young
 * @version 1.0
 * @since 2023
 *
 */
public class MorseCodeSkel {
    private static final String[] symbols = new String[]{
            "-----", ".----", "..---", "...--", "....-", // 0-4
            ".....", "-....", "--...", "---..", "----.", // 5-9
            ".-", "-...", "-.-.", "-..", ".", "..-.",    // A-F
            "--.", "....", "..", ".---", "-.-", ".-..",  // G-L
            "--", "-.", "---", ".--.", "--.-", ".-.",    // M-R
            "...", "-", "..-", "...-", ".--", "-..-",    // S-X
            "-.--", "--.."};                            // Y Z
    private static final String[] lettersCode = new String[]{
            "0","1","2","3","4",
            "5","6","7","8","9",
            "A","B","C","D","E","F",
            "G","H","I","J","K","L",
            "M","N","O","P","Q","R",
            "S","T","U","V","W","X",
            "Y","Z",
    };
    /**
     * 编码函数，用于将文字转换为摩尔斯电码
     * @param input 输入文字
     * @return 生成的摩尔斯电码
     */
    public static String letter2morse(String input) {
        String[] tokens = input.split("\\s+");
        String[] strArray = new String[tokens.length];
        /*寻找字符*/
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < lettersCode.length; j++) {
                if(lettersCode[j].equals(tokens[i])){
                    strArray[i] = symbols[j];
                }
            }
        }
        /*匹配空格数*/
        String pattern = "\\s+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        for (int i = 0; i < tokens.length-1; i++) {
            if (m.find()) {
                int spacing = m.group().length();
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < spacing; j++) {
                    builder.append(" ");
                }
                strArray[i] = strArray[i]+builder.toString();
            }
        }
        String lettersDecode = "";
        for (String item : strArray) {
            lettersDecode += item;
        }

        return lettersDecode;
    }

    /**
     * 解码函数，用于将摩尔斯电码转换为文字
     * @param input 输入摩尔斯电码
     * @return 生成的文字
     */
    public static String morse2letter(String input) {
        String[] tokens = input.split("\\s+");
        String[] strArray = new String[tokens.length];
        /*寻找字符*/
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < symbols.length; j++) {
                if(symbols[j].equals(tokens[i])){
                    strArray[i] = lettersCode[j];
                }
            }
        }
        /*匹配空格数*/
        String pattern = "\\s+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        for (int i = 0; i < tokens.length-1; i++) {
            if (m.find()) {
                int spacing = m.group().length();
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < (spacing-1)/2; j++) {
                    builder.append(" ");
                }
                strArray[i] = strArray[i]+builder.toString();
            }
        }
        String lettersDecode = "";
        for (String item : strArray) {
            lettersDecode += item;
        }

        return lettersDecode;
    }

    /**
     * 主函数
     * @param args 命令行参数
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        System.out.println(letter2morse("E E"));


        File morse = new File("morse.txt");
        Scanner scanner1 = new Scanner(morse);
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            System.out.println(morse2letter(line));
        }
        scanner1.close();
        System.out.println("----------------");
        File text = new File("text.txt");
        Scanner scanner2 = new Scanner(text);
        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            System.out.println(letter2morse(line));
        }
        scanner2.close();
    }
}