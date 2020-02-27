package com.wanfang.service;

import com.wanfang.model.Book;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by PhychoLee on 2016/11/4 17:15.
 * Description: 用户Service接口
 */
public interface BookService {

    Book findById(int id) throws SQLException;

    Book findByPath(String path) throws SQLException;

    void insert(Book book) throws SQLException;

    void update(Book book) throws SQLException;

    void updatePages(Book book) throws SQLException;

    List<Book> findByPage(Integer bookType, Integer page, Integer size) throws SQLException;

    List<Book> findByKeyword(@Param("bookType") Integer bookType, @Param("keyword")String keyword, @Param("start") Integer start, @Param("size") Integer size) throws SQLException;

}
