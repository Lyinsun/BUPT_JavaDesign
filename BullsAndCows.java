import java.util.Arrays;
import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] args) {
//        生成数字
        char[] arr = new char[4];
//        需要使用动态数组
//        int[] numArr = new int[10];
//        for(int i = 0;i<numArr.length;i++){
//            numArr[i] = i+1;
//        };

        for(int i=0;i<4;i++){
            if(i==0) {
//                String str = String.valueOf((int) (Math.random() * 9+1));
//                arr[i]= str.toCharArray();
                arr[i] = (char)((int) (Math.random() * 9+1)+48);
            } else {
                boolean confirm = false;
                do {
                    char numTest = (char)((int)(Math.random()*10)+48);
                    arr[i] = numTest;
                    for (int j = 0; j < i; j++) {
                        confirm = confirm|(arr[j] == numTest);
                    }
                }while (confirm);
            }
        }

        System.out.print("输出:");
        for (char value : arr) {
            System.out.print(value);
        }
        System.out.println();
//        检测
          //题目所需的输出
        int A = 0, B = 0;
        do{
            A = 0; B = 0;
            System.out.print("本次猜测的四位数为1000~9999,且没有重复:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
//            判断输入是否为4位数
            if(input.length()!=4){
                System.out.print("请输入四位数,");
                continue;
            }

            char[] inputArr = input.toCharArray();
            int[] analyse = new int[4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < arr.length; j++) {
//                数字匹配上的时候
                    if (inputArr[i] == arr[j]) {
//                    位置对上
                        if (i == j) {
                            A++;
                            analyse[j]++;
                        }
//                    位置没对上
                        else {
                            B++;
                            analyse[j]++;
                        }
                    }
//              考虑用户可能重复输入, 剔除B对重复数字的统计.
                    if (analyse[j] > 1) {
                        analyse[j]--;
                        B--;
                    }
                }
            }
            System.out.println(Arrays.toString(analyse));
            System.out.println("A" + A + "B" + B);
        }while (!((A==4)&&(B==0)));

    }
}

