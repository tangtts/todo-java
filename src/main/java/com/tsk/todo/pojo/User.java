package com.tsk.todo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("users")
public class User extends CommonPojo {
    @TableId()
    private Integer userId;

    private String nickName;

    private String password;

    private String phoneNumber;
}
