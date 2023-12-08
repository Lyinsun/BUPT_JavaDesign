import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WA1019 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (num <= 6 || num % 2 != 0){
            System.out.println("请输入大于6的偶数");
            return;
        }
        List<List<Integer>> numArrs = GoldbachConjecture(num);
//        System.out.println(numArrs);;
//        System.out.println(numArrs.size());
//        System.out.println(numArrs.get(0).size());
        //利用foreach的书写方式十分的简洁明了
        for (List<Integer> numArr : numArrs) {
            System.out.println(num + "=" + numArr.get(0) + "+" + numArr.get(1));
        }
    }

    public static List<List<Integer>> GoldbachConjecture(int number) {
        List<List<Integer>> numArrs = new ArrayList<>();
        for (int i = 2; i <= number / 2; i++) {
            if (isPrime(i) && isPrime(number - i)) {
                List<Integer> numPair = new ArrayList<>();
                numPair.add(i);
                numPair.add(number - i);

                numArrs.add(numPair);
            }
        }
        return numArrs;
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
