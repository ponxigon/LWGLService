package com.pxg.controller;

import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.User;
import com.pxg.pojo.UserResult;
import com.pxg.service.BoosInformationService;
import com.pxg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BoosInformationService boosInformationService;

    //登录验证
    @PostMapping
    UserResult login(String number, String password) {
        int zh = userService.user(number, password);
        UserResult userResult = new UserResult();
        userResult.setZh(zh);
        if (zh == 1){
            User user = userService.sel(number);
            userResult.setAccountType(user.getAccount());
            userResult.setId(user.getId());
            userResult.setOther(otherValue(user.getId(),user.getAccount()));
        }
        return userResult;
    }

    private String otherValue(int id, String account) {
        String str = null;
        if (account.equals("企业")){
            BoosInformation boosselect = boosInformationService.boosselect(id);
            if (boosselect != null){
                str = boosselect.getCompany();
            }else {
                str = boosInformationService.boosselect(-1).getCompany();
            }

        } else if (account.equals("管理部门")) {
            //待填
        }
        return str;
    }
}
