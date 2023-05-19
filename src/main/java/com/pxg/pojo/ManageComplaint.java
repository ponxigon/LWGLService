package com.pxg.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ManageComplaint {
    @TableId(value = "complaintid")
    private Integer complaintid;
    private Integer manageid;
    private Integer workerid;
    private String boosname;
    private String complaintmatter;
    private String treatmentstate;
}
