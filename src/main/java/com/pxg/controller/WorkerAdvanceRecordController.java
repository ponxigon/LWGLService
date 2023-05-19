package com.pxg.controller;

import com.pxg.pojo.Advance;
import com.pxg.pojo.AdvanceJiLu_Bao;
import com.pxg.pojo.WorkerAdvanceJiLu;
import com.pxg.service.AdvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/workerGetAdvance")
public class WorkerAdvanceRecordController {
    @Autowired
    private AdvanceService advanceService;

    @GetMapping
    AdvanceJiLu_Bao workerGetAdvance(int workerId){
        ArrayList<Advance> advanceJiLu = advanceService.getAdvanceJiLu(workerId);
        ArrayList<WorkerAdvanceJiLu> advanceJiLus = new ArrayList<>();
        for (Advance advance : advanceJiLu) {
            WorkerAdvanceJiLu workerAdvanceJiLu = new WorkerAdvanceJiLu();
            workerAdvanceJiLu.setMoney(advance.getMoney());
            workerAdvanceJiLu.setState(advance.getState());
            advanceJiLus.add(workerAdvanceJiLu);
        }
        AdvanceJiLu_Bao advanceJiLuBao = new AdvanceJiLu_Bao();
        advanceJiLuBao.setAdvanceJiLus(advanceJiLus);
        return advanceJiLuBao;
    }
}
