package com.pxg.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Vacate {
    @TableId(value = "vacateid")
    private Integer vacateid;
    private Integer boosid;
    private Integer workerid;
    private String vacatedate;
    private String returndate;
    private String vacatecause;
    private String state;
}
