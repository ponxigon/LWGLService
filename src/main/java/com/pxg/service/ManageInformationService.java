package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.ManageInformation;
import org.springframework.stereotype.Service;

@Service
public interface ManageInformationService extends IService<ManageInformation> {

    ManageInformation manageselect(int id);

    int insert(int id);

    int revamp(int id,String name,String city);

    int getManageId(String number);
}
