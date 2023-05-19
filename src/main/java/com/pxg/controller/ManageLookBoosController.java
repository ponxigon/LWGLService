package com.pxg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pxg.pojo.BoosInformation;
import com.pxg.service.BoosInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manageLookBoos")
public class ManageLookBoosController {
    @Autowired
    private BoosInformationService boosInformationService;

    @GetMapping
    Page<BoosInformation> lookBoos(String city){
        return boosInformationService.manageInquireBoos(city);
    }


}
