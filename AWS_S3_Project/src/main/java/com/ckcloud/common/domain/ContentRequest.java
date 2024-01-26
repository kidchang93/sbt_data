package com.ckcloud.common.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ContentRequest {

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

    private List<MultipartFile> files = new ArrayList<>();
}
