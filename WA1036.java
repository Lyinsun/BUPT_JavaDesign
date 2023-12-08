import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WA1036 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> strArr = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            if (input.hasNextLine()) {
                String str = input.nextLine();
                strArr.add(str);
                if (Objects.equals(str, "aa")){
                    break;
                }
            }
        }

        for (String s : strArr) {
            int count = countPalindromicSubstrings(s);
            System.out.println(count);
        }
    }

    public static int countPalindromicSubstrings(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                // 检查从 left 到 right 的子串是否是回文
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
