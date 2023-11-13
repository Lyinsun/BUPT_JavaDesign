import java.util.ArrayList;

public class StudentsGoalsTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        ArrayList<Integer> rightScore = new ArrayList<Integer>();
        ArrayList<Integer> errorScore = new ArrayList<Integer>();

        for (int i = 0; i < 15000; i++) {
            int number = (int)(Math.random()*150)+1;
            try {
                list.add(new Student(number));
                rightScore.add(number);
            } catch(ScoreExceedsMaxValueException e) {
                e.show();
                errorScore.add(number);
            }
        }

        System.out.println("正常成绩的平均值"+calculateAverage(rightScore));
        System.out.println("异常成绩的平均值"+calculateAverage(errorScore));

    }

    public static double calculateAverage(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            // 处理空列表的情况
            return 0.0;
        }

        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }

        // 使用平均值公式计算平均值
        return (double) sum / list.size();
    }
}



class ScoreExceedsMaxValueException extends Exception{
    private String message;
    public ScoreExceedsMaxValueException(){
        this.message = "成绩不该大于100,请核实";
    }
    public void show(){
        System.out.println(message);
    }
}

class Student {
    private String name;
    private int score;

    public Student(){
        this.name = "小明";
        this.score = 100;
    }

    public Student(String name, int score) throws ScoreExceedsMaxValueException {
        this.name = name;
        this.score = score;
        this.isScoreValid(score);
    }

    public Student(int score) throws ScoreExceedsMaxValueException {
        this.score = score;
        this.isScoreValid(score);
    }

    public void isScoreValid(int score) throws ScoreExceedsMaxValueException {
        if(score>100){
            throw new ScoreExceedsMaxValueException();
        }
    }

    public void setscore(int score) throws ScoreExceedsMaxValueException {
        this.score = score;
        this.isScoreValid(score);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getscore() {
        return score;
    }

    public String getName() {
         return name;
    }
}