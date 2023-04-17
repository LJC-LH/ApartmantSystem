package com.ruoyi.apartment.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生订单对象 fzu_repair_orders
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
public class stuOrders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 外键，关联fzu_student_dormitory表的student_id */
    @Excel(name = "外键，关联fzu_student_dormitory表的student_id")
    private Long studentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String buildingNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String roomNo;

    /** 损坏说明 */
    @Excel(name = "损坏说明")
    private String damageDescription;

    /** 创建时间
 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createAt;

    /** 例如：待研判，待派单，维修中，暂不能维修，已完成等 */
    @Excel(name = "例如：待研判，待派单，维修中，暂不能维修，已完成等")
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

    /** 维修人员id，关联sys_user_role表的user_id，通过角色关联维修人员 */
    @Excel(name = "维修人员")
    private Long repairmanId;

    /** 校区管理办公室意见 */
    @Excel(name = "校区管理办公室意见")
    private String campusManagementOpinion;

    /** 是否二次派单，布尔类型，true或false */
    @Excel(name = "是否二次派单，布尔类型，true或false")
    private String isSecondaryDispatch;

    /** 二次维修人员id，关联sys_user_role表的user_id，通过角色关联维修人员 */
    @Excel(name = "二次维修人员id，关联sys_user_role表的user_id，通过角色关联维修人员")
    private Long secondaryRepairmanId;

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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
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
