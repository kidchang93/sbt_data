package kr.co.chunjae.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    List<Map<String,String>> FindAllList();
}
