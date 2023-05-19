package com.pxg.controller;

import com.pxg.pojo.ManageInformation;
import com.pxg.service.ManageInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manageSelect")
public class ManageImController {
    @Autowired
    private ManageInformationService manageInformationService;

    @GetMapping
    ManageInformation manageSelect(int id){
        ManageInformation manageselect = manageInformationService.manageselect(id);
        if (manageselect != null){
            return manageselect;
        }else {
            return manageInformationService.manageselect(-1);
        }
    }
}
