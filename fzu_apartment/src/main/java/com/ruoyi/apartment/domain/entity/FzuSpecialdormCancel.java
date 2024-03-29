package com.ruoyi.apartment.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 特殊退宿申请对象 fzu_specialdorm_cancel
 *
 * @author wsh
 * @date 2023-02-09
 */
public class FzuSpecialdormCancel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 退宿ID */
    private Long cancelId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 辅导员ID */
    @Excel(name = "辅导员ID")
    private Long fdyId;

    @Excel(name = "辅导员姓名")
    private String fdyName;

    /** 辅导员意见 */
    @Excel(name = "辅导员意见")
    private String fdyOpinion;

    /** 学工处ID */
    @Excel(name = "学工处ID")
    private Long xgcId;

    @Excel(name = "学工处审批人姓名")
    private String xgcName;

    /** 学工处意见 */
    @Excel(name = "学工处意见")
    private String xgcOpinion;

    /** 校区管理办公室ID */
    @Excel(name = "校区管理办公室ID")
    private Long manageId;

    @Excel(name = "校区管理办公室姓名")
    private String manageName;

    /** 校区管理办公室意见 */
    @Excel(name = "校区管理办公室意见")
    private String manageOpinion;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String cancelStatus;

    /** 公寓ID */
    @Excel(name = "公寓ID")
    private Long dormId;

    /** 退宿时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退宿时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    private String dormName;

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public String getDormName() { // Add this getter
        return dormName;
    }

    public void setDormName(String dormName) { // And this setter
        this.dormName = dormName;
    }

    public void setCancelId(Long cancelId)
    {
        this.cancelId = cancelId;
    }

    public Long getCancelId()
    {
        return cancelId;
    }
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentName()
    {
        return studentName;
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
    public void setCancelStatus(String cancelStatus)
    {
        this.cancelStatus = cancelStatus;
    }

    public String getCancelStatus()
    {
        return cancelStatus;
    }
    public void setDormId(Long dormId)
    {
        this.dormId = dormId;
    }

    public Long getDormId()
    {
        return dormId;
    }

    public String getFdyName() {
        return fdyName;
    }

    public void setFdyName(String fdyName) {
        this.fdyName = fdyName;
    }

    public String getXgcName() {
        return xgcName;
    }

    public void setXgcName(String xgcName) {
        this.xgcName = xgcName;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cancelId", getCancelId())
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("fdyId", getFdyId())
            .append("fdyOpinion", getFdyOpinion())
            .append("xgcId", getXgcId())
            .append("xgcOpinion", getXgcOpinion())
            .append("manageId", getManageId())
            .append("manageOpinion", getManageOpinion())
            .append("cancelStatus", getCancelStatus())
            .append("dormId", getDormId())
            .append("remark", getRemark())
            .append("manageName", getManageName())
            .append("fdyName", getFdyName())
            .append("xgcName", getXgcName())
            .append("endTime", getEndTime())
            .toString();
    }
}
