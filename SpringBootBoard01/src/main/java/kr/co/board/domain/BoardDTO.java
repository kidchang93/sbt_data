package kr.co.board.domain;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private int id;
    private String title;
    private String contents;
    private Timestamp regDate;
}
