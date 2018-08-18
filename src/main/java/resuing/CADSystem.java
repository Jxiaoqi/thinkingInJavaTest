//: reusing/CADSystem.java
// Ensuring proper cleanup.
package resuing;
import static util.Print.*;

/**
 *   确保正确清理
 *   1. 有时类要在其中生命周期内执行一些必需的清理活动
 *   2. 首要任务就是,必须将这一清理活动置于finally 子句之中,以预防异常的发生.
 *   3. 执行类的所有清理动作,其顺序同生成顺序相反,
 * @author admin
 *
 */
class Shape {
  Shape(int i) { print("Shapes constructor"); }
  void dispose() { print("Shapes dispose"); }
}

class Circle extends Shape {
  Circle(int i) {
    super(i);
    print("Drawing Circle");
  }
  void dispose() {
    print("Erasing Circle");
    super.dispose();
  }
}

class Triangle extends Shape {
  Triangle(int i) {
    super(i);
    print("Drawing Triangle");
  }
  void dispose() {
    print("Erasing Triangle");
    super.dispose();
  }
}

class Line extends Shape {
  private int start, end;
  Line(int start, int end) {
    super(start);
    this.start = start;
    this.end = end;
    print("Drawing Line: " + start + ", " + end);
  }
  void dispose() {
    print("Erasing Line: " + start + ", " + end);
    super.dispose();
  }
}

public class CADSystem extends Shape {
  private Circle c;
  private Triangle t;
  private Line[] lines = new Line[3];
  public CADSystem(int i) {
    super(i + 1);
    for(int j = 0; j < lines.length; j++)
      lines[j] = new Line(j, j*j);
    c = new Circle(1);
    t = new Triangle(1);
    print("Combined constructor");
  }
  public void dispose() {
    print("CADSystem.dispose()");
    // The order of cleanup is the reverse
    // of the order of initialization:
    t.dispose();
    c.dispose();
    for(int i = lines.length - 1; i >= 0; i--)
      lines[i].dispose();
    super.dispose();
  }
  public static void main(String[] args) {
    CADSystem x = new CADSystem(47);
    try {
      // Code and exception handling...
    } finally {
      x.dispose();
    }
  }
} /* Output:
Shapes constructor
Shapes constructor
Drawing Line: 0, 0
Shapes constructor
Drawing Line: 1, 1
Shapes constructor
Drawing Line: 2, 4
Shapes constructor
Drawing Circle
Shapes constructor
Drawing Triangle
Combined constructor
CADSystem.dispose()
Erasing Triangle
Shapes dispose
Erasing Circle
Shapes dispose
Erasing Line: 2, 4
Shapes dispose
Erasing Line: 1, 1
Shapes dispose
Erasing Line: 0, 0
Shapes dispose
Shapes dispose
*///:~
