package concurrency;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 *  * FutureTask
 *      http://www.importnew.com/25286.html
 *  *
 *  * @author xiaoqi
 *  * @since 09 五月 2018
 *  
 */
public class CallDemo {

    public static void main (String[] args) {


        Task task = new Task();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(task);
        executorService.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    static class Task implements Callable<Integer> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Integer call () throws Exception {
            System.out.println("Thread [" + Thread.currentThread().getName() +"] is running");
            int result = 0;
            for (int i = 0; i < 100; ++i) {
                result += i;
            }
            return result;
        }
    }
}
