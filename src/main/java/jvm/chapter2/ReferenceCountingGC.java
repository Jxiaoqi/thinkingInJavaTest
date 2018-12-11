package jvm.chapter2;

/**
 * 引用计数算法的缺陷： 对象之间相互循环引用的问题
 *      查看GC日志的方法：
 *      https://blog.csdn.net/u011767040/article/details/49180973
 *
 *      GC日志
 *      [GC [PSYoungGen: 6799K->4627K(38912K)] 6799K->4627K(125952K), 0.0027970 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 [Full GC [PSYoungGen: 4627K->0K(38912K)] [ParOldGen: 0K->4548K(87040K)] 4627K->4548K(125952K) [PSPermGen: 3132K->3131K(21504K)], 0.0106470 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
 Heap
 PSYoungGen      total 38912K, used 2365K [0x00000007d5500000, 0x00000007d8000000, 0x0000000800000000)
 eden space 33792K, 7% used [0x00000007d5500000,0x00000007d574f6b8,0x00000007d7600000)
 from space 5120K, 0% used [0x00000007d7600000,0x00000007d7600000,0x00000007d7b00000)
 to   space 5120K, 0% used [0x00000007d7b00000,0x00000007d7b00000,0x00000007d8000000)
 ParOldGen       total 87040K, used 4548K [0x0000000780000000, 0x0000000785500000, 0x00000007d5500000)
 object space 87040K, 5% used [0x0000000780000000,0x0000000780471110,0x0000000785500000)
 PSPermGen       total 21504K, used 3146K [0x000000077ae00000, 0x000000077c300000, 0x0000000780000000)
 object space 21504K, 14% used [0x000000077ae00000,0x000000077b112b18,0x000000077c300000)


        GC日志包含 Full GC [PSYoungGen: 4627K->0K(38912K)]，意味着虚拟机并没有因为这两个对象互相引用就不回收它们，
    也从侧面证明了虚拟机并不是通过引用计数算法来判断对象是否存活的
 *
 *
 * @author xiaoqi
 * @since 25 十月 2018
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        System.gc();

    }

    public static void main (String[] args) {
        testGC();
    }
}
