package top.xiaorang.mybatisplusstudy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xiaorang.mybatisplusstudy.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {}
