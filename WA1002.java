import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class WA1002 {
    public static void main(String[] args) {
/*        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);*/
        Scanner input = new Scanner(System.in);
        LocalDate Date1;
        LocalDate Date2;
        int dateTime1;
        int dateTime2;
        while (input.hasNextLine()){
            String dateStr1 = input.nextLine();
            String dateStr2 = input.nextLine();
            dateTime1 = Integer.parseInt(dateStr1);
            dateTime2 = Integer.parseInt(dateStr2);
            //注意其中的取余运算, 100才是取后面两位.
            Date1 = LocalDate.of(dateTime1 / 10000, (dateTime1 % 10000) / 100, dateTime1 % 100);
            Date2 = LocalDate.of(dateTime2 / 10000, (dateTime2 % 10000) / 100, dateTime2 % 100);
            long daysDiff = Math.abs(Date1.until(Date2, ChronoUnit.DAYS)) + 1;
            System.out.println(daysDiff);
        }

    }
}
