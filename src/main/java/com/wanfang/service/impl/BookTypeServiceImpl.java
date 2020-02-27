package com.wanfang.service.impl;

import com.wanfang.dao.BookTypeDao;
import com.wanfang.model.BookType;
import com.wanfang.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PhychoLee on 2016/11/4 17:18.
 * Description: 用户service实现类
 */
@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeDao bookTypeDao;

    @Override
    public List<BookType> findall() throws SQLException {
        return bookTypeDao.findall();
    }

    public Map<String,String> mapToId() throws SQLException{
       Map<String,String> map=new HashMap<>();
       List<BookType> list=bookTypeDao.findall();
       for(BookType bookType:list){
           map.put(bookType.getName(),bookType.getId());
           map.put(bookType.getId(),bookType.getName());
       }
       return map;
    };

}
