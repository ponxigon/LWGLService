package com.pxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxg.mapper.AdvanceMapper;
import com.pxg.pojo.Advance;
import com.pxg.pojo.BoosLookAdvance;
import com.pxg.service.AdvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvanceServiceImpl extends ServiceImpl<AdvanceMapper, Advance> implements AdvanceService {
    @Autowired
    private AdvanceMapper advanceMapper;
    @Override
    public int AdvanceInsert(int boosId, int workerId, int money) {
        Advance advance = new Advance();
        advance.setBoosid(boosId);
        advance.setWorkerid(workerId);
        advance.setMoney(money);
        advance.setState("未审核");
        return advanceMapper.insert(advance);
    }

    @Override
    public ArrayList<Advance> getAdvanceJiLu(int workerId) {
        LambdaQueryWrapper<Advance> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Advance::getWorkerid,workerId);
        return (ArrayList<Advance>) advanceMapper.selectList(wrapper);
    }

    @Override
    public List<Advance> boosGetAdvance(int boosId) {
        LambdaQueryWrapper<Advance> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Advance::getBoosid,boosId);
        wrapper.eq(Advance::getState,"未审核");
        return advanceMapper.selectList(wrapper);
    }

    @Override
    public int boosAdvanceResult(int advanceId, boolean result) {
        Advance advance = new Advance();
        advance.setAdvanceid(advanceId);
        if (result){
            advance.setState("预支成功");
        }else {
            advance.setState("未通过");
        }
        return advanceMapper.updateById(advance);
    }
}
