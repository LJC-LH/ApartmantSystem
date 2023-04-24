package com.ruoyi.apartment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍调整对象 fzu_change_dormitory
 *
 * @author ljc
 * @date 2023-04-24
 */
public class FzuChangeDormitory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long changeId;

    /** 交换学生id */
    @Excel(name = "交换学生id")
    private Long oneStudentId;

    /** 交换学生学号 */
    @Excel(name = "交换学生学号")
    private String oneUserName;

    /** 交换学生姓名 */
    @Excel(name = "交换学生姓名")
    private String oneNickName;

    /** 原宿舍号 */
    @Excel(name = "原宿舍号")
    private Long oneDormId;

    /** 原宿舍楼栋 */
    @Excel(name = "原宿舍楼栋")
    private String oneBuildingNo;

    /** 原房间号 */
    @Excel(name = "原房间号")
    private String oneRoomNo;

    /** 原床位号 */
    @Excel(name = "原床位号")
    private String oneBedNo;

    /** 被交换学生id */
    @Excel(name = "被交换学生id")
    private Long twoStudentId;

    /** 被交换学生学号 */
    @Excel(name = "被交换学生学号")
    private String twoUserName;

    /** 被交换学生姓名 */
    @Excel(name = "被交换学生姓名")
    private String twoNickName;

    /** 新宿舍号 */
    @Excel(name = "新宿舍号")
    private Long twoDormId;

    /** 新宿舍楼栋 */
    @Excel(name = "新宿舍楼栋")
    private String twoBuildingNo;

    /** 新房间号 */
    @Excel(name = "新房间号")
    private String twoRoomNo;

    /** 新床位号 */
    @Excel(name = "新床位号")
    private String twoBedNo;

    private Long deptId;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setChangeId(Long changeId)
    {
        this.changeId = changeId;
    }

    public Long getChangeId()
    {
        return changeId;
    }
    public void setOneStudentId(Long oneStudentId)
    {
        this.oneStudentId = oneStudentId;
    }

    public Long getOneStudentId()
    {
        return oneStudentId;
    }
    public void setOneUserName(String oneUserName)
    {
        this.oneUserName = oneUserName;
    }

    public String getOneUserName()
    {
        return oneUserName;
    }
    public void setOneNickName(String oneNickName)
    {
        this.oneNickName = oneNickName;
    }

    public String getOneNickName()
    {
        return oneNickName;
    }
    public void setOneDormId(Long oneDormId)
    {
        this.oneDormId = oneDormId;
    }

    public Long getOneDormId()
    {
        return oneDormId;
    }
    public void setOneBuildingNo(String oneBuildingNo)
    {
        this.oneBuildingNo = oneBuildingNo;
    }

    public String getOneBuildingNo()
    {
        return oneBuildingNo;
    }
    public void setOneRoomNo(String oneRoomNo)
    {
        this.oneRoomNo = oneRoomNo;
    }

    public String getOneRoomNo()
    {
        return oneRoomNo;
    }
    public void setOneBedNo(String oneBedNo)
    {
        this.oneBedNo = oneBedNo;
    }

    public String getOneBedNo()
    {
        return oneBedNo;
    }
    public void setTwoStudentId(Long twoStudentId)
    {
        this.twoStudentId = twoStudentId;
    }

    public Long getTwoStudentId()
    {
        return twoStudentId;
    }
    public void setTwoUserName(String twoUserName)
    {
        this.twoUserName = twoUserName;
    }

    public String getTwoUserName()
    {
        return twoUserName;
    }
    public void setTwoNickName(String twoNickName)
    {
        this.twoNickName = twoNickName;
    }

    public String getTwoNickName()
    {
        return twoNickName;
    }
    public void setTwoDormId(Long twoDormId)
    {
        this.twoDormId = twoDormId;
    }

    public Long getTwoDormId()
    {
        return twoDormId;
    }
    public void setTwoBuildingNo(String twoBuildingNo)
    {
        this.twoBuildingNo = twoBuildingNo;
    }

    public String getTwoBuildingNo()
    {
        return twoBuildingNo;
    }
    public void setTwoRoomNo(String twoRoomNo)
    {
        this.twoRoomNo = twoRoomNo;
    }

    public String getTwoRoomNo()
    {
        return twoRoomNo;
    }
    public void setTwoBedNo(String twoBedNo)
    {
        this.twoBedNo = twoBedNo;
    }

    public String getTwoBedNo()
    {
        return twoBedNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("changeId", getChangeId())
                .append("oneStudentId", getOneStudentId())
                .append("oneUserName", getOneUserName())
                .append("oneNickName", getOneNickName())
                .append("oneDormId", getOneDormId())
                .append("oneBuildingNo", getOneBuildingNo())
                .append("oneRoomNo", getOneRoomNo())
                .append("oneBedNo", getOneBedNo())
                .append("twoStudentId", getTwoStudentId())
                .append("twoUserName", getTwoUserName())
                .append("twoNickName", getTwoNickName())
                .append("twoDormId", getTwoDormId())
                .append("twoBuildingNo", getTwoBuildingNo())
                .append("twoRoomNo", getTwoRoomNo())
                .append("twoBedNo", getTwoBedNo())
                .append("deptId", getDeptId())
                .append("createTime", getCreateTime())
                .toString();
    }
}
