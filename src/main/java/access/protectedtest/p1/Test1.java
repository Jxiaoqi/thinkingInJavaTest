package access.protectedtest.p1;

import access.protectedtest.p11.Son11;

public class Test1 {
    
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        son1.f();
//        son1.clone();
    
        Son11 son11 = new Son11();
        son11.f();
//        son11.clone();
    }
}
