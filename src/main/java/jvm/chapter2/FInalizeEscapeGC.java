package jvm.chapter2;

/**
 *  生存还是死亡
 *      演示对象即将被回收时，逃离回收，并演示 finalize()方法始终只会执行一次，而且并不代表执行了对象就会被回收
 *      可达性分析算法： 可达性状态和finalize的状态标记
 *          https://www.cnblogs.com/smilesmile/p/3849122.html
 *
 *
 * @author xiaoqi
 * @since 25 十月 2018
 */
public class FInalizeEscapeGC {

    public static FInalizeEscapeGC SAVA_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive : ");
    }

    @Override
    protected void finalize () throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FInalizeEscapeGC.SAVA_HOOK = this;
    }

    public static void main (String[] args) throws InterruptedException {

    }
}
