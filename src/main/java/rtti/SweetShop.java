package rtti;

import static util.Print.*;

/**
 *  *
 *  *
 *  * @author xiaoqi
 *  * @since 16 八月 2018
 *  * @see Class.forName()
 */



public class SweetShop {
    public static void main (String[] args) {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\");");
        new Cookie();
        print("After creating Cookie");

        /**
         * inside main
         Loading Candy
         After creating Candy
         Couldn't find Gum
         After Class.forName("Gum");
         Loading Cookie
         After creating Cookie
         */
    }
}

class Candy {
    static {
        print("Loading Candy");
    }
}

class Gum {
    static {
        print("Loading Gum");
    }
}

class Cookie {
    static {
        print("Loading Cookie");
    }
}