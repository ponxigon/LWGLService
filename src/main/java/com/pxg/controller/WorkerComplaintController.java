package com.pxg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pxg.mapper.ManageImMapper;
import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.Feedback;
import com.pxg.pojo.ManageInformation;
import com.pxg.service.BoosInformationService;
import com.pxg.service.ManageComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//工人投诉
@RestController
@RequestMapping("/complaint")
public class WorkerComplaintController {
    @Autowired
    private ManageComplaintService manageComplaintService;

    @Autowired
    private BoosInformationService boosInformationService;
    @Autowired
    private ManageImMapper manageImMapper;
    private int manageid;

    @PostMapping
    Feedback complaint(int workerId, String companyName, String matter){
        LambdaQueryWrapper<BoosInformation> boosWrapper = new LambdaQueryWrapper<>();
        boosWrapper.eq(BoosInformation::getCompany,companyName);
        String boosCity = boosInformationService.getBoosCity(companyName);
        LambdaQueryWrapper<ManageInformation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ManageInformation::getCity,boosCity);
        Feedback feedback;
        List<ManageInformation> manageInformations = manageImMapper.selectList(wrapper);
        if (manageInformations.size()!=0) {
            for (ManageInformation manageInformation : manageImMapper.selectList(wrapper)) {
                manageid = manageInformation.getId();
            }
            boolean b = manageComplaintService.insertComplain(manageid, workerId, companyName, matter, "未处理");
            feedback = new Feedback();
            feedback.setReminder(b);
            return feedback;
        }else {
            return null;
        }
    }

}
