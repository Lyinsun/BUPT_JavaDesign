import java.util.Scanner;

public class creditCardVerify {
    public static void main(String[] args) {
        System.out.println("Enter a credit card number as a Tong integer:");
        Scanner scanner= new Scanner(System.in);

        long cardId = scanner.nextLong();
        boolean b = isValid(cardId);
        if(b){
            System.out.println(cardId+ " is valid" );
        }else {
            System.out.println(cardId+ " is invalid" );
        }

    }
    public static  boolean isValid(long number){
        boolean verify = false;
        int length = getSize(number);
//        对偶数位和奇数位进行计算
        int sumDouble = sumOfDoubleEvenPlace(number);
        int sumOdd = sumOfOddPlace(number);
        int sumAll = sumOdd+sumDouble;
        if(sumAll%10 == 0){
            verify = true;
        }
        return verify;
    }
    public static int sumOfDoubleEvenPlace(long number){
        String numStr =  Long.toString(number);
        int sum = 0;
        int length = getSize(number);
//        确认长度为为偶数个
        if (length%2 == 0){
            for (int i = 0; i < length; i=i+2) {
                int doubleEach =  (charToInt(numStr,i))*2;
//                大于10的情况
                if(doubleEach>=10){
                    sum += doubleEach%10;
                    sum += 1;
                }
//                小于10的情况
                else {
                    sum += doubleEach;
                }
            }
        }
//        长度为奇数个的情况
        else {
            for (int i = 1; i < length; i+=2) {
                int doubleEach =  (charToInt(numStr,i))*2;
//                大于10的情况
                if(doubleEach>=10){
                    sum += doubleEach%10;
                    sum += 1;
                }
//                小于10的情况
                else {
                    sum += doubleEach;
                }
            }
        }
        return sum;
    }
    public static int sumOfOddPlace(long number){
        String numStr =  Long.toString(number);
        int sum = 0;
        int length = getSize(number);
        //        确认为长度偶数的情况,odd
        if (length%2 == 0){
            for (int i = 1; i < length; i=i+2) {
                int oddEach = charToInt(numStr,i);
                sum += oddEach;
            }
        }
//        长度为奇数个的情况
        else {
            for (int i = 0; i < length; i+=2) {
                int oddEach = charToInt(numStr,i);
                sum += oddEach;
            }
        }
        return sum;
    }
    public static int getDigit(int number){
        return 0;
    }
    public static boolean prefixMatched(int number, int d){
        return false;
    }
    public static int getSize(long d){
        return  Long.toString(d).length();
    }
    public static long getPrefix(long number, int k){
        String numString = Long.toString(number);
        return numString.charAt(k);
    }
//将string数的第position位转化为数字.
    public static int charToInt(String num, int position){
        return (int) num.charAt(position) -48;
    }
}
