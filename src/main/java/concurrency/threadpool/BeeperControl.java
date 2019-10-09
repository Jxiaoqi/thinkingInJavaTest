package concurrency.threadpool;

import java.util.concurrent.*;

public class BeeperControl {
    
    private ScheduledExecutorService schedule = Executors.newScheduledThreadPool(10);
    
    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
        
            @Override
            public void run() {
                System.out.println("beep");
            }
        };
    
        ScheduledFuture<?> beeperHandle = schedule.scheduleAtFixedRate(beeper, 0, 10, TimeUnit.SECONDS);
        schedule.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandle.cancel(true);
            }
        }, 60 * 60, TimeUnit.SECONDS);
    }
    
    public static void main(String[] args) {
        BeeperControl beeperControl = new BeeperControl();
        beeperControl.beepForAnHour();
    }
}
