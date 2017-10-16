package arithmetic;


/**
 * 二分查找算法
 * 在给定的有序数组中查找制定K值
 * 时间复杂度为: log2 n
 * @author admin
 *
 */
public class BinarySearch {
	
	
	/**
	 * 二分查找算法
	 * @param k   在给定数组中查找的 K 
	 * @param array	给定的有序数组
	 * @return 该值对应的数组元素的下标
	 */
	public static int binary(int k, int[] array) {
		int l = 0;
		int r = array.length;
		int middle = (l + r) / 2;
		while (l <= r && r >= 0) {
			if (k < array[middle]) {
				r = middle;
			}
			if (k > array[middle]) {
				l = middle;
			}
			if (k == array[middle]) {
				return middle;
			}
			middle = (l+r)/2;
		}
		return -1;
	}
	
	
	
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5};
		int a = binary(5, array);
		System.out.println(a);
		
	}

}
