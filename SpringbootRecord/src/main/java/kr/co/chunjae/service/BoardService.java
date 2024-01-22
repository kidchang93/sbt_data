package kr.co.chunjae.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface BoardService {
    public List<Map<String,String>> FindAllList();
}
