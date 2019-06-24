package initiallization;

import javax.annotation.PostConstruct;

/**
 * 测试子类初始化是否会调用父类的init方法
 */
public class BaseDao {
    
    private String test;
    
    @PostConstruct
    public void init() {
        System.out.println("BaseDao inti start");
        test = "test";
    }
}
