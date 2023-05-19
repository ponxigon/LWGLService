package com.pxg.pojo;

import lombok.Data;

@Data
public class BoosJob {
    private int id;
    private String labourservice; //工人加入企业

    private String restservice; //请假调休审核

    private String advanceservice;  //预支工资审核

}
