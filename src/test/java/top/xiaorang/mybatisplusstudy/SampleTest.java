package top.xiaorang.mybatisplusstudy;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.xiaorang.mybatisplusstudy.entity.User;
import top.xiaorang.mybatisplusstudy.mapper.UserMapper;

import java.util.List;

@SpringBootTest
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = User.builder().name("小让的糖果屋4").age(21).email("2329862718@qq.com").build();
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = User.builder().id(1471083433073393675L).age(30).email("15019474951@163.com").build();
        userMapper.updateById(user);
    }

    @Test
    public void testUpdate2() {
        User user = userMapper.selectById(1471083433073393675L);
        user.setAge(30);
        userMapper.updateById(user);
    }

    @Test
    public void testUpdate3() {
        User user = userMapper.selectById(1471083433073393675L);

        User user2 = userMapper.selectById(1471083433073393675L);
        user2.setAge(32);
        userMapper.updateById(user2);

        user.setAge(30);
        userMapper.updateById(user);
    }
}
