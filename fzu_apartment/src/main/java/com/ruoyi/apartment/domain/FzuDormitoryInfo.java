package com.ruoyi.apartment.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FzuDormitoryInfo extends BaseEntity {
//    @Excel(name = "Userid")
    private Long userId;

    @Excel(name = "楼栋号")
    private String buildingNo;

    @Excel(name = "房间号")
    private String roomNo;

    @Excel(name = "学号")
    private String userName;

    @Excel(name = "学生姓名")
    private String niceName;

    @Excel(name = "性别", type = Type.EXPORT, readConverterExp = "0=男,1=女,2=未知")
    private Character sex;

    @Excel(name = "床位号", prompt = "仅填写：A、B、C、D字母即可",combo = "A,B,C,D")
    private String bedNo;

    @Excel(name = "学院/部门", type = Type.EXPORT, readConverterExp = "205=物理与信息工程学院、微电子学院,204=计算机与大数据学院、软件学院,105=数学与统计学院,210=法学院,103=电气工程与自动化学院,104=机械工程及自动化学院,106=石油化工学院,107=土木工程学院,200=环境与安全工程学院,201=经济与管理学院,202=生物科学与工程学院,203=外国语学院,206=化学学院,207=建筑与城乡规划学院,208=紫金地质与矿业学院,209=材料科学与工程学院,211=人文社会科学学院,214=铜盘校区管理办公室,215=学生工作部（处）")
    private Long deptId;

    @Excel(name = "省份", type = Type.EXPORT)
    private String province;

    @Excel(name = "学生电话", type = Type.EXPORT)
    private String stuPhone;

    @Excel(name = "缴费类别", type = Type.EXPORT, readConverterExp = "1=水电费,2=其他费用")
    private String feesCategory;

    @Excel(name = "是否欠费", type = Type.EXPORT, readConverterExp = "0=未欠费,1=已欠费")
    private String feesStatus;

    @Excel(name = "宿舍使用情况", type = Type.EXPORT, readConverterExp = "1=闲置,2=使用中,3=特殊宿舍")
    private String dormStatus;

    @Excel(name = "单位联系人", type = Type.EXPORT)
    private String contactPerson;

    @Excel(name = "单位联系人电话", type = Type.EXPORT)
    private String contactPhone;

    @Excel(name = "学籍状态", type = Type.EXPORT, readConverterExp = "0=注册在籍,1=已离校,2=保留学籍")
    private Character schoolRoll;

    @Excel(name = "校区", type = Type.EXPORT, readConverterExp = "1=旗山校区,2=铜盘校区,3=怡山校区")
    private Character schoolArea;

    private String fdyNumber;

    private String fdyName;

    private Long fdyId;

    private String fdyPhone;

    public String getFdyPhone() {
        return fdyPhone;
    }

    public void setFdyPhone(String fdyPhone) {
        this.fdyPhone = fdyPhone;
    }

    public String getFdyNumber() {
        return fdyNumber;
    }

    public void setFdyNumber(String fdyNumber) {
        this.fdyNumber = fdyNumber;
    }

    public String getFdyName() {
        return fdyName;
    }

    public void setFdyName(String fdyName) {
        this.fdyName = fdyName;
    }

    public Long getFdyId() {
        return fdyId;
    }

    public void setFdyId(Long fdyId) {
        this.fdyId = fdyId;
    }

    private Long dormId;

    public Long getDormId() {
        return dormId;
    }

    public void setDormId(Long dormId) {
        this.dormId = dormId;
    }

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

    public String getFeesStatus() {
        return feesStatus;
    }

    public void setFeesStatus(String feesStatus) {
        this.feesStatus = feesStatus;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("dormId", getDormId())
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
                .append("FeesStatus", getFeesStatus())
                .append("DormStatus", getDormStatus())
                .append("ContactPerson", getContactPerson())
                .append("ContactPhone", getContactPhone())
                .append("SchoolRoll", getSchoolRoll())
                .append("SchoolArea", getSchoolArea())
                .toString();
    }

}
