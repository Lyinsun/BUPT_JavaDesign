import java.util.Date;
import java.util.Scanner;

public class WA1035 {
/*    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Lists = input.nextInt();
        double[] numDoubleArr = new double[Lists];
        int[] IndexArr = new int[Lists];
        for (int i = 0; i < Lists; i++) {
            numDoubleArr[i] = input.nextDouble();
            IndexArr[i] = input.nextInt();
        }

        for (int i = 0; i < Lists; i++) {

            String numString = Double.toString(numDoubleArr[i]);
            int decimalIndex = numString.indexOf('.');
            if (decimalIndex != -1 && decimalIndex + IndexArr[i]  < numString.length()) {
                System.out.println(numString.charAt(decimalIndex + IndexArr[i]));
            }
        }
    }*/

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Lists = input.nextInt();
        //此处需要多一个nextLine将读取到的回车排除掉，因为nextInt并不会读取回车，二nextLine会， 这就会导致第一次的nextLine会读取到一个空的值
        input.nextLine();
        String[] numStringArr = new String[Lists];
        int[] IndexArr = new int[Lists];
        for (int i = 0; i < Lists; i++) {
            String line = input.nextLine();
            String[] parts = line.split(" ");
            numStringArr[i] = parts[0];
            IndexArr[i] = Integer.parseInt(parts[1]);
        }

        for (int i = 0; i < Lists; i++) {
            int decimalIndex = numStringArr[i].indexOf('.');
            if (decimalIndex != -1 && decimalIndex + IndexArr[i]  < numStringArr[i].length()) {
                System.out.println(numStringArr[i].charAt(decimalIndex + IndexArr[i]));
            }
            //超出小数后的情况，输出0      ！！！！！！
            else{
                System.out.println(0);
            }
        }
    }
}

