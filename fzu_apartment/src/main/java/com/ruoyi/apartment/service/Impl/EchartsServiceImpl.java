package com.ruoyi.apartment.service.Impl;

import com.ruoyi.apartment.domain.EchartData;
import com.ruoyi.apartment.mapper.EchartsMapper;
import com.ruoyi.apartment.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LJC
 * @create 2023-02-04 20:35
 */
@Service
public class EchartsServiceImpl implements EchartsService {

    @Autowired
    private EchartsMapper echartsMapper;

    @Override
    public List<EchartData> groupByStudyLevel() {
        return echartsMapper.groupByStudyLevel();
    }
}
