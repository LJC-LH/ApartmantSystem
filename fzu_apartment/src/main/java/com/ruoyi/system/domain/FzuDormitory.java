package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 fzu_dormitory
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public class FzuDormitory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍ID */
    private Long dormId;

    /** 楼栋号 */
    @Excel(name = "楼栋号")
    private String buildingNo;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNo;

    /** 欠费金额 */
    @Excel(name = "欠费金额")
    private Long fees;

    /** 是否欠费 */
    @Excel(name = "是否欠费")
    private String feesStatus;

    /** 缴费类别 */
    @Excel(name = "缴费类别")
    private String feesCategory;

    /** 宿舍使用状态 */
    @Excel(name = "宿舍使用状态")
    private String dormStatus;

    /** 单位负责人 */
    @Excel(name = "单位负责人")
    private String contactPerson;

    /** 单位负责人联系方式 */
    @Excel(name = "单位负责人联系方式")
    private String contactPhone;

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
    public void setFees(Long fees) 
    {
        this.fees = fees;
    }

    public Long getFees() 
    {
        return fees;
    }
    public void setFeesStatus(String feesStatus) 
    {
        this.feesStatus = feesStatus;
    }

    public String getFeesStatus() 
    {
        return feesStatus;
    }
    public void setFeesCategory(String feesCategory) 
    {
        this.feesCategory = feesCategory;
    }

    public String getFeesCategory() 
    {
        return feesCategory;
    }
    public void setDormStatus(String dormStatus) 
    {
        this.dormStatus = dormStatus;
    }

    public String getDormStatus() 
    {
        return dormStatus;
    }
    public void setContactPerson(String contactPerson) 
    {
        this.contactPerson = contactPerson;
    }

    public String getContactPerson() 
    {
        return contactPerson;
    }
    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() 
    {
        return contactPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dormId", getDormId())
            .append("buildingNo", getBuildingNo())
            .append("roomNo", getRoomNo())
            .append("fees", getFees())
            .append("feesStatus", getFeesStatus())
            .append("feesCategory", getFeesCategory())
            .append("dormStatus", getDormStatus())
            .append("contactPerson", getContactPerson())
            .append("contactPhone", getContactPhone())
            .append("remark", getRemark())
            .toString();
    }
}
