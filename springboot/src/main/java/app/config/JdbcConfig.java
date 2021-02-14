package app.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//@Configuration  //声明配置类
//@PropertySource("classpath:jdbc.properties")    //配置文件
//@EnableConfigurationProperties(JdbcProperties.class)    //导入配置项类
public class JdbcConfig {

    //配置文件注入
    /*    //注入值
        @Value("${jdbc.url}")
        String url;
        @Value("${jdbc.driver}")
        String driver;
        @Value("${jdbc.username}")
        String username;
        @Value("${jdbc.password}")
        String password;

        @Bean
        public DataSource dataSource() {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            return dataSource;
        }*/

    //配置类注入
    /*    @Bean
    public DataSource dataSource(JdbcProperties jdbcProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcProperties.getDriver());
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());

        return dataSource;
    }*/

/*    //单个Bean注入
    @Bean
    //声明要注入的属性前缀，Spring Boot会自动把相关属性通过set方法注入到DataSource中
    //在JdbcProperties类中已经声明，此处不再声明
    public DataSource dataSource() {
        return new DruidDataSource();
    }*/
}
