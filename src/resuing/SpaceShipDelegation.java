package resuing;

/**
 * 代理的使用.
 * 	我们使用代理时可以拥有比继承更多的控制力,因为我们可以选择只提供在成员对象中的方法的某个子集.
 * @author admin
 *
 */
public class SpaceShipDelegation {
	private String name;
	private SpaceShipControls controls = 
					new SpaceShipControls();
	public SpaceShipDelegation(String name) {
		this.name = name;
	}
	
	//暴露出来的方法
	public void back(int velocity) {
		controls.back(velocity);
	}
	public void down(int velocity) {
		controls.down(velocity);
	}
	public void forward(int velocity) {
		controls.forward(velocity);
	}
	public void left(int velocity) {
		controls.left(velocity);
	}
	public void right(int velocity) {
		controls.right(velocity);
	}
	public void truboBoost(int velocity) {
		controls.truboBoost(velocity);
	}
	public void up(int velocity) {
		controls.up(velocity);
	}
	
	public static void main(String[] args) {
		SpaceShipDelegation protector = 
				new SpaceShipDelegation("NSEA protector");
		protector.forward(100);
	}

}
