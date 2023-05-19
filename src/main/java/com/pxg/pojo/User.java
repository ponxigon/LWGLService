package com.pxg.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    private int id;
    @TableId(value = "number")
    private String number;

    private String password;

    private String account;
}
