package com.wanfang.web;

import com.wanfang.model.Article;
import com.wanfang.model.Book;
import com.wanfang.model.BookContent;
import com.wanfang.model.BookType;
import com.wanfang.service.ArticleService;
import com.wanfang.service.BookContentService;
import com.wanfang.service.BookService;
import com.wanfang.service.BookTypeService;
import com.wanfang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private BookService bookervice;
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private BookContentService bookContentService;

    private static final int pageSize=18;

    @RequestMapping("/welcome")
    @ResponseBody
    public Article welcome() throws Exception{
        return articleService.random();
    }

    @RequestMapping("/categorys")
    @ResponseBody
    public List<BookType> categorys() throws Exception{
        List<BookType>  list=bookTypeService.findall();
        return list;
    }

    @RequestMapping("/booklist")
    @ResponseBody
    public List<Book> bookList(int category,int page) throws Exception{
        List<Book>  list=bookervice.findByPage(category,page,pageSize);
        return list;
    }

    @RequestMapping("/searchbook")
    @ResponseBody
    public List<Book> searchbook( int page,String keyword) throws Exception{
        if(keyword==null||"".equals(keyword)){
           return new ArrayList<>();
        }
        keyword = URLDecoder.decode(keyword, "utf-8");
        List<Book>  list=bookervice.findByKeyword(0,keyword,page,pageSize);
        Map<String,String> map=bookTypeService.mapToId();
        for(Book book:list){
            book.setBookType(map.get(book.getBookType()));
        }
        return list;
    }

    @RequestMapping("/content")
    @ResponseBody
    public BookContent content(int id,int page) throws Exception{
        BookContent bookContent=bookContentService.findById(id,page);
        bookContent.setContent(bookContent.getContent().replaceAll("(\\r\\n|\\n|\\n\\r)","<br/>"));
        return bookContent;
    }

    @RequestMapping("/bookdetail")
    @ResponseBody
    public Book bookDetail(int id) throws Exception{
        Book  book=bookervice.findById(id);
        return book;
    }
}
