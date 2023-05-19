package com.pxg.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Advance {
    @TableId(value = "advanceid")
    private Integer advanceid;
    private Integer boosid;
    private Integer workerid;
    private Integer money;
    private String state;
}
