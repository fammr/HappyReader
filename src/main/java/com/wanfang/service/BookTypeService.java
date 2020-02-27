package com.wanfang.service;


import com.wanfang.model.BookType;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by PhychoLee on 2016/11/4 17:15.
 * Description: 用户Service接口
 */
public interface BookTypeService {

    List<BookType> findall() throws SQLException;

    Map<String,String> mapToId() throws SQLException;
}
