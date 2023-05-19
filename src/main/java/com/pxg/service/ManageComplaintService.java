package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.ComplaintEmail;
import com.pxg.pojo.Feedback;
import com.pxg.pojo.ManageComplaint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ManageComplaintService extends IService<ManageComplaint> {
    boolean insertComplain(int manageId, int workerId, String boosName, String complaintMatter, String treatmentState);

    ArrayList<ManageComplaint> manageLookComplaint(int manageId);

    ComplaintEmail manageLookEmail(int complaintId);

    boolean manageSolve(int complaintId);
}
