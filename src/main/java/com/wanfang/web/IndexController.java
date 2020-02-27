package com.wanfang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() throws Exception{
        return "index";
    }

    @RequestMapping("/books")
    public String books() throws Exception{
        return "books";
    }
    @RequestMapping("/search")
    public String search() throws Exception{
        return "search";
    }
    @RequestMapping("/book")
    public String book() throws Exception{
        return "book";
    }

    @RequestMapping("/read")
    public String read() throws Exception{
        return "read";
    }
}
