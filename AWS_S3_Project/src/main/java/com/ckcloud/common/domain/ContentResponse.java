package com.ckcloud.common.domain;

import lombok.Getter;

import java.sql.Timestamp;
@Getter
public class ContentResponse {
    private int id;
    private int user_id;
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