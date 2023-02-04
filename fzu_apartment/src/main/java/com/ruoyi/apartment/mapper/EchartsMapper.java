package com.ruoyi.apartment.mapper;

import com.ruoyi.apartment.domain.EchartData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LJC
 * @create 2023-02-04 20:36
 */
public interface EchartsMapper {

    /**
     * groupByStudyLevel就读学历层次
     */
    public List<EchartData> groupByStudyLevel();
}
