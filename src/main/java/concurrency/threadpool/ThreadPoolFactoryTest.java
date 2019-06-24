package concurrency.threadpool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolFactoryTest {
    
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10,
                200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));
        for (int i = 0; i < 20; i++) {
            MyTask myTask = new MyTask(i);
            System.out.println("向线程池添加任务task: " + myTask.taskNum);
            threadPoolExecutor.execute(myTask);
            System.out.println("线程池中线程数: " + threadPoolExecutor.getPoolSize() +
                    "，队列中等待执行的线程数: " + threadPoolExecutor.getQueue().size() +
                    "已执行完的任务数: " + threadPoolExecutor.getQueue().size());
        }
        
    }
    
    
    static class MyTask implements Runnable {
        
        private int taskNum;
    
        public MyTask(int taskNum) {
            this.taskNum = taskNum;
        }
    
        @Override
        public void run() {
            System.out.println("正式执行task: " + taskNum);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }
}
