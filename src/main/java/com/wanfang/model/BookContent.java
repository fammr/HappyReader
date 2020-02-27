package com.wanfang.model;

public class BookContent {

    private String id;

    private Integer bookId;

    private Integer page;

    private String content;

    public BookContent() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BookContent{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", page=" + page +
                ", content='" + content + '\'' +
                '}';
    }
}