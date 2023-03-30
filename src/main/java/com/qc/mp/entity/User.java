package com.qc.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：钱程
 * @Date：2023/3/28/20:32
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@TableName("t_user")
public class User {

    /**
     * 讲属性所对应的字段作为主键<br/>
     * 因为mp实现功能的过程时先扫描实体类，再抽取属性，将属性作为字段进行操作<br/>
     * mp默认将id作为主键，所以当主键不是id时，要用@TableId进行注解
     */
    @TableId
    private Long id;

    @TableField("user_name")
    private String name;

    /**
     * 最好是设置成包装类，因为mybatis在做更新时不会更新属性为null的字段
     */
    private Integer age;

    private String email;

    private Integer isDeleted;
}
