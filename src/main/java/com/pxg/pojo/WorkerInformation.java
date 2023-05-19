package com.pxg.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class WorkerInformation {

    @TableId(value = "id")
    private Integer id;
    private String name;
    private String sex;
    private String identitycard;
    private String companyfront;
    private String companyrear;
    private String operatingpost;
    private String bankid;
}
