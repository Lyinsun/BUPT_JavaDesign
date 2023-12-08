import java.util.ArrayList;
import java.util.Scanner;

public class WA1017 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.print(num+"=");

        ArrayList<Integer> numArr = primeFactors(num);
        System.out.print(numArr.get(0));
        for (int i = 1; i < numArr.size(); i++) {
            System.out.print("*"+numArr.get(i));
        }
    }

    public static ArrayList<Integer> primeFactors(int n){
        ArrayList<Integer> numArr = new ArrayList<>();
        while (n%2 == 0){
            numArr.add(2);
            n /=2;
        }

        for (int i = 3; i < Math.sqrt(n); i+=2 ) {
            while (n%i == 0){
                numArr.add(i);
                n /= i;
            }
        }
        //最后加上
        if (n!=1){
            numArr.add(n);
        }
        return numArr;
    }
}
