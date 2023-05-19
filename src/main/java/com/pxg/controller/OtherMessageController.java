package com.pxg.controller;

import com.pxg.mapper.BoosImMapper;
import com.pxg.mapper.ManageImMapper;
import com.pxg.mapper.UserMapper;
import com.pxg.mapper.WorkerImMapper;
import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.ManageInformation;
import com.pxg.pojo.UserOtherMessage;
import com.pxg.pojo.WorkerInformation;
import com.pxg.service.BoosInformationService;
import com.pxg.service.ManageInformationService;
import com.pxg.service.UserService;
import com.pxg.service.WorkerInformationService;
import com.pxg.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//返回账户名字
@RestController
@RequestMapping("/userOther")
public class OtherMessageController {
    @Autowired
    private WorkerInformationService workerInformationService;
    @Autowired
    private BoosInformationService boosInformationService;
    @Autowired
    private ManageInformationService manageInformationService;


    @Autowired
    private WorkerImMapper workerImMapper;
    @Autowired
    private BoosImMapper boosImMapper;
    @Autowired
    private ManageImMapper manageImMapper;

    @GetMapping
    UserOtherMessage otherMessage(int id, String account) {
        UserOtherMessage userOtherMessage = new UserOtherMessage("未命名", null, null, null, null,
                null, null, null, null);
        switch (account) {
            case "工人":
                WorkerInformation workerselect = workerInformationService.workerselect(id);
                if (workerImMapper.selectById(id) != null) {
                    userOtherMessage = new UserOtherMessage();
                    userOtherMessage.setName(workerselect.getName());
                    userOtherMessage.setAge(workerselect.getSex());
                    userOtherMessage.setIdentitycard(workerselect.getIdentitycard());
                    userOtherMessage.setCompanyfront(workerselect.getCompanyfront());
                    userOtherMessage.setCompanyrear(workerselect.getCompanyrear());
                    userOtherMessage.setOperatingpost(workerselect.getOperatingpost());
                    userOtherMessage.setBankid(workerselect.getBankid());
                }
                break;
            case "企业":
                BoosInformation boosselect = boosInformationService.boosselect(id);
                if (boosImMapper.selectById(id) != null) {
                    userOtherMessage.setName(boosselect.getName());
                    userOtherMessage.setCompany(boosselect.getCompany());
                    userOtherMessage.setCity(boosselect.getCity());
                }
                break;
            case "管理部门":
                ManageInformation manageselect = manageInformationService.manageselect(id);
                if (manageImMapper.selectById(id) != null) {
                    userOtherMessage.setName(manageselect.getName());
                    userOtherMessage.setCity(manageselect.getCity());
                }
                break;
        }
        return userOtherMessage;
    }



}
