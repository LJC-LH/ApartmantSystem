package com.ruoyi.common.core.domain.entity;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.xss.Xss;

/**
 * 用户对象 sys_user
 * 
 * @author ruoyi
 */
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
//    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "用户编号")
    private Long userId;

    /** 部门ID */
    @Excel(name = "学院/部门", type = Type.IMPORT,readConverterExp = "205=物理与信息工程学院、微电子学院,204=计算机与大数据学院、软件学院,105=数学与统计学院,210=法学院,103=电气工程与自动化学院,104=机械工程及自动化学院,106=石油化工学院,107=土木工程学院,200=环境与安全工程学院,201=经济与管理学院,202=生物科学与工程学院,203=外国语学院,206=化学学院,207=建筑与城乡规划学院,208=紫金地质与矿业学院,209=材料科学与工程学院,211=人文社会科学学院,214=铜盘校区管理办公室,215=学生工作部（处）,216=物业部门", prompt = "请从下拉框选择学院或部门（全称）", combo = "物理与信息工程学院、微电子学院,计算机与大数据学院、软件学院,数学与统计学院,法学院,电气工程与自动化学院,机械工程及自动化学院,石油化工学院,土木工程学院,环境与安全工程学院,经济与管理学院,生物科学与工程学院,外国语学院,化学学院,建筑与城乡规划学院,紫金地质与矿业学院,材料科学与工程学院,人文社会科学学院,铜盘校区管理办公室,学生工作部（处）,物业部门")
    private Long deptId;

    /** 用户账号 */
    @Excel(name = "工号/学号")
    private String userName;

    /** 用户昵称 */
    @Excel(name = "真实名称")
    private String nickName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 用户性别 */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知", prompt = "填写：男、女",combo = "男,女")
    private String sex;

    /**
     * 增加省份、学籍和校区
     */
    @Excel(name = "省份", prompt = "仅学生填写：省份如（福建），不需要带“省”字")
    private String province;

    @Excel(name = "学籍状态", readConverterExp = "0=注册在籍,1=已离校,2=保留学籍,3=已休学", prompt = "仅学生填写：注册在籍、已离校、保留学籍、已休学",combo = "注册在籍,已离校,保留学籍,已休学")
    private String schoolRoll;

    @Excel(name = "就读学历层次", prompt = "仅学生填写：本科生、硕士研究生、博士研究生",combo = "本科生,硕士研究生,博士研究生")
    private String studyLevel;

    @Excel(name = "校区", readConverterExp = "1=旗山校区,2=铜盘校区,3=怡山校区", prompt = "仅学生填写：如，铜盘校区、旗山校区等")
    private String schoolArea;

    @Excel(name = "单位联系人（辅导员）工号")
    private String fdyNumber;

    @Excel(name = "单位联系人（辅导员）姓名")
    private String fdyName;

    private String fdyId;

    @Excel(name = "单位联系人电话", type = Type.EXPORT)
    private String fdyPhonenumber;

    public String getFdyPhonenumber() {
        return fdyPhonenumber;
    }

    public void setFdyPhonenumber(String fdyPhonenumber) {
        this.fdyPhonenumber = fdyPhonenumber;
    }

    public String getFdyNumber() {
        return fdyNumber;
    }

    public void setFdyNumber(String fdyNumber) {
        this.fdyNumber = fdyNumber;
    }

    public String getFdyName() {
        return fdyName;
    }

    public void setFdyName(String fdyName) {
        this.fdyName = fdyName;
    }

    public String getFdyId() {
        return fdyId;
    }

    public void setFdyId(String fdyId) {
        this.fdyId = fdyId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSchoolRoll() {
        return schoolRoll;
    }

    public void setSchoolRoll(String schoolRoll) {
        this.schoolRoll = schoolRoll;
    }

    public String getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }

    public String getSchoolArea() {
        return schoolArea;
    }

    public void setSchoolArea(String schoolArea) {
        this.schoolArea = schoolArea;
    }

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 帐号状态（0正常 1停用） */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用", prompt = "填写：正常、停用",combo = "正常,停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 最后登录IP */
//    @Excel(name = "最后登录IP", type = Type.EXPORT)
    private String loginIp;

    /** 最后登录时间 */
//    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date loginDate;

    /** 部门对象 */
    @Excels({
        @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
//        @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept dept;

    /** 角色对象 */
    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private Long[] postIds;

    /** 角色ID */
    @Excel(name = "用户角色", type = Type.IMPORT, cellType = ColumnType.NUMERIC, readConverterExp = "2=学生,100=辅导员,101=学工部（处）,102=铜盘校区管理办公室,103=物业管理部门,104=楼管人员,105=维修人员", prompt = "填写：学生、辅导员、学工部（处）、铜盘校区管理办公室、物业管理部门、楼管人员、维修人员",combo ="学生,辅导员,学工部（处）,铜盘校区管理办公室,物业管理部门,楼管人员,维修人员")
    private Long roleId;

    private Date startTime;

    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public SysUser()
    {

    }

    public SysUser(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    @Xss(message = "用户昵称不能包含脚本字符")
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    @Xss(message = "用户账号不能包含脚本字符")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public Date getLoginDate()
    {
        return loginDate;
    }

    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }

    public SysDept getDept()
    {
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }

    public List<SysRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }

    public Long[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds()
    {
        return postIds;
    }

    public void setPostIds(Long[] postIds)
    {
        this.postIds = postIds;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("province",getProvince())
            .append("schoolRoll",getSchoolRoll())
            .append("studyLevel",getStudyLevel())
            .append("schoolArea",getSchoolArea())
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
            .append("dept", getDept())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
