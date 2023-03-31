package com.qc.mp;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qc.mp.entity.User;
import com.qc.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author：钱程
 * @Date：2023/3/30/20:50
 */

@SpringBootTest
public class MpWrapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_01() {
        // 查询用户名含’a‘，年龄在20~30之间，邮箱信息不为null
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.like("user_name", "a");
        userWrapper.between("age", 20, 30);
        userWrapper.isNotNull("email");
        List<User> userList = userMapper.selectList(userWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test_02() {
        // 查询用户信息，按照年龄降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test_03() {
        // 删除邮箱地址为null的用户信息
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNull("email");
        int delete = userMapper.delete(userQueryWrapper);
        System.out.println("delete = " + delete);
    }

    @Test
    public void test_04() {
        // 将（年龄大于20并且用户名中含a）或邮箱为null的用户信息修改
        QueryWrapper<User> userUpdateWrapper = new QueryWrapper<>();
        userUpdateWrapper.gt("age", 20).like("user_name", "a").or().isNull("email");
        User userCondition = User.builder().name("小明").email("test@qq.com").build();
        int update = userMapper.update(userCondition, userUpdateWrapper);
        System.out.println("update = " + update);
    }

    @Test
    public void test_05() {
        // 将用户名中包含a并且（年龄大于20或邮箱为null）的用户信息修改
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", "a").and(wrapper -> wrapper.gt("age", 20).or().isNull("email"));
        User userCondition = User.builder().name("小红").email("test@qq.com").build();
        int update = userMapper.update(userCondition, userQueryWrapper);
        System.out.println("update = " + update);
    }

    @Test
    public void test_06() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("user_name", "age");
        List<Map<String, Object>> userList = userMapper.selectMaps(userQueryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test_07() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("id", "select id from t_user where id <= 100");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test_08() {
        // 将用户名中包含a并且（年龄大于20或邮箱为null）的用户信息修改
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        //userUpdateWrapper.like("user_name", "a").and(wrapper -> wrapper.gt("age", 20).or().isNull("email"));
        //userUpdateWrapper.set("user_name", "傻强");
        //int update = userMapper.update(null, userUpdateWrapper);
        //System.out.println("update = " + update);
        userUpdateWrapper.or(wrapper -> wrapper.like("user_name", "a").gt("age", 20));
        List<User> users = userMapper.selectList(userUpdateWrapper);
        System.out.println("users = " + users);
    }

    @Test
    public void test_09() {
        String username = "a";
        Integer ageStart = 20;
        Integer ageEnd = null;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like(StrUtil.isNotBlank(username), "user_name", username).ge(Objects.nonNull(ageStart), "age", ageStart).le(Objects.nonNull(ageEnd), "age", ageEnd);
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test_10() {
        String username = "a";
        Integer ageStart = 20;
        Integer ageEnd = null;

        List<User> userList = userMapper.selectList(new LambdaQueryWrapper<User>()
                .like(StrUtil.isNotBlank(username), User::getName, username)
                .ge(Objects.nonNull(ageStart), User::getAge, ageStart)
                .le(Objects.nonNull(ageEnd), User::getAge, ageEnd)
        );
        userList.forEach(System.out::println);
    }
}