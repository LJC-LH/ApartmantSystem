package com.ruoyi.apartment.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

public class FzuCompleteOrders {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生名字 */
    @Excel(name = "学生名字")
    private Long studentId;

    private String studentName;

    /** 楼栋号 */
    @Excel(name = "楼栋号")
    private String buildingNo;

    /*房间号*/
    @Excel(name = "房间号")
    private String roomNo;

    /** 损坏说明 */
    @Excel(name = "损坏说明")
    private String damageDescription;

    /** 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createAt;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long status;

    /** 物业管理部门意见 */
    @Excel(name = "物业管理部门意见")
    private String propertyManagementOpinion;

    /** 预计完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedCompletionTime;

    /** 实际完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualCompletionTime;

    /** 维修人员 */
    @Excel(name = "维修人员")
    private Long repairmanId;

    private String repairmanName;

    /** 校区管理办公室意见 */
    @Excel(name = "校区管理办公室意见")
    private String campusManagementOpinion;

    /** 是否二次派单，布尔类型，true或false */
    @Excel(name = "是否二次派单，布尔类型，true或false")
    private String isSecondaryDispatch;

    /** 二次维修人员 */
    @Excel(name = "二次维修人员")
    private Long secondaryRepairmanId;

    private String secondaryRepairmanName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRepairmanName() {
        return repairmanName;
    }

    public void setRepairmanName(String repairmanName) {
        this.repairmanName = repairmanName;
    }

    public String getSecondaryRepairmanName() {
        return secondaryRepairmanName;
    }

    public void setSecondaryRepairmanName(String secondaryRepairmanName) {
        this.secondaryRepairmanName = secondaryRepairmanName;
    }

    /*新增的图片路径，分为三个*/
    private List<String> stuImagesURL;

    private List<String> onceImagesURL;

    private List<String> secondImagesURL;

    public List<String> getStuImagesURL() {
        return stuImagesURL;
    }

    public void setStuImagesURL(List<String> stuImagesURL) {
        this.stuImagesURL = stuImagesURL;
    }

    public List<String> getOnceImagesURL() {
        return onceImagesURL;
    }

    public void setOnceImagesURL(List<String> onceImagesURL) {
        this.onceImagesURL = onceImagesURL;
    }

    public List<String> getSecondImagesURL() {
        return secondImagesURL;
    }

    public void setSecondImagesURL(List<String> secondImagesURL) {
        this.secondImagesURL = secondImagesURL;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setBuildingNo(String buildingNo)
    {
        this.buildingNo = buildingNo;
    }

    public String getBuildingNo()
    {
        return buildingNo;
    }
    public void setRoomNo(String roomNo)
    {
        this.roomNo = roomNo;
    }

    public String getRoomNo()
    {
        return roomNo;
    }
    public void setDamageDescription(String damageDescription)
    {
        this.damageDescription = damageDescription;
    }

    public String getDamageDescription()
    {
        return damageDescription;
    }
    public void setCreateAt(Date createAt)
    {
        this.createAt = createAt;
    }

    public Date getCreateAt()
    {
        return createAt;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setPropertyManagementOpinion(String propertyManagementOpinion)
    {
        this.propertyManagementOpinion = propertyManagementOpinion;
    }

    public String getPropertyManagementOpinion()
    {
        return propertyManagementOpinion;
    }
    public void setExpectedCompletionTime(Date expectedCompletionTime)
    {
        this.expectedCompletionTime = expectedCompletionTime;
    }

    public Date getExpectedCompletionTime()
    {
        return expectedCompletionTime;
    }
    public void setActualCompletionTime(Date actualCompletionTime)
    {
        this.actualCompletionTime = actualCompletionTime;
    }

    public Date getActualCompletionTime()
    {
        return actualCompletionTime;
    }
    public void setRepairmanId(Long repairmanId)
    {
        this.repairmanId = repairmanId;
    }

    public Long getRepairmanId()
    {
        return repairmanId;
    }
    public void setCampusManagementOpinion(String campusManagementOpinion)
    {
        this.campusManagementOpinion = campusManagementOpinion;
    }

    public String getCampusManagementOpinion()
    {
        return campusManagementOpinion;
    }
    public void setIsSecondaryDispatch(String isSecondaryDispatch)
    {
        this.isSecondaryDispatch = isSecondaryDispatch;
    }

    public String getIsSecondaryDispatch()
    {
        return isSecondaryDispatch;
    }
    public void setSecondaryRepairmanId(Long secondaryRepairmanId)
    {
        this.secondaryRepairmanId = secondaryRepairmanId;
    }

    public Long getSecondaryRepairmanId()
    {
        return secondaryRepairmanId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("studentId", getStudentId())
                .append("buildingNo", getBuildingNo())
                .append("roomNo", getRoomNo())
                .append("damageDescription", getDamageDescription())
                .append("createAt", getCreateAt())
                .append("status", getStatus())
                .append("propertyManagementOpinion", getPropertyManagementOpinion())
                .append("expectedCompletionTime", getExpectedCompletionTime())
                .append("actualCompletionTime", getActualCompletionTime())
                .append("repairmanId", getRepairmanId())
                .append("campusManagementOpinion", getCampusManagementOpinion())
                .append("isSecondaryDispatch", getIsSecondaryDispatch())
                .append("secondaryRepairmanId", getSecondaryRepairmanId())
                .toString();
    }
}
