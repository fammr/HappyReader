package com.wanfang.dao;

import com.wanfang.model.Article;
import com.wanfang.model.Book;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface ArticleDao {

    @Select("select * from t_article where id = #{id}")
    Article findById(int id) throws SQLException;

    @Select("SELECT * FROM t_article  ORDER BY  RAND() LIMIT 1")
    Article random() throws SQLException;

    @Insert("insert into t_article(name,type,content) values(#{name},#{type},#{content})")
    void insert(Article article) throws SQLException;

    @Select("select count(*) from t_article")
    Integer findCount(int bookId) throws SQLException;
  }