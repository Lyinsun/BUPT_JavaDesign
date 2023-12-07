import java.io.File;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class WA1014 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        //初始矩阵记录
        BigInteger[][] martrixFib = {{BigInteger.valueOf(0), BigInteger.valueOf(1)},{BigInteger.valueOf(1), BigInteger.valueOf(1)}};
        BigInteger[][] Fib = {{BigInteger.valueOf(1), BigInteger.valueOf(1)}};

        int count = n-2;
        BigInteger[][] martrix = martrixFib;

        if (n <= 2) {
            System.out.println(1);
        }
        else  {
            while (count >=1){
                //最小二乘法, 当count为奇数的时候,需要提出一次矩阵乘法
                if (count%2==1){
                    Fib = martrixMul(Fib,martrix);
                }
                martrix = martrixMul(martrix,martrix);
                count = count/2;
            }
            System.out.println(Arrays.deepToString(Fib));
            System.out.println(Fib[0][1].mod(BigInteger.valueOf(10007)));
        }

    }

    //矩阵相乘
    public static BigInteger[][] martrixMul(BigInteger[][] base, BigInteger[][] ans){
        int baserow = base.length;
        int basecol = base[0].length;
        int ansrow = ans.length;
        int anscol = ans[0].length;
        BigInteger[][] martrix = new BigInteger[baserow][anscol];
        //使用BigInteger的时候需要初始化
        for (int i = 0; i < baserow; i++) {
            for (int j = 0; j < anscol; j++) {
                martrix[i][j] = BigInteger.valueOf(0);
            }
        }

        if (basecol == ansrow) {
            for (int i = 0; i < baserow; i++) {
                for (int j = 0; j < anscol; j++) {
                    for (int k = 0; k < basecol; k++) {
//                        martrix[i][j] += base[i][k]*ans[k][j];
                        martrix[i][j] = martrix[i][j].add(base[i][k].subtract(ans[k][j]));
                    }
                }
            }
        }
        else {
            System.out.println("矩阵无法相乘,大小不一致");
        }

        return martrix;
    }
}
