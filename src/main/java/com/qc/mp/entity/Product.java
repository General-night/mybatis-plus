package com.qc.mp.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Author：MoneyOrange
 * @Date：2023/4/1/17:47
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;

    // 标识乐观锁版本号字段
    @Version
    private Integer version;
}
