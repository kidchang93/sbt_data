package kr.co.chunjae.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardVO {
    private int id;
    private String title;
    private String contents;
    private Timestamp regDate;
}
