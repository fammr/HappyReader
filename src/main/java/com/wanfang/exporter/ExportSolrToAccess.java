package com.wanfang.exporter;

import com.healthmarketscience.jackcess.*;
import com.wanfang.model.BookContent;

import java.io.*;
import java.sql.Types;
import java.util.*;

/**
 * 导出Access
 * */
public class ExportSolrToAccess {


    static {
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void jsonsToAccessesFile(String fileName, List<BookContent> searchers) throws Exception {
        String userPath=System.getProperty("user.dir");
        String file=userPath+"/"+fileName+".mdb";
        Database db = DatabaseBuilder.create(Database.FileFormat.V2000, new File(file));
        List<String> columnName=new ArrayList<>();
        columnName.add("bookId");
        columnName.add("page");
        columnName.add("content");
        TableBuilder tableBuilder = new TableBuilder("bookContent");

        for(String column:columnName){
            tableBuilder.addColumn(new ColumnBuilder(column).setSQLType(Types.LONGNVARCHAR));
        }
        Table table=tableBuilder.toTable(db);
        if(searchers!=null&&searchers.size()>0) {
            List< Map<String,Object>> temp=new ArrayList<>(searchers.size());
            for(BookContent searcher:searchers) {
                Map<String,Object> map=new HashMap();
                map.put("bookId",searcher.getBookId());
                map.put("page",searcher.getPage());
                map.put("content",searcher.getContent());
                temp.add(map);
            }
            table.addRowsFromMaps(temp);
        }
        db.close();
    }

}
