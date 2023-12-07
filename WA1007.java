import java.util.ArrayList;
import java.util.Scanner;

public class WA1007 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int persons = input.nextInt();
        int num = input.nextInt();
        ArrayList<Integer> personArr = new ArrayList<>();
        for (int i = 1; i <= persons; i++) {
            personArr.add(i);
        }

        int count = 0;
        while (personArr.size() >1){
            //计数的人是下一个人进行报数.  减一是为了计算索引值,因为索引值是从0开始.
            count = (count+num-1)%personArr.size();
            personArr.remove(count);
        }

        System.out.println(personArr.get(0));
    }
}
