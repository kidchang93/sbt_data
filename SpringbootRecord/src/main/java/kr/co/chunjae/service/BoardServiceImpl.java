package kr.co.chunjae.service;

import kr.co.chunjae.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;
    public List<Map<String,String>> FindAllList() {
        List<Map<String,String>> list = new ArrayList<>();
        list = boardMapper.FindAllList();
        return list;
    }
}
