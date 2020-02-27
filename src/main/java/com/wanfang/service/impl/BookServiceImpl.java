package com.wanfang.service.impl;

import com.wanfang.dao.BookDao;
import com.wanfang.model.Book;
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
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book findById(int id) throws SQLException {
        return bookDao.findById(id);
    }
    @Override
    public Book findByPath(String path) throws SQLException{
        return bookDao.findByPath(path);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(Book book) throws SQLException {
        bookDao.insert(book);
    }
    public void update(Book book) throws SQLException{
        bookDao.update(book);
    }

    @Override
    public void updatePages(Book book) throws SQLException {
        bookDao.updatePages(book);
    }

    @Override
    public List<Book> findByPage(Integer bookType, Integer page, Integer size) throws SQLException{
        int start=0;
        if(page<=1){
            start=0;
        }else{
            start=(page-1)*size;
        }
        return bookDao.findByPage(bookType,start,size);
    }

    @Override
    public List<Book> findByKeyword(Integer bookType, String keyword,Integer page, Integer size) throws SQLException {
        int start=0;
        if(page<=1){
            start=0;
        }else{
            start=(page-1)*size;
        }
        return bookDao.findByKeyword(bookType,keyword,start,size);
    }
}
