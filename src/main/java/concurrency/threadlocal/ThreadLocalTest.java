package concurrency.threadlocal;

public class ThreadLocalTest {
    
    public static final ThreadLocal<ThreadLocalTest> LOCAL =
            ThreadLocal.withInitial(() -> new ThreadLocalTest());
    
    public ThreadLocalTest() {
        System.out.println("ThreadLocalTest() init......");
    }
    
    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(ThreadLocalTest.LOCAL);
        System.out.println(ThreadLocalTest.LOCAL.get());
    
    }
    
    
}
