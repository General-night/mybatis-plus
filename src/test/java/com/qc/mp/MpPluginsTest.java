package com.qc.mp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qc.mp.entity.Product;
import com.qc.mp.entity.User;
import com.qc.mp.mapper.ProductMapper;
import com.qc.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

/**
 * @Author：钱程
 * @Date：2023/4/1/16:56
 */

@SpringBootTest
public class MpPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testPage() {
        IPage<User> iPage = new Page<>(2, 3);
        userMapper.selectPage(iPage, null);
        List<User> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectPageVo() {
        IPage<User> iPage = new Page<>(2, 3);
        userMapper.selectPageVo(iPage, 20);
        List<User> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }

    @Test
    public void testProduct_01() {
        // 小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格：" + productLi.getPrice());

        // 小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的商品价格：" + productWang.getPrice());

        // 小李将商品价格 +50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        // 小王将商品价格 -30
        productWang.setPrice(productWang.getPrice() - 30);
        int result = productMapper.updateById(productWang);
        if (Objects.equals(result, 0)) {
            // 操作失败，重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }

        // 老板查询的商品价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板查询的商品价格：" + productBoss.getPrice());
    }
}
