package com.ruoyi.apartment.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维修明细对象 fzu_repair_orders
 *
 * @author ljc
 * @date 2023-05-22
 */
public class RepairExcelOutput extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报修号 */
    private Long repairId;

    /** 学生id */
    private Long studentId;

    @Excel(name = "学生姓名")
    private String studentName;

    /** 楼栋号 */
    @Excel(name = "楼栋号")
    private String buildingNo;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNo;

    /** 损坏说明 */
    @Excel(name = "损坏说明")
    private String damageDescription;

    /** 报修类型（水工、电工等） */
    @Excel(name = "报修类型", readConverterExp = "1=门,2=灯具,3=插座,4=开关,5=床,6=设备,7=窗户,8=天花板,9=墙面,10=地面,11=水池,12=阀门,13=花洒,14=马桶,15=水龙头,16=管道,17=线路,18=电箱,19=柜子,20=桌子,21=椅子,22=锁,23=栏杆,24=晒衣架,25=水表,26=地漏,27=设备房,28=其他")
    private String fixType;

    /** 报修创建时间 */
    @JsonFormat(pattern = "yyyy-MM")
    @Excel(name = "报修创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createAt;

    /** 报修状态 */
    @Excel(name = "报修状态", readConverterExp = "0=待派单,1=维修中,2=不能维修,3=待二次派单,4=已完成")
    private String fixStatus;

    /** 一次维修人员id */
    private Long firstRepairmanId;

    @Excel(name = "一次维修人员姓名")
    private String firstRepairmanName;

    /** 第一次维修内容 */
    @Excel(name = "第一次维修内容")
    private String firstWorkContent;

    /** 第一次报修完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "第一次报修完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstCompletionTime;

    /** 校区管理办公室意见 */
    @Excel(name = "校区管理办公室意见")
    private String campusManagementOpinion;

    /** 是否二次派单 */
    @Excel(name = "是否二次派单",readConverterExp = "0=否,1=是")
    private String isSecondDispatch;

    /** 学生评价内容 */
    @Excel(name = "学生评价内容")
    private String evaluateContent;

    /** 学生评分(1-5分) */
    @Excel(name = "学生评分(1-5分)")
    private Long evaluateRate;

    /** 二次维修人员id */
    private Long secondaryRepairmanId;

    @Excel(name = "二次维修人员")
    private String secondaryRepairmanName;

    /** 第二次报修预计完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "第二次报修预计完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date secondExpectedCompletionTime;

    /** 第二次报修实际完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "第二次报修实际完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date secondActualCompletionTime;

    /** 第二次维修内容 */
    @Excel(name = "第二次维修内容")
    private String secondWorkContent;


    public void setRepairId(Long repairId)
    {
        this.repairId = repairId;
    }

    public Long getRepairId()
    {
        return repairId;
    }
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFirstRepairmanName() {
        return firstRepairmanName;
    }

    public void setFirstRepairmanName(String firstRepairmanName) {
        this.firstRepairmanName = firstRepairmanName;
    }

    public String getSecondaryRepairmanName() {
        return secondaryRepairmanName;
    }

    public void setSecondaryRepairmanName(String secondaryRepairmanName) {
        this.secondaryRepairmanName = secondaryRepairmanName;
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
    public void setFixType(String fixType)
    {
        this.fixType = fixType;
    }

    public String getFixType()
    {
        return fixType;
    }
    public void setCreateAt(Date createAt)
    {
        this.createAt = createAt;
    }

    public Date getCreateAt()
    {
        return createAt;
    }
    public void setFixStatus(String fixStatus)
    {
        this.fixStatus = fixStatus;
    }

    public String getFixStatus()
    {
        return fixStatus;
    }
    public void setFirstRepairmanId(Long firstRepairmanId)
    {
        this.firstRepairmanId = firstRepairmanId;
    }

    public Long getFirstRepairmanId()
    {
        return firstRepairmanId;
    }
    public void setFirstWorkContent(String firstWorkContent)
    {
        this.firstWorkContent = firstWorkContent;
    }

    public String getFirstWorkContent()
    {
        return firstWorkContent;
    }
    public void setFirstCompletionTime(Date firstCompletionTime)
    {
        this.firstCompletionTime = firstCompletionTime;
    }

    public Date getFirstCompletionTime()
    {
        return firstCompletionTime;
    }
    public void setCampusManagementOpinion(String campusManagementOpinion)
    {
        this.campusManagementOpinion = campusManagementOpinion;
    }

    public String getCampusManagementOpinion()
    {
        return campusManagementOpinion;
    }
    public void setIsSecondDispatch(String isSecondDispatch)
    {
        this.isSecondDispatch = isSecondDispatch;
    }

    public String getIsSecondDispatch()
    {
        return isSecondDispatch;
    }
    public void setEvaluateContent(String evaluateContent)
    {
        this.evaluateContent = evaluateContent;
    }

    public String getEvaluateContent()
    {
        return evaluateContent;
    }
    public void setEvaluateRate(Long evaluateRate)
    {
        this.evaluateRate = evaluateRate;
    }

    public Long getEvaluateRate()
    {
        return evaluateRate;
    }
    public void setSecondaryRepairmanId(Long secondaryRepairmanId)
    {
        this.secondaryRepairmanId = secondaryRepairmanId;
    }

    public Long getSecondaryRepairmanId()
    {
        return secondaryRepairmanId;
    }
    public void setSecondExpectedCompletionTime(Date secondExpectedCompletionTime)
    {
        this.secondExpectedCompletionTime = secondExpectedCompletionTime;
    }

    public Date getSecondExpectedCompletionTime()
    {
        return secondExpectedCompletionTime;
    }
    public void setSecondActualCompletionTime(Date secondActualCompletionTime)
    {
        this.secondActualCompletionTime = secondActualCompletionTime;
    }

    public Date getSecondActualCompletionTime()
    {
        return secondActualCompletionTime;
    }
    public void setSecondWorkContent(String secondWorkContent)
    {
        this.secondWorkContent = secondWorkContent;
    }

    public String getSecondWorkContent()
    {
        return secondWorkContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("repairId", getRepairId())
            .append("studentId", getStudentId())
            .append("buildingNo", getBuildingNo())
            .append("roomNo", getRoomNo())
            .append("damageDescription", getDamageDescription())
            .append("fixType", getFixType())
            .append("createAt", getCreateAt())
            .append("fixStatus", getFixStatus())
            .append("firstRepairmanId", getFirstRepairmanId())
            .append("firstWorkContent", getFirstWorkContent())
            .append("firstCompletionTime", getFirstCompletionTime())
            .append("campusManagementOpinion", getCampusManagementOpinion())
            .append("isSecondDispatch", getIsSecondDispatch())
            .append("evaluateContent", getEvaluateContent())
            .append("evaluateRate", getEvaluateRate())
            .append("secondaryRepairmanId", getSecondaryRepairmanId())
            .append("secondExpectedCompletionTime", getSecondExpectedCompletionTime())
            .append("secondActualCompletionTime", getSecondActualCompletionTime())
            .append("secondWorkContent", getSecondWorkContent())
            .append("studentName", getStudentName())
            .append("firstRepairmanName", getFirstRepairmanName())
            .append("secondaryRepairmanName", getSecondaryRepairmanName())
            .toString();
    }
}
