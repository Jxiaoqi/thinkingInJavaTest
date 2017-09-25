package access;

//: access/Cake.java
// Accesses a class in a separate compilation unit.

class Cake {
  public static void main(String[] args) {
    Pie x = new Pie();
    x.f();
  }


  public void test() {
    System.out.println("aaaa");
  }

} /* Output:
Pie.f()
*///:~
