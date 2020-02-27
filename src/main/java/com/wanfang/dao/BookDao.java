package com.wanfang.dao;

import com.wanfang.model.Book;
import com.wanfang.model.BookType;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BookDao {

    @Select("select * from t_book where id = #{id}")
    Book findById(int id) throws SQLException;

    @Select("select * from t_book where path = #{path}")
    Book findByPath(String path) throws SQLException;

    @Insert("insert into t_book(bookName,bookType,author,pages,path) values(#{bookName},#{bookType},#{author},#{pages},#{path})")
    void insert(Book book) throws SQLException;

    @Update("update t_book set brief=#{brief} where id=#{id}")
    void update(Book book) throws SQLException;

    @Update("update t_book set pages=#{pages} where id=#{id}")
    void updatePages(Book book) throws SQLException;

    @Select("select * from t_book where bookType = #{bookType} limit #{start},#{size}")
    List<Book> findByPage(@Param("bookType") Integer bookType, @Param("start") Integer start, @Param("size") Integer size) throws SQLException;

    @Select("<script>"+"SELECT * FROM t_book  WHERE  1=1 "
            +"<if test='bookType!=0'> and bookType = #{bookType} </if>"
            +"<if test='keyword!=null'>  and (bookName like CONCAT('%',#{keyword},'%')  or author like CONCAT('%',#{keyword},'%')) </if> "
            +"   limit #{start},#{size} "
            +"</script>" )
    List<Book> findByKeyword(@Param("bookType") Integer bookType,@Param("keyword")String keyword, @Param("start") Integer start, @Param("size") Integer size) throws SQLException;
}