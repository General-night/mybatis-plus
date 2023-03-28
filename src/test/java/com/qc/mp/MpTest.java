package com.qc.mp;

import com.qc.mp.entity.User;
import com.qc.mp.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：钱程
 * @Date：2023/3/28/19:57
 */

@Slf4j
@SpringBootTest
public class MpTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        //User user = User.builder().id(6L).name("奥特曼").age(500).email("aoteman@baomidou.com").build();
        User user = User.builder().name("张三1").age(23).email("zhangsan@baomidou.com").build();
        int insertResult = userMapper.insert(user);
        log.info("insertResult = {}", insertResult);
        log.info("新增后获取主键：id【{}】", user.getId());
    }

    @Test
    public void testDelete() {
        //int deleteResult = userMapper.deleteById(1640707701698551809L);
        //log.info("deleteResult = {}", deleteResult);

        //Map<String, Object> conditionMap = new HashMap<>();
        //conditionMap.put("name", "Sandy");
        //int i = userMapper.deleteByMap(conditionMap);
        //System.out.println("i = " + i);

        List<Integer> idList = Arrays.asList(6, 7, 8, 9, 10);
        int i = userMapper.deleteBatchIds(idList);
        System.out.println("i = " + i);
    }

    @Test
    public void testUpdate() {
        User user = User.builder().id(3L).name("张麻子").email("zhangmazi@baomidou.com").build();
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);
    }

    @Test
    public void testSelect() {
        //User user = userMapper.selectById(1);
        //System.out.println("user = " + user);

        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectMapById() {
        Map<String, Object> map = userMapper.selectMap();
        System.out.println("map = " + map);
    }
}
