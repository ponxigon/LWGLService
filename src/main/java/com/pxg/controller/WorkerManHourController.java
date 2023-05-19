package com.pxg.controller;

import com.pxg.pojo.WorkerManHour;
import com.pxg.service.WorkerManHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//工人薪资查询
@RestController
    @RequestMapping("/manHour")
public class WorkerManHourController {
    @Autowired
    private WorkerManHourService workerManHourService;

    @GetMapping
    private WorkerManHour selectManHour(int id){
        WorkerManHour workerManHour = workerManHourService.selectManHour(id);
        if (workerManHour == null){
            workerManHour = retNull();
        }
        return workerManHour;
    }

    private WorkerManHour retNull() {
        return workerManHourService.selectManHour(-1);
    }
}
