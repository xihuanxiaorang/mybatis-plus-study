package top.xiaorang.mybatisplusstudy;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.xiaorang.mybatisplusstudy.entity.Goods;
import top.xiaorang.mybatisplusstudy.entity.User;
import top.xiaorang.mybatisplusstudy.mapper.UserMapper;
import top.xiaorang.mybatisplusstudy.service.GoodsService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class SampleTest {
  @Autowired private UserMapper userMapper;
  @Autowired private GoodsService goodsService;

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
    User user =
        User.builder().id(1471083433073393675L).age(30).email("15019474951@163.com").build();
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

  @Test
  public void testSelectByBatchId() {
    List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
    users.forEach(System.out::println);
  }

  @Test
  public void testSelectByMap() {
    HashMap<String, Object> map = new HashMap<>();
    map.put("name", "Jone");
    map.put("age", 18);
    List<User> users = userMapper.selectByMap(map);
    users.forEach(System.out::println);
  }

  // 测试分页查询
  @Test
  public void testPage() {
    // 参数一：当前页
    // 参数二：页面大小
    // 使用了分页插件之后，所有的分页操作也变得简单的！
    Page<User> page = new Page<>(2, 5);
    userMapper.selectPage(page, null);
    page.getRecords().forEach(System.out::println);
    System.out.println(page.getTotal());
  }

  @Test
  public void testDeleteById() {
    userMapper.deleteById(1471083433073393675L);
  }

  @Test
  public void testSelectById() {
    User user = userMapper.selectById(1471083433073393675L);
    System.out.println(user);
  }

  @Test
  public void testDeleteByBatchId() {
    userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
  }

  @Test
  public void testDeleteMap() {
    HashMap<String, Object> map = new HashMap<>();
    map.put("name", "Sandy");
    userMapper.deleteByMap(map);
  }

  @Test
  public void testBatchSave() {
    List<Goods> goods = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      goods.add(Goods.builder().name("鞋子" + i).build());
    }
    goodsService.saveBatch(goods);
  }
}
