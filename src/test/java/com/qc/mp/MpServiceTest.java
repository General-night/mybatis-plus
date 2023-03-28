package com.qc.mp;

import cn.hutool.core.util.RandomUtil;
import com.qc.mp.entity.User;
import com.qc.mp.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：钱程
 * @Date：2023/3/28/23:12
 */

@SpringBootTest
public class MpServiceTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void testGetCount() {
        long count = iUserService.count();
        System.out.println("count = " + count);
    }

    @Test
    public void testBatchInsert() {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            userList.add(User.builder().
                    name("Test" + i).age(i + RandomUtil.randomInt(1, 20)).email("test" + 1 + "@baomidou.com").build()
            );
        }

        boolean b = iUserService.saveBatch(userList);
        System.out.println("b = " + b);
    }
}
