package com.example.resttemplatetest.test;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Getter
@Setter

public class RestAPITestDTO {

    private List<MinorClassification> minorClassification;
    private List<String> levelCnt;
    private String questionForm;
    private List<Long> activityCategoryList;

    @Builder
    private static class MinorClassification {
        private Long subject;
        private Long large;
        private Long medium;
        private Long small;
        private Long topic;
    }

}
