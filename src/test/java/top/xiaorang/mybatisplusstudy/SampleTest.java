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
        User user = User.builder().name("小让的糖果屋").age(2).email("2329862718@qq.com").build();
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = User.builder().id(1471083433073393667L).name("小让的糖果屋1").age(3).email("15019474951@163.com").build();
        userMapper.updateById(user);
    }
}
