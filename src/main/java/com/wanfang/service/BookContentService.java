package com.wanfang.service;

import com.wanfang.model.Book;
import com.wanfang.model.BookContent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by PhychoLee on 2016/11/4 17:15.
 * Description: 用户Service接口
 */
public interface BookContentService {

    BookContent findById(int bookId, int page) throws SQLException;

    void insert(BookContent content) throws SQLException;

    Integer findByPages(int bookId) throws SQLException;

}