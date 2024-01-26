package com.ckcloud.common.domain;

import com.ckcloud.common.paging.Pagination;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingResponse <T>{

    private List<T> list = new ArrayList<>();
    private Pagination pagination;

    public PagingResponse(List<T> list , Pagination pagination){
        this.list.addAll(list);
        this.pagination = pagination;
    }
}
