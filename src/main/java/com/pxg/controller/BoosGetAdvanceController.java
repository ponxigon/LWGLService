package com.pxg.controller;

import com.pxg.pojo.Advance;
import com.pxg.pojo.BoosLookAdvance;
import com.pxg.pojo.BoosLookAdvance_Bao;
import com.pxg.service.AdvanceService;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//boos查看预支请求
@RestController
@RequestMapping("/boosAdvance")
public class BoosGetAdvanceController {
    @Autowired
    private AdvanceService advanceService;
    @Autowired
    private WorkerInformationService workerInformationService;

    @GetMapping
    BoosLookAdvance_Bao boosAdvance(int boosId){
        List<Advance> advances = advanceService.boosGetAdvance(boosId);
        ArrayList<BoosLookAdvance> arrayList = new ArrayList<>();
        for (Advance advance : advances) {
            BoosLookAdvance boosLookAdvance = new BoosLookAdvance();
            boosLookAdvance.setWorkerId(advance.getWorkerid());
            boosLookAdvance.setAdvanceId(advance.getAdvanceid());
            boosLookAdvance.setWorkerName(workerInformationService.IdForName(advance.getWorkerid()));
            boosLookAdvance.setMoney(advance.getMoney());
            arrayList.add(boosLookAdvance);
        }
        BoosLookAdvance_Bao bao = new BoosLookAdvance_Bao();
        bao.setBoosLookAdvance(arrayList);
        return bao;
    }
}
