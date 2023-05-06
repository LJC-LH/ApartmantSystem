package com.ruoyi.apartment.service;

import com.ruoyi.apartment.domain.EchartData;

import java.util.List;

/**
 * @author LJC
 * @create 2023-02-04 20:34
 */
public interface EchartsService {

    public List<EchartData> groupByStudyLevel();

    public List<EchartData> getPeopleNum();

    public List<EchartData> getStudentProvince();

    public List<EchartData> getEachCollageSex();

    public List<EchartData> getApartmentData();

    public List<EchartData> getApartmentFixNum();

    public List<EchartData> getServiceDegree();
}
