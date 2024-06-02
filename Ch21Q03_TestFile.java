// Ch21Q03 Test File

// public static void main
public class Ch21Q03_TestFile {
    public static void main(String[] args) {
        System.out.println("a public class Test" + new String("hello") + " long value.");
        Test t = new Test();
        t.test();
    }
}

/* this is a class */
class Test {
    void test() {
        int i;
        int j = 3; // 定义并初始化变量 j
        int k = 3; // 定义并初始化变量 k

        for (i = 0; i < 1000; i++) {
            System.out.println(i);
            i += j;
        }
        System.out.println("I am an instanceof Test");
    }
}
