import java.util.Scanner;

public class OJ_1036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) { // 不断读取输入字符串
            String s = scanner.nextLine();
            int l = s.length();
            int k = 0; // 回文串的个数

            for (int i = 0; i < l; i++) { // 遍历字符串
                for (int j = 0; i - j >= 0 && i + j < l; j++) {
                    // 每个字符都是一个回文串，然后判断当前字符的前一个和后一个字符是否相等，
                    // 若相等个数k++
                    if (s.charAt(i - j) == s.charAt(i + j)) {
                        k++;
                    } else {
                        break;
                    }
                }
                if (i + 1 >= l || s.charAt(i) != s.charAt(i + 1)) {
                    continue; // 判断当前字符是否与下一个字符相等，不等则跳转下一个循环
                }
                for (int j = 0; i - j >= 0 && i + 1 + j < l; j++) {
                    // 相等则判断下一个的字符的前一个字符与后一个字符是否相等，
                    // 若相等个数k++
                    if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                        k++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(k); // 输出个数k；
            if (k!=3&&k!=4){
                System.out.print(s);
            }
        }
    }
}