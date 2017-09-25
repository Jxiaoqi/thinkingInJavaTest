package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}
class Power extends Snow {}
class Light extends Power {}
class Heavy extends Power {}
class Crusty extends Snow {}
class Slush extends Snow {}

/**
 * P397
 * 添加一组元素  
 *     Arrays.asList() 方法的限制是它对所产生的List的类型做出了最理想的假设，而并没有
 * 注意你的对它会赋予什么样的类型。
 * 		1.当试图创建snow2时，Arrays.asList()中只有Power类型，因此它会创建List<Power>
 * 而不是List<Snow>,
 * 		2.显式类型参数说明： 正如你从创建Snow4的操作中看到的，可以在Arrays.asList()中插入一个“线索”，以告诉编译器
 * 对于由Arrays.asList（）产生的List类型，实际的目标类型应该是什么，。这被称为：“显式类型参数说明”。
 * @author 贾玉豪
 *
 */
public class AsListInterface {
	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(
				new Crusty(), new Slush(), new Power());
		
		//Type mismatch: cannot convert from List<Power> to List<Snow>
		// Can't compile
		//List<Snow> snow2 =  Arrays.asList(	
		//		new Light(), new Heavy());
		
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(), new Heavy());
		
		List<Snow> snow4 = Arrays.<Snow>asList(
				new Light(), new Heavy());
		
	}
}
