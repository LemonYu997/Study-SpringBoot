package app.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

//调用spring容器
@RunWith(SpringRunner.class)
//springboot项目中的测试类必须加@SpringBootTest注解
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        //string 字符串
        //redisTemplate.opsForValue().set("str", "test");
        redisTemplate.boundValueOps("str").set("test"); //功能同上
        System.out.println("str = " + redisTemplate.opsForValue().get("str"));  //str = test

        //hash 散列
        redisTemplate.boundHashOps("h_key").put("name", "test");
        redisTemplate.boundHashOps("h_key").put("age", "15");
        //获取所有域
        Set h_set = redisTemplate.boundHashOps("h_key").keys();
        System.out.println("hash散列的所有域：" + h_set);  //hash散列的所有域：[name, age]
        //获取所有值
        List h_list = redisTemplate.boundHashOps("h_key").values();
        System.out.println("hash散列的所有域的值：" + h_list);   //hash散列的所有域的值：[test, 15]

        //list 列表
        redisTemplate.boundListOps("l_key").leftPush("c");
        redisTemplate.boundListOps("l_key").leftPush("b");
        redisTemplate.boundListOps("l_key").leftPush("a");
        //获取全部元素
        List l_list = redisTemplate.boundListOps("l_key").range(0, -1);
        System.out.println("list表中的所有元素：" + l_list);    //list表中的所有元素：[a, b, c]

        //set 集合 无序输出
        redisTemplate.boundSetOps("s_key").add("a", "b", "c");
        Set s_set = redisTemplate.boundSetOps("s_key").members();
        System.out.println("set集合中中的所有元素：" + s_set);    //set集合中中的所有元素：[b, c, a]

        //sorted set 有序集合 默认升序
        redisTemplate.boundZSetOps("z_key").add("a", 30);
        redisTemplate.boundZSetOps("z_key").add("b", 10);
        redisTemplate.boundZSetOps("z_key").add("c", 20);
        Set z_set = redisTemplate.boundZSetOps("z_key").range(0, -1);
        System.out.println("有序集合中的所有元素：" + z_set);  //有序集合中的所有元素：[b, c, a]
    }
}
