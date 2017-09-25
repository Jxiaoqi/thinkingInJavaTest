package resuing;
//: reusing/Car.java
// Composition with public objects.

/**
 * 组合技术通常用于想在新类中使用现有类的功能而非它的接口这种情形.
 *   即,在新类中嵌入某个对象,让其实现所需要的功能,但新类的用户看到的只是为新类定义的接口, 而非所嵌入对象的接口.
 * @author admin
 *
 */
class Engine {
  public void start() {}
  public void rev() {}
  public void stop() {}
}

class Wheel {
  public void inflate(int psi) {}
}

class Window {
  public void rollup() {}
  public void rolldown() {}
}

class Door {
  public Window window = new Window();
  public void open() {}
  public void close() {}
}

public class Car {
  public Engine engine = new Engine();
  public Wheel[] wheel = new Wheel[4];
  public Door
    left = new Door(),
    right = new Door(); // 2-door
  public Car() {
    for(int i = 0; i < 4; i++)
      wheel[i] = new Wheel();
  }
  public static void main(String[] args) {
    Car car = new Car();
    car.left.window.rollup();
    car.wheel[0].inflate(72);
  }
} ///:~
