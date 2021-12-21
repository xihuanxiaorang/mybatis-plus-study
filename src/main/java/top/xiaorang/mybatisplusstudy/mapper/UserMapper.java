package top.xiaorang.mybatisplusstudy.mapper;

import top.xiaorang.mybatisplusstudy.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaorang
 * @since 2021-12-21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    boolean saveBatchByNative(List<User> list);
}
