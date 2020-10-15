package concurrency.threadlocal;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class SessionContext {
    
    public static final ThreadLocal<SessionContext> CONTEXT =
            ThreadLocal.withInitial(() -> new SessionContext());

//    public static final String CONTEXT =  "test";
    
    public SessionContext() {
        System.out.println("SessionContext() init......");
    }
    
    public static SessionContext get() {
        return CONTEXT.get();
    }
    
    public static void init() {
        System.out.println("init....");
    }
    
    public static void main(String[] args) {
//        SessionContext sessionContext = new SessionContext();
//        SessionContext.get();
        init();
        System.out.println("start");
    }
}
