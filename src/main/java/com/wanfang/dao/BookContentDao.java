package com.wanfang.dao;

import com.wanfang.model.BookContent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

@Mapper
public interface BookContentDao {

    @Select("select * from t_book_content where bookId = #{0} AND page= #{1}")
    BookContent findById(int bookId,int page) throws SQLException;

    @Insert("insert into t_book_content(bookId,page,content) values(#{bookId},#{page},#{content})")
    void insert(BookContent content) throws SQLException;

    @Select("select count(*) from t_book_content where bookId = #{bookId}")
    Integer findByPages(int bookId) throws SQLException;
}