package com.ruoyi.apartment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍对象 fzu_studormitory
 *
 * @author ruoyi
 * @date 2023-02-14
 */
public class FzuStuDormitory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍ID */
//    @Excel(name = "宿舍ID")
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
    @Excel(name = "是否欠费", readConverterExp = "0=未欠费,1=已欠费", prompt = "填写：未欠费、已欠费",combo = "未欠费,已欠费")
    private String feesStatus;

    /** 缴费类别 */
    @Excel(name = "缴费类别", readConverterExp = "1=水电费,2=其他费用", prompt = "填写：水电费、其他费用",combo = "水电费,其他费用")
    private String feesCategory;

    /** 宿舍使用状态 */
    @Excel(name = "宿舍使用状态", readConverterExp = "1=闲置,2=使用中,3=特殊宿舍闲置,4=特殊宿舍使用中", prompt = "填写：闲置、使用中、特殊宿舍闲置、特殊宿舍使用中",combo = "闲置,使用中,特殊宿舍闲置,特殊宿舍使用中")
    private String dormStatus;

    /** 单位负责人 */
//    @Excel(name = "单位负责人")
    private String contactPerson;

    /** 单位负责人联系方式 */
//    @Excel(name = "单位负责人联系方式")
    private String contactPhone;

    @Excel(name = "床位号", readConverterExp = "A=A,B=B,C=C,D=D", prompt = "仅填写：A、B、C、D字母即可",combo = "A,B,C,D")
    private String bedNo;
    @Excel(name = "床位使用状态", readConverterExp = "1=闲置,2=使用中", prompt = "填写：闲置、使用中",combo = "闲置,使用中")
    private String bedStatus;

    @Excel(name = "学院/部门",readConverterExp = "205=物理与信息工程学院、微电子学院,204=计算机与大数据学院、软件学院,105=数学与统计学院,210=法学院,103=电气工程与自动化学院,104=机械工程及自动化学院,106=石油化工学院,107=土木工程学院,200=环境与安全工程学院,201=经济与管理学院,202=生物科学与工程学院,203=外国语学院,206=化学学院,207=建筑与城乡规划学院,208=紫金地质与矿业学院,209=材料科学与工程学院,211=人文社会科学学院,214=铜盘校区管理办公室,215=学生工作部（处）", prompt = "请从下拉框选择学院或部门（全称）", combo = "物理与信息工程学院、微电子学院,计算机与大数据学院、软件学院,数学与统计学院,法学院,电气工程与自动化学院,机械工程及自动化学院,石油化工学院,土木工程学院,环境与安全工程学院,经济与管理学院,生物科学与工程学院,外国语学院,化学学院,建筑与城乡规划学院,紫金地质与矿业学院,材料科学与工程学院,人文社会科学学院,铜盘校区管理办公室,学生工作部（处）")
    private Long deptId;

    private String remark;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(String bedStatus) {
        this.bedStatus = bedStatus;
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
                .append("bedNo", getBedNo())
                .append("bedStatus", getBedStatus())
                .append("deptId", getDeptId())
                .toString();
    }
}