package com.ruoyi.apartment.controller;



import com.ruoyi.apartment.domain.EchartData;
import com.ruoyi.apartment.service.EchartsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LJC
 * @create 2023-02-03 21:32
 */
@RestController
@RequestMapping("/apartment/echarts")
public class EchartsController extends BaseController {

    @Autowired
    private EchartsService echartsService;

    @GetMapping("/groupByStudyLevel")
    public TableDataInfo groupByStudyLevel() {
        List<EchartData> studyLevelData = echartsService.groupByStudyLevel();
        return getDataTable(studyLevelData);
    }

    @GetMapping("/getPeopleNum")
    public TableDataInfo getPeopleNum(){
        List<EchartData> allPeopleData = echartsService.getPeopleNum();
        return getDataTable(allPeopleData);
    }

    @GetMapping("/getStudentProvince")
    public TableDataInfo getStudentProvince(){
        List<EchartData> studentProvince = echartsService.getStudentProvince();
        return getDataTable(studentProvince);
    }

    @GetMapping("/getEachCollageSex")
    public TableDataInfo getEachCollageSex(){
        List eachCollageSex = echartsService.getEachCollageSex();
        return getDataTable(eachCollageSex);
    }

    @GetMapping("getApartmentData")
    public TableDataInfo getApartmentData(){
        List apartmentDataList = echartsService.getApartmentData();
        return getDataTable(apartmentDataList);
    }
}
