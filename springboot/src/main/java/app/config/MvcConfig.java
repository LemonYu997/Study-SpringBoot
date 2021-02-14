package app.config;

import app.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//表明配置类
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    //注册拦截器
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    //添加拦截器到spring mvc拦截器链
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有路径
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*");
    }
}
