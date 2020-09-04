package concurrency;

public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        BThread bt = new BThread();
        try {
            Thread.sleep(2000);
            Thread.currentThread().interrupt();
            bt.start();
            bt.join();
            
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(threadName + " end!");
    }
}
