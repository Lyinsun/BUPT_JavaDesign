import java.util.Scanner;

public class WA1008 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] numsArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                numsArr[j][i] = i*N+j+1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(numsArr[i][j]);
                if (j<N-1){
                    System.out.print(" ");
                }
            }
            System.out.println(); // 换行
        }
    }
}
