package com.ruoyi.apartment.service.Impl;

import com.ruoyi.apartment.domain.FzuCompleteOrders;
import com.ruoyi.apartment.mapper.FzuFileMapper;
import com.ruoyi.apartment.service.FzuFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FzuFilesServiceImpl implements FzuFilesService {

    @Autowired
    private FzuFileMapper fzuFileMapper;

    @Override
    public int setStuImage(FzuCompleteOrders fzuCompleteOrders) { return fzuFileMapper.setStuImage(fzuCompleteOrders);}

    @Override
    public int setFirstRepairmanImage(FzuCompleteOrders fzuCompleteOrders){ return fzuFileMapper.setFirstRepairmanImage(fzuCompleteOrders);};

    @Override
    public int setSecondRepairmanImage(FzuCompleteOrders fzuCompleteOrders){ return fzuFileMapper.setSecondRepairmanImage(fzuCompleteOrders);};
}
