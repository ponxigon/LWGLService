package com.pxg.pojo;

import lombok.Data;

@Data
public class BoosVacate {
    private int vacateId;
    private int workerId;

    private String workerName;
    private String vacatedate;//请假日期
    private String returndate;//返岗日期
    private String vacatecause;//理由
}
