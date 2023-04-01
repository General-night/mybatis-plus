package com.qc.mp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qc.mp.entity.User;
import com.qc.mp.mapper.UserMapper;
import com.qc.mp.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author：钱程
 * @Date：2023/3/28/23:03
 */

@DS("master")   // 指定所操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
