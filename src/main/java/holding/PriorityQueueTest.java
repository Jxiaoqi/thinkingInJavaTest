package holding;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优先级队列
 * <p>
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265120632401152
 */
public class PriorityQueueTest {
    
    
    public static void main(String[] args) {
        
        String s = "A10";
        String substring = s.substring(1);
        System.out.println(substring);
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A10"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "A1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            String uNum1 = u1.number.substring(1);
            String uNum2 = u2.number.substring(1);
            System.out.println(uNum1 + "-" + uNum2);
            return Integer.valueOf(uNum1).compareTo(Integer.valueOf(uNum2));
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;
    
    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }
    
    public String toString() {
        return name + "/" + number;
    }
}


