package com.ruoyi.apartment.domain.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class User {
    private Integer userId;
    private Integer deptId;
    private String userName;
    private String nickName;
    private String userType;
    private String email;
    private String phoneNumber;
    private String sex;
    private String province;
    private String schoolRoll;
    private String schoolArea;
    private String acatar;
    private String password;
    private String status;
    private String delFlag;
    private String loginIp;
    private Time loginDate;
    private String createBy;
    private Time createTime;
    private String updateBy;
    private Time updateTime;
    private String remark;
    // Getters and setters ...
}
