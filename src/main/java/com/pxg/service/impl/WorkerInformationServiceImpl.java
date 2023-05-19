package com.pxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.WorkerImMapper;
import com.pxg.pojo.BoosDispatchWorkerIm;
import com.pxg.pojo.Feedback;
import com.pxg.pojo.WorkerInformation;
import com.pxg.service.WorkerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerInformationServiceImpl extends ServiceImpl<WorkerImMapper, WorkerInformation> implements WorkerInformationService {

    @Autowired
    private WorkerImMapper workerImMapper;

    @Override
    public int insert(int id) {
        WorkerInformation workerInformation = new WorkerInformation();
        workerInformation.setId(id);
        return workerImMapper.insert(workerInformation);
    }

    @Override
    public WorkerInformation workerselect(int id) {
        return workerImMapper.selectById(id);
    }

    @Override
    public int revamp(int id, String name, String sex, String identityCard, String bankId) {
        WorkerInformation workerInformation = new WorkerInformation();
        workerInformation.setId(id);
        workerInformation.setName(name);
        workerInformation.setSex(sex);
        workerInformation.setIdentitycard(identityCard);
        workerInformation.setBankid(bankId);
        int update = workerImMapper.updateById(workerInformation);
        System.out.println("修改的返回值：" + update);
        return update;
    }

    @Override
    public Page<WorkerInformation> boosInquireWorker(String companyFront) {
        QueryWrapper<WorkerInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("companyFront", companyFront);
        IPage<WorkerInformation> page = new Page<>(1, 50);
        return (Page<WorkerInformation>) workerImMapper.selectPage(page, queryWrapper);
    }

    public String IdForName(int id) {
        WorkerInformation workerInformation = workerImMapper.selectById(id);
        return workerInformation.getName();
    }

    //加入企业
    @Override
    public boolean JoinCompany(int id, String comopany) {
        WorkerInformation workerInformation = new WorkerInformation();
        workerInformation.setId(id);
        workerInformation.setCompanyfront(comopany);
        System.out.println("老子冒暖火="+workerInformation);
        int i = workerImMapper.updateById(workerInformation);
        return i == 1;
    }

    @Override
    public BoosDispatchWorkerIm workerDispatch(String company) {
        LambdaQueryWrapper<WorkerInformation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WorkerInformation::getCompanyfront,company);
        List<WorkerInformation> workerInformations = workerImMapper.selectList(wrapper);
        BoosDispatchWorkerIm boosDispatchWorkerIm = new BoosDispatchWorkerIm();
        boosDispatchWorkerIm.setWorkerList((ArrayList<WorkerInformation>) workerInformations);
        return boosDispatchWorkerIm;
    }

    @Override
    public Feedback BoosDispatchworker(int id, String companyrear, String operatingpost) {
        WorkerInformation workerInformation = new WorkerInformation();
        workerInformation.setId(id);
        workerInformation.setCompanyrear(companyrear);
        workerInformation.setOperatingpost(operatingpost);
        int i = workerImMapper.updateById(workerInformation);
        Feedback feedback = new Feedback();
        feedback.setReminder(i==1);
        return feedback;
    }


}
