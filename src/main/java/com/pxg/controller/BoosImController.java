package com.pxg.controller;

import com.pxg.pojo.BoosInformation;
import com.pxg.service.BoosInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boosInfor")
public class BoosImController {
    @Autowired
    private BoosInformationService boosInformationService;

    @GetMapping
    BoosInformation boosSelect(int id) {
        BoosInformation boosselect = boosInformationService.boosselect(id);
        if (boosselect != null) {
            return boosselect;
        } else {
            return boosInformationService.boosselect(-1);
        }
    }
}
