package com.ckcloud.common.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileRequest {
    private int id;
    private int contentId;
    private String extension;
    private String originalName;
    private String savedName;
    private String thumbName;
    private String originalPath;
    private String savedPath;
    private String thumbPath;

    @Builder
    public FileRequest(String extension, String originalName, String savedName, String thumbName, String originalPath, String savedPath, String thumbPath) {
        this.extension = extension;
        this.originalName = originalName;
        this.savedName = savedName;
        this.thumbName = thumbName;
        this.originalPath = originalPath;
        this.savedPath = savedPath;
        this.thumbPath = thumbPath;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

}
