package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 fzu_student_dormitory
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public class FzuStudentDormitory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long studentId;

    /** 宿舍ID */
    @Excel(name = "宿舍ID")
    private Long dormId;

    /** 床位 */
    @Excel(name = "床位")
    private String bedNo;

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setDormId(Long dormId) 
    {
        this.dormId = dormId;
    }

    public Long getDormId() 
    {
        return dormId;
    }
    public void setBedNo(String bedNo) 
    {
        this.bedNo = bedNo;
    }

    public String getBedNo() 
    {
        return bedNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("dormId", getDormId())
            .append("bedNo", getBedNo())
            .toString();
    }
}
