package com.pxg.controller;

import com.pxg.pojo.Feedback;
import com.pxg.pojo.User;
import com.pxg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/changePassword")
public class ChangePasswordController {
    @Autowired
    private UserService userService;

    @PostMapping
    Feedback changrPassword(String number, String password){
        User user = userService.sel(number);
        user.setPassword(password);
        int revamp = userService.revamp(user);
        return verify(revamp);
    }

    private Feedback verify(int revamp) {
        Feedback feedback = new Feedback();
        if (revamp == 1) {
            feedback.setReminder(true);
        } else if (revamp == -1) {
            feedback.setReminder(false);
        }
        return feedback;
    }
}
