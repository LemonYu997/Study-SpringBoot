package app.mapper;

import app.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

//继承通用Mapper
@Repository //解决service无法注入mapper的问题
public interface UserMapper extends Mapper<User> {
}
