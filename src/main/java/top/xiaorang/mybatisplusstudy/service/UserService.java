package top.xiaorang.mybatisplusstudy.service;

import top.xiaorang.mybatisplusstudy.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 服务类
 *
 * @author xiaorang
 * @since 2021-12-21
 */
public interface UserService extends IService<User> {
  boolean saveBatchByNative(List<User> users);
}
