package com.ruoyi.apartment.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FzuDormitoryInfo extends BaseEntity {
    @Excel(name = "Userid")
    private Long userId;

    @Excel(name = "楼栋号")
    private String buildingNo;

    @Excel(name = "房间号")
    private String roomNo;

    @Excel(name = "学号")
    private String userName;

    @Excel(name = "学生姓名")
    private String niceName;

    @Excel(name = "性别")
    private Character sex;

    @Excel(name = "床位")
    private String bedNo;

    @Excel(name = "学院")
    private Long deptId;

    @Excel(name = "省份")
    private String province;

    @Excel(name = "学生电话")
    private String stuPhone;

    @Excel(name = "缴费情况")
    private String feesCategory;

    @Excel(name = "宿舍使用情况")
    private String dormStatus;

    @Excel(name = "单位联系人")
    private String contactPerson;

    @Excel(name = "单位联系人电话")
    private String contactPhone;

    @Excel(name = "学籍状态")
    private Character schoolRoll;

    @Excel(name = "校区")
    private Character schoolArea;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getFeesCategory() {
        return feesCategory;
    }

    public void setFeesCategory(String feesCategory) {
        this.feesCategory = feesCategory;
    }

    public String getDormStatus() {
        return dormStatus;
    }

    public void setDormStatus(String dormStatus) {
        this.dormStatus = dormStatus;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Character getSchoolRoll() {
        return schoolRoll;
    }

    public void setSchoolRoll(Character schoolRoll) {
        this.schoolRoll = schoolRoll;
    }

    public Character getSchoolArea() {
        return schoolArea;
    }

    public void setSchoolArea(Character schoolArea) {
        this.schoolArea = schoolArea;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("BuildingNo", getBuildingNo())
                .append("RoomNo", getRoomNo())
                .append("UserName", getUserName())
                .append("NiceName", getNiceName())
                .append("Sex", getSex())
                .append("BedNo", getBedNo())
                .append("DeptId", getDeptId())
                .append("Province", getProvince())
                .append("StuPhone", getStuPhone())
                .append("FeesCategory", getFeesCategory())
                .append("DormStatus", getDormStatus())
                .append("ContactPerson", getContactPerson())
                .append("ContactPhone", getContactPhone())
                .append("SchoolRoll", getSchoolRoll())
                .append("SchoolArea", getSchoolArea())
                .toString();
    }

}
