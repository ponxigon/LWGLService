package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.service.AdvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boosAdvanceResult")
public class BoosAdvanceResultController {
    @Autowired
    private AdvanceService advanceService;

    @PostMapping
    Feedback boosAdvanceResult(int advanceId, boolean result) {
        int i = advanceService.boosAdvanceResult(advanceId, result);
        Feedback feedback = new Feedback();
        feedback.setReminder(i == 1);
        return feedback;
    }
}
