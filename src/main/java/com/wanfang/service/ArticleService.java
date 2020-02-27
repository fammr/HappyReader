package com.wanfang.service;

import com.wanfang.model.Article;

import java.sql.SQLException;

public interface ArticleService {

    Article findById(int id) throws SQLException;

    Article random() throws SQLException;

    void insert(Article article) throws SQLException;

    Integer findCount(int articleId) throws SQLException;
  }