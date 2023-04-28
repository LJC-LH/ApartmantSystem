package com.ruoyi.apartment.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class FzuUserRoot extends BaseEntity {
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

    private Date startTime;

    private Date endTime;

}
