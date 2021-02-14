package app.service;

import app.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//调用spring容器
@RunWith(SpringRunner.class)
//springboot项目中的测试类必须加@SpringBootTest注解
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void queryById() {
        User user = userService.queryById(3L);
        System.out.println("user = " + user);
    }

    //存在事务控制，有异常会回滚
    @Test
    public void saveUser() {
        User user = new User();
        user.setUserName("test");
        user.setName("test");
        user.setAge(13);
        user.setPassword("123456");
        user.setSex(1);
        user.setBirthday(new Date());
        user.setCreated(new Date());

        userService.saveUser(user);
    }
}