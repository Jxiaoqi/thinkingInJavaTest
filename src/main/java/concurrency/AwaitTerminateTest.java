package concurrency;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitTerminateTest {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("thread start");
                }
            };
            service.execute(run);
        }
//        service.shutdown();
        while(!service.awaitTermination(2, TimeUnit.SECONDS)){
            System.out.println("service not stop");
        }
        System.out.println("all thread complete");
    }
}
