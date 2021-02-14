package app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ConfigurationProperties：从配置文件application配置文件中读取配置项
 * prefix：表示配置项的前缀
 * 配置项类中的类变量名必须要与前缀之后的配置项名称保持松散绑定（相同）
 * */
@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {
    private String url;
    private String driver;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
