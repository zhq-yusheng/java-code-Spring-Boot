@FunctionalInterface
public interface TestTT {
     public void test();
    default public void test1(){
        System.out.println("111");
    }
}
