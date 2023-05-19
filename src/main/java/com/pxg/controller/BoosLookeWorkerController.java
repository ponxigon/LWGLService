package com.pxg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pxg.pojo.WorkerInformation;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booslookworker")
public class BoosLookeWorkerController {
    @Autowired
    private WorkerInformationService workerInformationService;

    @GetMapping
    Page<WorkerInformation> lookWorker(String companyFront){
        return workerInformationService.boosInquireWorker(companyFront);
    }
}
