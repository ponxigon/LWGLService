package com.pxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.VacateBeanMapper;
import com.pxg.pojo.Vacate;
import com.pxg.pojo.VacateBean;
import com.pxg.pojo.WorkerLookVacateBean;
import com.pxg.service.VacateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacateServiceImpl extends ServiceImpl<VacateBeanMapper, Vacate> implements VacateService {
    @Autowired
    private VacateBeanMapper vacateBeanMapper;
    @Override
    public int vacateInsert(int boosId, int workerId, String vacateDate, String returnDate, String cause) {
        Vacate vacateBean = new Vacate();
        vacateBean.setBoosid(boosId);
        vacateBean.setWorkerid(workerId);
        vacateBean.setVacatedate(vacateDate);
        vacateBean.setReturndate(returnDate);
        vacateBean.setVacatecause(cause);
        vacateBean.setState("未审核");
        return vacateBeanMapper.insert(vacateBean);
    }

    //查询请假情况
    @Override
    public VacateBean workerLookVacateState(int workerId) {
        VacateBean vacateBean1 = new VacateBean();
        LambdaQueryWrapper<Vacate> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Vacate::getWorkerid,workerId);
        List<Vacate> vacates = vacateBeanMapper.selectList(wrapper);
        WorkerLookVacateBean[] workerLookVacateBeans =new WorkerLookVacateBean[vacates.size()];
        int count = 0;
        for (Vacate vacate : vacates) {
            WorkerLookVacateBean vacateBean = new WorkerLookVacateBean();
            vacateBean.setVacatedate(vacate.getVacatedate());
            vacateBean.setState(vacate.getState());
            workerLookVacateBeans[count] = vacateBean;
            count++;
        }
        vacateBean1.setBeans(workerLookVacateBeans);
        return vacateBean1;
    }

    //book看请假申请
    @Override
    public ArrayList<Vacate> boosLookVacate(int boosId) {
        LambdaQueryWrapper<Vacate> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Vacate::getBoosid,boosId);
        wrapper.like(Vacate::getState,"未审核");
        return  (ArrayList<Vacate>) vacateBeanMapper.selectList(wrapper);
    }

    //请假结果
    @Override
    public int replyVacate(int vacateid,boolean state) {
        Vacate vacate = new Vacate();
        vacate.setVacateid(vacateid);
        if (state){
            vacate.setState("通过");
        }else {
            vacate.setState("未通过");
        }
        return vacateBeanMapper.updateById(vacate);
    }


}
