package com.ruoyi.apartment.mapper;

import com.ruoyi.apartment.domain.EchartData;

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


    /**
     * 获取用户总人数，学生，教职工，物业人数
     * @return
     */
    public EchartData getTotalPeopleNum();
    public EchartData getStudentNum();
    public EchartData getTeacherNum();
    public EchartData getWuyeData();

    /**
     * 获取学生生源地分布
     */
    public List<EchartData> getStudentProvince();

    /**
     * 获取各学院人数，男女分布
     * @return
     */
    public List<EchartData> getEachCollageNum();
    public List<EchartData> getEachCollageSex0();
    public List<EchartData> getEachCollageSex1();


    /**
     * 获取大屏表格宿舍信息
     * @return
     */
    public EchartData getBuildingNum();
    public EchartData getRoomNum();
    public EchartData getStuDormNum();
}
