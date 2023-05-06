package com.ruoyi.apartment.service.Impl;

import com.ruoyi.apartment.domain.EchartData;
import com.ruoyi.apartment.mapper.EchartsMapper;
import com.ruoyi.apartment.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<EchartData> getPeopleNum() {
        List<EchartData> allPeopleData = new ArrayList<>();
        EchartData peopleData = echartsMapper.getTotalPeopleNum();
        EchartData studentData = echartsMapper.getStudentNum();
        EchartData teacherData = echartsMapper.getTeacherNum();
        EchartData wuyeData = echartsMapper.getWuyeData();
        allPeopleData.add(peopleData);
        allPeopleData.add(studentData);
        allPeopleData.add(teacherData);
        allPeopleData.add(wuyeData);
        return allPeopleData;
    }

    @Override
    public List<EchartData> getStudentProvince() {
        return echartsMapper.getStudentProvince();
    }

    @Override
    public List getEachCollageSex() {
        List<List<EchartData>> eachCollageSex = new ArrayList<>();
        List<EchartData> eachCollageNum = echartsMapper.getEachCollageNum();
        List<EchartData> eachCollageSex0 = echartsMapper.getEachCollageSex0();
        List<EchartData> eachCollageSex1 = echartsMapper.getEachCollageSex1();
        eachCollageSex.add(eachCollageNum);
        eachCollageSex.add(eachCollageSex0);
        eachCollageSex.add(eachCollageSex1);
        return eachCollageSex;
    }

    @Override
    public List<EchartData> getApartmentData() {
        List<EchartData> apartmentDataList = new ArrayList<>();
        EchartData buildingNum = echartsMapper.getBuildingNum();
        EchartData roomNum = echartsMapper.getRoomNum();
        EchartData stuDormNum = echartsMapper.getStuDormNum();
        apartmentDataList.add(buildingNum);
        apartmentDataList.add(roomNum);
        apartmentDataList.add(stuDormNum);
        return apartmentDataList;
    }

    @Override
    public List<EchartData> getApartmentFixNum() {
        List<EchartData> apartmentFixNumList = new ArrayList<>();
        EchartData allFixNum = echartsMapper.getAllFixNum();
        EchartData fixNum = echartsMapper.getFixNum();
        EchartData notFixNum = echartsMapper.getNotFixNum();
        apartmentFixNumList.add(allFixNum);
        apartmentFixNumList.add(fixNum);
        apartmentFixNumList.add(notFixNum);
        return apartmentFixNumList;
    }

    @Override
    public List<EchartData> getServiceDegree() {
        ArrayList<EchartData> serviceDegreeList = new ArrayList<>();
        EchartData serviceDegree = echartsMapper.getServiceDegree();
        serviceDegreeList.add(serviceDegree);
        return serviceDegreeList;
    }

}
