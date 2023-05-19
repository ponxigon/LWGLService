package com.pxg.controller;

import com.pxg.pojo.WorkerInformation;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//工人查询信息
@RestController
@RequestMapping("/workerIm")
public class WorkerImController {
    @Autowired
    private WorkerInformationService workerInformationService;

    @GetMapping
    WorkerInformation workerInforById(@RequestParam int id) {
        WorkerInformation workerselect = workerInformationService.workerselect(id);
        if (workerselect == null) {
            System.out.println("查询值为空");
            workerselect = retNull();
        }
        return workerselect;
    }

    private WorkerInformation retNull() {
        return workerInformationService.workerselect(-1);
    }



}
