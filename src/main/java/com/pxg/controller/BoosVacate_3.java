package com.pxg.controller;

import com.pxg.pojo.BoosVacate;
import com.pxg.pojo.BoosVacate_Bao;
import com.pxg.pojo.Vacate;
import com.pxg.service.VacateService;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/boosVacate")
public class BoosVacate_3 {
    @Autowired
    private VacateService vacateService;
    @Autowired
    private WorkerInformationService workerInformationService;

    @GetMapping
    BoosVacate_Bao boosVacate(int boosId){
        ArrayList<Vacate> vacates = vacateService.boosLookVacate(boosId);
        BoosVacate[] boosVacates = new BoosVacate[vacates.size()];
        for (int i = 0; i < vacates.size(); i++) {
            BoosVacate boosVacate = new BoosVacate();
            int workerid = vacates.get(i).getWorkerid();
            boosVacate.setVacateId(vacates.get(i).getVacateid());
            boosVacate.setWorkerId(workerid);
            boosVacate.setWorkerName(workerInformationService.IdForName(workerid));
            boosVacate.setVacatedate(vacates.get(i).getVacatedate());
            boosVacate.setReturndate(vacates.get(i).getReturndate());
            boosVacate.setVacatecause(vacates.get(i).getVacatecause());
            boosVacates[i] = boosVacate;
            System.out.println("返回的请假数组="+boosVacate);
        }

        return new BoosVacate_Bao(boosVacates);
    }

}
