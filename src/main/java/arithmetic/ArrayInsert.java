package arithmetic;

public class ArrayInsert {
	
	/**
	 *  在线性表的第i-1个元素 和第 i个元素之间插入一个新的数据元素, 使得线性表的长度增加一个元素空间
	 * @param array 原数组
	 * @param i	  插入新元素的位置 
	 * @param element 插入的元素
	 * @return
	 */
	public static int[]  insert(int[] array, int i, int element){
		if (i > array.length-1 || i < 0) {
			System.out.println("i not exist");
			return array;
		}
		for (int j = array.length-1; j >= i-1; j--) {
			array[j] = array[j-1];
		}
		array[i-1] = element;
		//@Deprecated
		//array.length = array.length + 1;
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4};
		array = insert(array, 1, 2);
		System.out.println(array);
	}

}
