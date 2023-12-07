import java.util.ArrayList;
import java.util.Scanner;

public class WA1000 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arr = input.nextInt();
        ArrayList<Double> numbers = new ArrayList<>();
        for (int i = 0; i < arr; i++) {
            double add1 = input.nextDouble();
            double add2 = input.nextDouble();
            numbers.add(add1+add2);
        }

        for (double number : numbers) {
            //这里格式化的时候, 利用replace替换了末尾的0,以及末尾的小数点.   $指末位匹配, *表示不限数量, \\转义符号用来解释., 不然'.'表示匹配任意字符
            String formattedNumber = String.format("%.6f", number).replaceAll("0*$", "").replaceAll("\\.$", "");
            System.out.println(formattedNumber);
        }

/*        Scanner input = new Scanner(System.in);
        int arr = input.nextInt();
        float[] numbers = new float[arr];
        for (int i = 0; i < arr; i++) {
            float add1 = input.nextFloat();
            float add2 = input.nextFloat();
            numbers[i] = add1+add2;
        }

        for (float number : numbers) {
            System.out.println(number);
        }*/
    }
}
