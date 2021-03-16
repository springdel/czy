package com.czy.sboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "users")
public class Users {
    @TableField(value = "name")
    private String name;
    @TableField(value = "name")
    private String password;
}
