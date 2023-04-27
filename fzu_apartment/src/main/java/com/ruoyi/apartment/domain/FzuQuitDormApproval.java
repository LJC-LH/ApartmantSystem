package com.ruoyi.apartment.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 休学宿舍退宿对象 fzu_quit_dorm_approval
 * 
 * @author ljc
 * @date 2023-04-26
 */
public class FzuQuitDormApproval extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 退宿申请ID */
    private Long quitId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 学号 */
    @Excel(name = "学号")
    private String userName;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String nickName;

    /** 辅导员 */
    @Excel(name = "辅导员")
    private String fdyName;

    /** 学院 */
    @Excel(name = "学院")
    private Long deptId;

    /** 校区 */
    @Excel(name = "校区")
    private String schoolArea;

    /** 宿舍ID */
    @Excel(name = "宿舍ID")
    private Long dormId;

    /** 楼栋号 */
    @Excel(name = "楼栋号")
    private String buildingNo;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNo;

    /** 床位号 */
    @Excel(name = "床位号")
    private String bedNo;

    /** 退宿原因 */
    @Excel(name = "退宿原因")
    private String quitReason;

    /** 入住时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inTime;

    /** 退宿时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退宿时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outTime;

    /** 辅导员 */
    @Excel(name = "辅导员")
    private Long fdyId;

    /** 辅导员意见 */
    @Excel(name = "辅导员意见")
    private String fdyOpinion;

    /** 学工处 */
    @Excel(name = "学工处")
    private Long xgcId;

    /** 学工处意见 */
    @Excel(name = "学工处意见")
    private String xgcOpinion;

    /** 校区管理办公室 */
    @Excel(name = "校区管理办公室")
    private Long manageId;

    /** 校区管理办公室意见 */
    @Excel(name = "校区管理办公室意见")
    private String manageOpinion;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String quitStatus;

    private String manageName;

    private String xgcName;

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getXgcName() {
        return xgcName;
    }

    public void setXgcName(String xgcName) {
        this.xgcName = xgcName;
    }

    public void setQuitId(Long quitId)
    {
        this.quitId = quitId;
    }

    public Long getQuitId() 
    {
        return quitId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setFdyName(String fdyName) 
    {
        this.fdyName = fdyName;
    }

    public String getFdyName() 
    {
        return fdyName;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setSchoolArea(String schoolArea) 
    {
        this.schoolArea = schoolArea;
    }

    public String getSchoolArea() 
    {
        return schoolArea;
    }
    public void setDormId(Long dormId) 
    {
        this.dormId = dormId;
    }

    public Long getDormId() 
    {
        return dormId;
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
    public void setBedNo(String bedNo) 
    {
        this.bedNo = bedNo;
    }

    public String getBedNo() 
    {
        return bedNo;
    }
    public void setQuitReason(String quitReason) 
    {
        this.quitReason = quitReason;
    }

    public String getQuitReason() 
    {
        return quitReason;
    }
    public void setInTime(Date inTime) 
    {
        this.inTime = inTime;
    }

    public Date getInTime() 
    {
        return inTime;
    }
    public void setOutTime(Date outTime) 
    {
        this.outTime = outTime;
    }

    public Date getOutTime() 
    {
        return outTime;
    }
    public void setFdyId(Long fdyId) 
    {
        this.fdyId = fdyId;
    }

    public Long getFdyId() 
    {
        return fdyId;
    }
    public void setFdyOpinion(String fdyOpinion) 
    {
        this.fdyOpinion = fdyOpinion;
    }

    public String getFdyOpinion() 
    {
        return fdyOpinion;
    }
    public void setXgcId(Long xgcId) 
    {
        this.xgcId = xgcId;
    }

    public Long getXgcId() 
    {
        return xgcId;
    }
    public void setXgcOpinion(String xgcOpinion) 
    {
        this.xgcOpinion = xgcOpinion;
    }

    public String getXgcOpinion() 
    {
        return xgcOpinion;
    }
    public void setManageId(Long manageId) 
    {
        this.manageId = manageId;
    }

    public Long getManageId() 
    {
        return manageId;
    }
    public void setManageOpinion(String manageOpinion) 
    {
        this.manageOpinion = manageOpinion;
    }

    public String getManageOpinion() 
    {
        return manageOpinion;
    }
    public void setQuitStatus(String quitStatus) 
    {
        this.quitStatus = quitStatus;
    }

    public String getQuitStatus() 
    {
        return quitStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("quitId", getQuitId())
            .append("studentId", getStudentId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("fdyName", getFdyName())
            .append("deptId", getDeptId())
            .append("schoolArea", getSchoolArea())
            .append("dormId", getDormId())
            .append("buildingNo", getBuildingNo())
            .append("roomNo", getRoomNo())
            .append("bedNo", getBedNo())
            .append("quitReason", getQuitReason())
            .append("inTime", getInTime())
            .append("outTime", getOutTime())
            .append("fdyId", getFdyId())
            .append("fdyOpinion", getFdyOpinion())
            .append("xgcId", getXgcId())
            .append("xgcOpinion", getXgcOpinion())
            .append("manageId", getManageId())
            .append("manageOpinion", getManageOpinion())
            .append("quitStatus", getQuitStatus())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("manageName", getManageName())
            .append("xgcName", getXgcName())
            .toString();
    }
}
