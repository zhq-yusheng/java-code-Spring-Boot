import java.util.Arrays;

public class Test implements TestTT {

    @Override
    public void test() {
        System.out.println("111");
    }

    @Override
    public void test1() {
        System.out.println("22222");
    }

    public static void main(String[] args) {
        //new Test().test1();
        //Arrays.asList(new Test[]{new Test(),new Test()}).forEach();
    }
}
