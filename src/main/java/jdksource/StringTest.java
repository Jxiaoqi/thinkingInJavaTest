package jdksource;

import org.junit.Test;

import java.util.Date;
import java.util.Locale;

/**
 * java.lang.String 类的相关方法
 */
public class StringTest {
    
    @Test
    public  void formatTest() {
        String str = String.format("Hi, %s", "snow");
        System.out.println(str);
        
        str = String.format("Hi,%s:%s.%s", "snow", "aliya", "sansa");
        System.out.println(str);
    
        //char类型用'A'
        System.out.printf("字母a的大写是: %c %n", 'A');
        //%b
        System.out.printf("3>7的结果是: %b %n", 3>7);
        //%d
        System.out.printf("100的一半是：%d %n", 100/2);
        //%x 16进制
        System.out.printf("100的16进制数是： %x %n", 100);
        //%o 8进制
        System.out.printf("100的8进制数是: %o %n", 100);
        //%f 浮点数
        System.out.printf("50元的书打8.5折是: %f 元%n", 50*0.85);
        //%a 十六进制浮点类型
        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
        //%e 指数类型
        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
        //%g 通用浮点类型（f和e类型中较短的）
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
        //%% 百分比类型
        System.out.printf("上面的折扣是%d%% %n", 85);
        //%h 散列码
        System.out.printf("字母A的散列码是：%h %n", 'A');
    
        //$使用
        str=String.format("格式参数$的使用：%1$d,%2$s", 99,"abc");
        System.out.println(str);
        //+使用
        System.out.printf("显示正负数的符号：%+d与%d%n", 99,-99);
        //补O使用
        System.out.printf("最牛的编号是：%03d%n", 7);
        //空格使用
        System.out.printf("Tab键的效果是：% 8d%n", 7);
        //.使用
        System.out.printf("整数分组的效果是：%,d%n", 9989997);
        //空格和小数点后面个数
        System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);
        Date date=new Date();
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);
    }
    
    @Test
    public void formDate() {
        Date date=new Date();
        //b的使用，月份简称
        String str=String.format(Locale.US,"英文月份简称：%tb",date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n",date);
        //B的使用，月份全称
        str=String.format(Locale.US,"英文月份全称：%tB",date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n",date);
        //a的使用，星期简称
        str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n",date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te",date);
    }

    @Test
    public void formatTime() {
        Date date = new Date();
        //H的使用
        System.out.printf("2位数字24时制的小时（不足2位前面补0）:%tH%n", date);
        //I的使用
        System.out.printf("2位数字12时制的小时（不足2位前面补0）:%tI%n", date);
        //k的使用
        System.out.printf("2位数字24时制的小时（前面不补0）:%tk%n", date);
        //l的使用
        System.out.printf("2位数字12时制的小时（前面不补0）:%tl%n", date);
        //M的使用
        System.out.printf("2位数字的分钟（不足2位前面补0）:%tM%n", date);
        //S的使用
        System.out.printf("2位数字的秒（不足2位前面补0）:%tS%n", date);
        //L的使用
        System.out.printf("3位数字的毫秒（不足3位前面补0）:%tL%n", date);
        //N的使用
        System.out.printf("9位数字的毫秒数（不足9位前面补0）:%tN%n", date);
        //p的使用
        String str = String.format(Locale.US, "小写字母的上午或下午标记(英)：%tp", date);
        System.out.println(str);
        System.out.printf("小写字母的上午或下午标记（中）：%tp%n", date);
        //z的使用
        System.out.printf("相对于GMT的RFC822时区的偏移量:%tz%n", date);
        //Z的使用
        System.out.printf("时区缩写字符串:%tZ%n", date);
        //s的使用
        System.out.printf("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n", date);
        //Q的使用
        System.out.printf("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n", date);
       
    }
    
    @Test
    public void learn1() {
        //字符串比较
        String str1 = "hello";
        String str2 = "hello";
        
        System.out.println(str1.equals(str2));
        
        System.out.println(str1 == str2);
        
        
        String str3 = new String("hello");
        
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));
        
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
    }
    
    @Test
    public void learn2() {
        String str1 = "hello";
        String str2 = "world";
        
        String str3 = str1 + str2;
        String str4 = "hello" + "world";
        
        System.out.println(str3.equals(str4));
        
        System.out.println(str3 == str4);
        
        String str5 = "helloworld";
        
        System.out.println(str3.equals(str5));
        System.out.println(str4.equals(str5));
        
        System.out.println(str3 == str5);
        System.out.println(str4 == str5);
    }
    
    
}
