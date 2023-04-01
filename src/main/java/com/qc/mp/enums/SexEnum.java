package com.qc.mp.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Author：MoneyOrange
 * @Date：2023/4/1/18:22
 */

@Getter
public enum SexEnum {

    MALE(1, "男"), FEMALE(0, "女");

    // 将注解所标识属性的值存储到数据库中
    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
