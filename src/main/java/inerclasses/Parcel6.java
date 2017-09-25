package inerclasses;

/**
 * 在方法和作用域中的内部类----在任意的作用域内嵌入一个内部类
 * 		TrackingSlip类被嵌入在if语句中的作用域内,这并不是说类的创建是有条件的,
 * 它其实是与别的类一起编译过了.然而,在定义TrackingSlip的作用域之外,它是不可用的.
 * @author admin
 *
 */
public class Parcel6 {
	private void internalTracking(boolean b) {
		if (b) {
			class TrackingSlip {
				private String id;
				
				TrackingSlip(String s) {
					id = s;
				}				
				String getSlip() {
					return id;
				}
			}
			
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
		}
		//Can't use it here! out of scope:
		//!TrackingSlip ts = new TrackingSlip("slip");
	}
	
	public void track() { internalTracking(true);}
	
	public static void main(String[] args) {
		Parcel6 p = new Parcel6();
		p.track();
	}
}
