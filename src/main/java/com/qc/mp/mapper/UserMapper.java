package com.qc.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qc.mp.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Author：钱程
 * @Date：2023/3/28/20:38
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @MapKey("id")
    Map<String, Object> selectMap();
}
