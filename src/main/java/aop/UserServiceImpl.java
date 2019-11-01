package aop;

import java.util.Random;

public class UserServiceImpl implements UserService{
    @Override
    public void login(String userName, String password) {
        try {
            Thread.sleep(new Random(47).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("UserService: 用户： " + userName + "登陆成功");
    }
}
