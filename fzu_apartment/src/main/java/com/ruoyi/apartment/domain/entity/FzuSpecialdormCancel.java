package com.ruoyi.apartment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

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

    /** 辅导员意见 */
    @Excel(name = "辅导员意见")
    private String fdyOpinion;

    /** 学工处ID */
    @Excel(name = "学工处ID")
    private Long xgcId;

    /** 学工处意见 */
    @Excel(name = "学工处意见")
    private String xgcOpinion;

    /** 校区管理办公室ID */
    @Excel(name = "校区管理办公室ID")
    private Long manageId;

    /** 校区管理办公室意见 */
    @Excel(name = "校区管理办公室意见")
    private String manageOpinion;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String cancelStatus;

    /** 公寓ID */
    @Excel(name = "公寓ID")
    private Long dormId;

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
            .toString();
    }
}
