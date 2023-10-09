import java.util.Scanner;

public class GuessWord {
    public static void main(String[] args) {
        String[] words = { "banana", "telecommunication", "program", "university", "beijing", "posts" };
        var length = words.length;
//        猜测的答案本体
        var selectWord = words[(int) (Math.random() * length+1)];
//        输出掩码字符数组,和用于判断逻辑
        int[] wordAnswer = new int[selectWord.length()];
        boolean isTrue = false;
        int counts = 0;
        do {
//            生成输出的掩码字符
            String guessWord = "";
            for (int i = 0; i < selectWord.length(); i++) {
                if(wordAnswer[i] == 0){
                    guessWord = guessWord.concat("*");
                }else {
                    guessWord = guessWord.concat(String.valueOf(selectWord.charAt(i)));
                }
            }
            System.out.print("(Guess) Enter a letter in word "+ guessWord +" >");
            Scanner scanner = new Scanner(System.in);
            String letter = scanner.next();


//          判断字符是否正确
            int position = selectWord.indexOf(letter);
            while (position!=-1) {
                if(wordAnswer[position] == 1) {
//                  保存最后一次的匹配位置
                    if (selectWord.indexOf(letter, position + 1)==-1){
                        break;
                    }else {
                        position = selectWord.indexOf(letter, position + 1);
                    }
                }else {
                    break;
                }
            }
//          数据处理
            if(position != -1){
                if(wordAnswer[position] == 1) {
                    System.out.println(letter + " is already in the word");
                }else {
                    wordAnswer[position] = 1;
                }
            }else {
                System.out.println(letter+" is not int the word");
                counts++;
            };

        }while (!WordVerify(wordAnswer));
        System.out.println("The word is " + selectWord+". You missed "+counts+"times");
    }

    public static boolean WordVerify(int[] wordAnswer){
        int sum = 0;
        for (int j : wordAnswer) {
            sum += j;
        }
        return sum == wordAnswer.length;

    }

}
