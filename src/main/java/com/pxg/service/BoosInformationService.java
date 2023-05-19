package com.pxg.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.BoosInformation;
import com.pxg.pojo.WorkerInformation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface BoosInformationService extends IService<BoosInformation> {

    BoosInformation boosselect(int id);

    int insert(int id);

    int revamp(int id,String name,String company,String city);

    Page<BoosInformation> manageInquireBoos(String city);

    //查询企业
    HashMap<String,Object> inquireCompany(String company);

    int getBoosId(String number);

    String getBoosCity(String company);

}
