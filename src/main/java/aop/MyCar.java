package aop;

public class MyCar implements Car {
    @Override
    public void lock() throws Exception {
        System.out.println("锁车");
        throw new Exception("锁车抛出异常了");
    }
}
