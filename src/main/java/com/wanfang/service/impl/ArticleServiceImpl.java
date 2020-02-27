package com.wanfang.service.impl;

import com.wanfang.dao.ArticleDao;
import com.wanfang.model.Article;
import com.wanfang.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleDao articleDao;

    @Override
    public Article findById(int id) throws SQLException {
        return articleDao.findById(id);
    }
    @Override
    public Article random() throws SQLException {
        return articleDao.random();
    }
    @Override
    public void insert(Article article) throws SQLException {
        articleDao.insert(article);
    }

    @Override
    public Integer findCount(int articleId) throws SQLException {
        return articleDao.findCount(articleId);
    }
}
