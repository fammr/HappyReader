package com.wanfang.service.impl;

import com.wanfang.dao.BookContentDao;
import com.wanfang.dao.BookDao;
import com.wanfang.model.Book;
import com.wanfang.model.BookContent;
import com.wanfang.service.BookContentService;
import com.wanfang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by PhychoLee on 2016/11/4 17:18.
 * Description: 用户service实现类
 */
@Service
public class BookContentServiceImpl implements BookContentService {

    @Autowired
    private BookContentDao bookContentDao;


    @Override
    public BookContent findById(int bookId, int page) throws SQLException {
        return bookContentDao.findById(bookId,page);
    }

    @Override
    public void insert(BookContent content) throws SQLException {
        bookContentDao.insert(content);
    }

    @Override
    public Integer findByPages(int bookId) throws SQLException {
        return bookContentDao.findByPages(bookId);
    }
}
