package top.xiaorang.mybatisplusstudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.xiaorang.mybatisplusstudy.entity.User;
import top.xiaorang.mybatisplusstudy.mapper.UserMapper;
import top.xiaorang.mybatisplusstudy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author xiaorang
 * @since 2021-12-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
  private final UserMapper userMapper;

  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public boolean saveBatchByNative(List<User> users) {
    return userMapper.saveBatchByNative(users);
  }
}
