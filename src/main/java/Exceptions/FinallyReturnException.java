package Exceptions;

/**
 *  * FinallyReturnException
 *  *
 *  * @author xiaoqi
 *  * @since 24 七月 2018
 *  
 */
public class FinallyReturnException {

    public static void main(String[] args) {

       test();
    }


    public static boolean test () {
        try {
            Integer.valueOf("哈哈");
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("catch........");
            return true;
        } finally {
            System.out.println("finally.......");
        }
    }
}
