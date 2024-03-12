package com.example.resttemplatetest.test;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;


@Builder
public class RestAPITestDTO {

    private long subject;
    private long large;
    private long medium;
    private long small;
    private long topic ;
    private String levelCnt;
    private String questionForm;
    private long[] activityCategoryList;

}
