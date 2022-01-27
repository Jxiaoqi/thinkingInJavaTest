package holding;

public class Test {
    
    public static void main(String[] args) {
        int a = 5; //0000 0101
        System.out.println(a << 600);
        
        int b = 6;
        swap(a, b);
    }
    
    public static void swap(int a, int b){
        if (a != b){
            a ^= b;
            b ^= a;
            a ^= b;
        }
        System.out.println("a = " + a + ", b = " + b);
    }
}
