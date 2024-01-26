package com.ckcloud.common.domain;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
public class ContentResponse {
    private int id;
    private int userId;
    private int type;
    private int charge;
    private int view;
    private String title;
    private String keyword;
    private String description;
    private Timestamp registDate;
    private int updateFlag;
    private Timestamp updateDate;
    private int deleteFlag;
    private Timestamp deleteDate;
    private int approveFlag;
    private int approveUserId;
}
