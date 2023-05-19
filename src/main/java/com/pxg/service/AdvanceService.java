package com.pxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxg.pojo.Advance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface AdvanceService extends IService<Advance> {
    int AdvanceInsert(int boosId,int workerId,int money);

    ArrayList<Advance> getAdvanceJiLu(int workerId);

    List<Advance> boosGetAdvance(int boosId);

    int boosAdvanceResult(int advanceId,boolean result);
}
