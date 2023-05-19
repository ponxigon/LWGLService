package com.pxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.ManageComplaintMapper;
import com.pxg.pojo.ComplaintEmail;
import com.pxg.pojo.Feedback;
import com.pxg.pojo.ManageComplaint;
import com.pxg.service.ManageComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManageComplaintServiceImpl extends ServiceImpl<ManageComplaintMapper, ManageComplaint> implements ManageComplaintService {
    @Autowired
    private ManageComplaintMapper manageComplaintMapper;


    @Override
    public boolean insertComplain(int manageId, int workerId, String boosName, String complaintMatter, String treatmentState) {
        ManageComplaint manageComplaintBean = new ManageComplaint();
        manageComplaintBean.setManageid(manageId);
        manageComplaintBean.setWorkerid(workerId);
        manageComplaintBean.setBoosname(boosName);
        manageComplaintBean.setComplaintmatter(complaintMatter);
        manageComplaintBean.setTreatmentstate(treatmentState);
        int insert = manageComplaintMapper.insert(manageComplaintBean);
        return insert == 1;
    }

    //manage查看信箱
    @Override
    public ArrayList<ManageComplaint> manageLookComplaint(int manageId) {
        LambdaQueryWrapper<ManageComplaint> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ManageComplaint::getManageid, manageId);
        wrapper.like(ManageComplaint::getTreatmentstate,"未处理");
        return (ArrayList<ManageComplaint>) manageComplaintMapper.selectList(wrapper);
    }

    //manage查看邮件内容
    @Override
    public ComplaintEmail manageLookEmail(int complaintId) {
        System.out.println("反馈的ID："+complaintId);
        ManageComplaint manageComplaint = manageComplaintMapper.selectById(complaintId);
        ComplaintEmail complaintEmail = new ComplaintEmail();
        complaintEmail.setCompany(manageComplaint.getBoosname());
        complaintEmail.setMailContent(manageComplaint.getComplaintmatter());
        return complaintEmail;
    }


    //Manage解决投诉
    @Override
    public boolean manageSolve(int complaintId) {
        ManageComplaint complaint = new ManageComplaint();
        complaint.setComplaintid(complaintId);
        complaint.setTreatmentstate("已处理");
        int i = manageComplaintMapper.updateById(complaint);
        System.out.println("处理情况"+complaint);
        return i == 1;
    }
}
