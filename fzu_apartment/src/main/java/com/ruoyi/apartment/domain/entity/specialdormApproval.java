package com.ruoyi.apartment.domain.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class specialdormApproval {
    private Integer approvalId;
    private Integer studentId;
    private String studentName;
    private String approvalCategory;
    private String approvalReason;
    private Time startTime;
    private Time endTime;
    private Integer fdyId;
    private String fdyOpinion;
    private Integer xgcId;
    private String xgcOpinion;
    private Integer manageId;
    private String manageOpinion;
    private String approvalStatus;
    private String dormId;
}
