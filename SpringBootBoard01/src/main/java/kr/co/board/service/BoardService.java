package kr.co.board.service;

import kr.co.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<Map<String,String>> list(){

        List<Map<String,String>> list = boardMapper.list();
        return list;
    }
}
