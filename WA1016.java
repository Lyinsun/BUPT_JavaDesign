import java.util.Scanner;

public class WA1016 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberToCheck = input.nextInt(); // 要验证的数

        boolean found = false;
        for (int i = 2; i <= numberToCheck / 3; i++) {
            for (int j = i; j <= numberToCheck / 2; j++) {
                for (int k = j; k <= numberToCheck; k++) {
                    if (isPrime(i) && isPrime(j) && isPrime(k) && (i + j + k) == numberToCheck) {
                        System.out.println( i + " " + j + " " + k);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println(numberToCheck + " 不能表示为三个质数之和。");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
