package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot工程都有一个启动引导类，这时工程的入口类
 * 并在引导类上添加@SpringBootApplication
 * 注解@SpringBootApplication：标注SpringBoot的启动类，该注解具备多种功能
 * */
@SpringBootApplication
//扫描mybatis所有的业务mapper接口，不用每个类都加@Mapper注解
//@MapperScan("app.mapper")
//使用通用Mapper，引入tk.mybatis.spring.annotation.MapperScan
@MapperScan("app.mapper")
public class Application {
    public static void main(String[] args) {
        //代表运行SpringBoot的启动类，参数为SpringBoot启动类的字节码对象
        SpringApplication.run(Application.class, args);
    }
}
