import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountKeywords {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
//        System.out.println("Enter a Java source file: ");
//        String filename = input.nextLine();
        String filename = "Ch21Q03_TestFile.java";

        File file = new File(filename);
        if(file.exists()){
            System.out.println("The number of keywords in " + filename
                + " is " + countKeywords(file));
        }
        else{
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception{
        String[] keywordString = {
                "abstract", "assert", "boolean", "break",
                "byte", "case", "catch","char", "class",
                "const", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import",
                "instanceof", "int", "interface", "long",
                "native", "new", "package", "private", "protected",
                "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw",
                "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"
        };
        Set<String> keywordSet =
                new HashSet<>(Arrays.asList(keywordString));

        int count = 0;
        Scanner inputFile = new Scanner(file);
//        StringBuilder content = new StringBuilder();        //处理后的文本
        boolean inComment = false;                          //注释标记, 如果在多行注释内的话
        while (inputFile.hasNextLine()){
//            System.out.println("inputLine循环");
            String line = inputFile.nextLine();
            //处理单行注释
            int index = line.indexOf("//");
            if (index != -1){
                line = line.substring(0,index);
            }

            //处理内部注释
            boolean comsModified = false;
            do {
//                System.out.println("多注释循环");
                int comStartIndex = line.indexOf("/*");
                int comEndIndex = line.indexOf("*/");
                comsModified = (comStartIndex == -1)&&(comEndIndex == -1);  //同时找到两个才可以
                if(comStartIndex<comEndIndex){
                    String lineTemp = line.substring(0,comStartIndex);
                    if (comEndIndex+1 == line.length()){
                        line = lineTemp;
                    }
                    else {
                        line = lineTemp + line.substring(comEndIndex+2);
                    }
                }
            } while (!comsModified);
            String[] tokens = line.split("[\\s\\(\\)\\{\\}]");

            for (int i = 0; i < tokens.length; i++) {
                if(keywordSet.contains(tokens[i])){
                    count++;
                    System.out.print(tokens[i] + " ");
                }
            }
        }


/*        while(input.hasNext()){
            String word = input.next();
            if(keywordSet.contains(word)) {
                count++;
                System.out.print(word + " ");
            }   
        }*/
        System.out.println();
        return count;
    }
}
