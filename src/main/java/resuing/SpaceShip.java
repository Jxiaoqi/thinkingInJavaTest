package resuing;

/**
 * 利用继承 构造太空飞船.
 * 	然而,SpaceShip并非真正的额SpaceShipController类型,更准确地瘦
 * 		SpaceShip包含了SpaceShipController, 同时,controller中 的所有方法
 * 		在SpaceShip中都暴露了出来.
 * 	此时,就用到了代理
 * @author admin
 *
 */
public class SpaceShip extends SpaceShipControls {
	
	private String name;
	public SpaceShip(String name) {
		this.name = name;
	}
	@Override
	public String toString() { return name; }
	
	public static void main(String[] args) {
		SpaceShip spaceShip = new SpaceShip("NSEA protector");
		spaceShip.forward(100);
	}
}
