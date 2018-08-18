package rtti;


import java.util.Arrays;
import java.util.List;

/**
 *  *   1.如果某个对象出现在字符串表达式中（涉及 "+" 和字符串对象的表达式）， toString 方法就会被自动调用， 以生成该对象的String
 *  *
 *  * @author xiaoqi
 *  * @since 16 八月 2018
 *  
 */

abstract class Shape {
    void draw () {
        System.out.println(this + ".draw()");
    }
}

class Circle extends Shape {
    @Override
    public String toString () {
        return "circle";
    }
}

class Square extends Shape {
    @Override
    public String toString () {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString () {
        return "Triangle";
    }
}

/**
 * Shapes
 *
 * @author
 */
public class Shapes {
    public static void main (String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Circle(), new Square(), new Triangle());
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    /**
     * circle.draw()
     Square.draw()
     Triangle.draw()
     */
}



