package com.ruoyi.apartment.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 sys_user
 * 
 * @author ruoyi
 * @date 2023-02-05
 */
public class FzuSysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    private Long dormId;

    /** 部门ID */
    @Excel(name = "学院/部门",readConverterExp = "205=物理与信息工程学院、微电子学院,204=计算机与大数据学院、软件学院,105=数学与统计学院,210=法学院,103=电气工程与自动化学院,104=机械工程及自动化学院,106=石油化工学院,107=土木工程学院,200=环境与安全工程学院,201=经济与管理学院,202=生物科学与工程学院,203=外国语学院,206=化学学院,207=建筑与城乡规划学院,208=紫金地质与矿业学院,209=材料科学与工程学院,211=人文社会科学学院,214=铜盘校区管理办公室,215=学生工作部（处）", prompt = "请从下拉框选择学院或部门（全称）", combo = "物理与信息工程学院、微电子学院,计算机与大数据学院、软件学院,数学与统计学院,法学院,电气工程与自动化学院,机械工程及自动化学院,石油化工学院,土木工程学院,环境与安全工程学院,经济与管理学院,生物科学与工程学院,外国语学院,化学学院,建筑与城乡规划学院,紫金地质与矿业学院,材料科学与工程学院,人文社会科学学院,铜盘校区管理办公室,学生工作部（处）")
    private Long deptId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userName;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 用户类型（00系统用户） */
    @Excel(name = "用户类型", readConverterExp = "0=0系统用户")
    private String userType;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 用户性别（0男 1女 2未知） */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 学籍状态 */
    @Excel(name = "学籍状态")
    private String schoolRoll;

    /** 就读学历层次 */
    @Excel(name = "就读学历层次")
    private String studyLevel;

    /** 校区 */
    @Excel(name = "校区")
    private String schoolArea;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatar;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 帐号状态（0正常 1停用） */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 最后登录IP */
    @Excel(name = "最后登录IP")
    private String loginIp;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginDate;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
//    public void setUserName(String userName)
//    {
//        this.userName = userName;
//    }

//    public String getUserName()
//    {
//        return userName;
//    }
//    public void setNickName(String nickName)
//    {
//        this.nickName = nickName;
//    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setUserType(String userType) 
    {
        this.userType = userType;
    }

    public String getUserType() 
    {
        return userType;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setSchoolRoll(String schoolRoll) 
    {
        this.schoolRoll = schoolRoll;
    }

    public String getSchoolRoll() 
    {
        return schoolRoll;
    }
    public void setStudyLevel(String studyLevel) 
    {
        this.studyLevel = studyLevel;
    }

    public String getStudyLevel() 
    {
        return studyLevel;
    }
    public void setSchoolArea(String schoolArea) 
    {
        this.schoolArea = schoolArea;
    }

    public String getSchoolArea() 
    {
        return schoolArea;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setLoginIp(String loginIp) 
    {
        this.loginIp = loginIp;
    }

    public String getLoginIp() 
    {
        return loginIp;
    }
    public void setLoginDate(Date loginDate) 
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate() 
    {
        return loginDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
//            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("userType", getUserType())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("province", getProvince())
            .append("schoolRoll", getSchoolRoll())
            .append("studyLevel", getStudyLevel())
            .append("schoolArea", getSchoolArea())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
