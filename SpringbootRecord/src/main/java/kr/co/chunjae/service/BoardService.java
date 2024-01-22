package kr.co.chunjae.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BoardService {
    public List<Map<String,String>> FindAllList();
}
