package app.controller;

import app.pojo.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

//SpringBoot提供的注解，里边包含@Controller注解和@ResponseBody注解，所以方法返回的是字符串
@RestController
public class HelloController {

    //注入数据库
    @Autowired
    private DataSource dataSource;

    @Value("${baidu.url}")
    private String baiduUrl;

    @Value("${google.url}")
    private String googleUrl;

    //注入service
    @Autowired
    private UserService userService;

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 用户
     * */
    @GetMapping("/user/{id}")
    public User queryById(@PathVariable Long id) {
        return userService.queryById(id);
    }

    @GetMapping("hello")
    public String hello(){
        System.out.println("baiduUrl = " + baiduUrl);
        System.out.println("googleUrl = " + googleUrl);
        System.out.println("Datasource = " + dataSource);
        return "Hello, Spring Boot";
    }
}
