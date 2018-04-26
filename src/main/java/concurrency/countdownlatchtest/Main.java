package concurrency.countdownlatchtest;

/**
 *  * 系统启动主线程
 *  *   http://www.importnew.com/15731.html
 *  * @author xiaoqi
 *  * @since 09 十二月 2017
 *  
 */
public class Main {

    public static void main (String[] args) {

        boolean result = false;
        try {
            result = ApplicationStartUpUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was " + result);
    }
}
