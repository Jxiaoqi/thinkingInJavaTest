package interfaces;

/**
 * 接口中的域:
 * 		1.因为你放入接口中的任何域都自动是static 和 final的,所有接口就成为了一中很
 * 便捷的用来创建常量组的工具.因此在jave SE 5中可以看到以下代码.
 * 		2.java中标识具有常量初始值的static final 时,会使用大写字母的风格.接口中的
 * 域自动是public 的,所有没有显式指明这一点.
 * @author admin
 *
 */
public interface Months {
	int
		JANUARY = 1, FEBUARY = 2,  MARCH = 3,
		APRIL = 4, MAY = 5, JUNE = 6, JULY =7,
		AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10,
		NOVEMBER = 11, DECEMBER =12;
}
