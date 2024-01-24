package com.ckcloud.commons;

import lombok.Data;

@Data
public class FileDTO {
    private int id;
    private int contentId;
    private String extension;
    private String originalName;
    private String savedName;
    private String thumbName;
    private String originalPath;
    private String savedPath;
    private String thumbPath;


    public FileDTO(String originalFilename, String contentType) {

    }
}
