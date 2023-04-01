package com.qc.mp;

import com.qc.mp.service.IProductService;
import com.qc.mp.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author：MoneyOrange
 * @Date：2023/4/1/23:30
 */

@SpringBootTest
public class MpDynamicDsTest {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IProductService iProductService;

    @Test
    public void test() {
        System.out.println(iUserService.getById(1));
        System.out.println(iProductService.getById(1));
    }
}
