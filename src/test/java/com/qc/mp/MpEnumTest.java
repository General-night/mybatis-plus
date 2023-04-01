package com.qc.mp;

import com.qc.mp.entity.User;
import com.qc.mp.enums.SexEnum;
import com.qc.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author：MoneyOrange
 * @Date：2023/4/1/18:26
 */

@SpringBootTest
public class MpEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = User.builder().name("admin").age(24).sex(SexEnum.MALE).build();
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

}
