package com.ckcloud.common.mapper;

import com.ckcloud.common.domain.FileRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    void saveAll(List<FileRequest> files);
}
