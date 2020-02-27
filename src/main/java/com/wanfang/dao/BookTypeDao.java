package com.wanfang.dao;

import com.wanfang.model.BookType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BookTypeDao {

    @Select("select * from t_book_type where id = #{id}")
    BookType findById(String id) throws SQLException;

    @Insert("insert into t_book_type(id,name) values(#{id},#{name})")
    void insert(BookType bookType) throws SQLException;

    @Select("select * from t_book_type")
    List<BookType> findall() throws SQLException;
}