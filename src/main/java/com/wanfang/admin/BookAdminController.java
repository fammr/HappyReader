package com.wanfang.admin;

import com.healthmarketscience.jackcess.*;
import com.wanfang.model.Article;
import com.wanfang.model.Book;
import com.wanfang.model.BookContent;
import com.wanfang.service.ArticleService;
import com.wanfang.service.BookContentService;
import com.wanfang.service.BookService;
import com.wanfang.service.BookTypeService;
import com.wanfang.util.FileUtil;
import com.wanfang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookAdminController {

    @Autowired
    private BookService bookervice;
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private BookContentService bookContentService;
    @Autowired
    private ArticleService articleService;


    @RequestMapping("/importbook")
    @ResponseBody
    public void importBook() throws Exception{
        Map<String,String> map=bookTypeService.mapToId();
        String basePath="D:\\小说网站数据\\处理后\\小说天堂\\";
        List<File> allfile=FileUtil.getListFiles(basePath);
        for(File file:allfile){
            if(file.isFile()&&file.getName().endsWith(".txt")){
                String abspath=file.getAbsolutePath();
                String relaticePath=abspath.replace(basePath,"");
                String book_type=map.get(relaticePath.subSequence(0,relaticePath.indexOf("\\")));
                String fileName=file.getName();
                fileName= fileName.substring(0, fileName.lastIndexOf("."));
                String[] temp=fileName.split("_");
                String bookName=temp[0];

                Book book=new Book();
                book.setBookType(book_type);
                book.setBookName(bookName);
                if(temp.length==2){
                    String author=temp[1];
                    book.setAuthor(author);
                }
                book.setPath(abspath);
                bookervice.insert(book);
            }
        }
        System.out.println("处理完成");
    }


    @RequestMapping("/importcontent")
    @ResponseBody
    public void importcontent() throws Exception{
        Map<String,String> map=bookTypeService.mapToId();
        String basePath="D:\\小说网站数据\\处理后\\小说天堂\\";
        List<File> allfile=FileUtil.getListFiles(basePath);
        for(File file:allfile){
            if(file.isFile()&&file.getName().endsWith(".txt")){
                Book book=bookervice.findByPath(file.getAbsolutePath());
                FileChannel fileChannel=new FileInputStream(file).getChannel();
                long length=fileChannel.size();
                ByteBuffer buffer=ByteBuffer.allocate((int)length);
                fileChannel.read(buffer);
                String str=new String(buffer.array());
                List<String>  contents=StringUtil.getStrList(str,2000);

                for(int i=0;i<contents.size();i++){
                    BookContent bookContent=new BookContent();
                    bookContent.setBookId(book.getId());
                    String ontent=contents.get(i).replaceAll("(\\r\\n|\\n|\\n\\r)","<br/>");
                    bookContent.setContent(ontent);
                    bookContent.setPage(i+1);
                    bookContentService.insert(bookContent);
                }
            }
        }
        System.out.println("处理完成");
    }

    @RequestMapping("/importcontent1")
    @ResponseBody
    public void importcontent1() throws Exception{

        String userPath=System.getProperty("user.dir");
        String file11=userPath+"/内容导入5.mdb";
        Database db = DatabaseBuilder.create(Database.FileFormat.V2000, new File(file11));
        List<String> columnName=new ArrayList<>();
        columnName.add("bookId");
        columnName.add("page");
        columnName.add("content");
        TableBuilder tableBuilder = new TableBuilder("bookContent");

        for(String column:columnName){
            tableBuilder.addColumn(new ColumnBuilder(column).setSQLType(Types.LONGNVARCHAR));
        }
        Table table=tableBuilder.toTable(db);


        Map<String,String> map=bookTypeService.mapToId();
        String basePath="D:\\小说网站数据\\处理后\\小说天堂\\";
        List<File> allfile=FileUtil.getListFiles(basePath);
        for(File file:allfile){
            if(file.isFile()&&file.getName().endsWith(".txt")){
                Book book=bookervice.findByPath(file.getAbsolutePath());
                if(Integer.valueOf(book.getId())<7214){
                    continue;
                }
                FileChannel fileChannel=new FileInputStream(file).getChannel();
                long length=fileChannel.size();
                ByteBuffer buffer=ByteBuffer.allocate((int)length);
                fileChannel.read(buffer);
                String str=new String(buffer.array());
                List<String>  contents=StringUtil.getStrList(str,2000);

                List< Map<String,Object>> temp=new ArrayList<>();
                for(int i=0;i<contents.size();i++){
                    Map<String,Object> map1=new HashMap();
                    String content=contents.get(i).replaceAll("(\\r\\n|\\n|\\n\\r)","<br/>");
                    map1.put("bookId",book.getId());
                    map1.put("page",String.valueOf(i+1));
                    map1.put("content",content);
                    temp.add(map1);
                }
                table.addRowsFromMaps(temp);

            }
        }
        System.out.println("处理完成");
    }

    @RequestMapping("/importbrief")
    @ResponseBody
    public void importbrief() throws Exception{
        for(int i=2680;i<8688;i++){
            BookContent bookContent=null;
            try {
                bookContent=bookContentService.findById(i,1);
            }catch (Exception e){
                Book book=new Book();
                book.setId(i);
                book.setBrief("暂无");
                System.out.println(i);
                bookervice.update(book);
                continue;
            }
            String[] contentArray=bookContent.getContent().split("<br/>");
            String brief="暂无";
            if(contentArray!=null&&contentArray.length>0){
                for(String content:contentArray){
                    if(content.length()>20){
                        int length=content.length()>300?300:content.length();
                        brief=content.substring(0,length);
                    }
                }
            }
            Book book=new Book();
            book.setId(i);
            book.setBrief(brief);
            bookervice.update(book);
        }
        System.out.println("处理完成");

    }

    @RequestMapping("/importpages")
    @ResponseBody
    public void importpages() throws Exception{
        for(int i=2425;i<8688;i++){
            int pages=0;
            try {
                pages=bookContentService.findByPages(i);
            }catch (Exception e){
                Book book=new Book();
                book.setId(i);
                book.setPages(0);
                System.out.println(i);
                bookervice.updatePages(book);
                continue;
            }
            Book book=new Book();
            book.setId(i);
            book.setPages(pages);
            bookervice.updatePages(book);
        }
        System.out.println("处理完成");

    }


    @RequestMapping("/importarticle")
    @ResponseBody
    public void importarticle() throws Exception{

        String basePath="D:\\小说网站数据\\处理后\\短文TXT\\智慧故事";
        List<File> allfile=FileUtil.getListFiles(basePath);
        Charset charset = Charset.forName("gb2312");//Java.nio.charset.Charset处理了字符转换问题。它通过构造CharsetEncoder和CharsetDecoder将字符序列转换成字节和逆转换。
        CharsetDecoder decoder = charset.newDecoder();
        for(File file:allfile){
            if(file.isFile()&&file.getName().endsWith(".txt")){
//                String charset=FileUtil.resolveCode(file.getAbsolutePath());
                FileChannel fileChannel=new FileInputStream(file).getChannel();
                long length=fileChannel.size();
                ByteBuffer buffer=ByteBuffer.allocate((int)length);
                CharBuffer charBuffer = CharBuffer.allocate((int)length);
                int bytes = fileChannel.read(buffer);
                buffer.flip();
                decoder.decode(buffer, charBuffer, false);
                charBuffer.flip();
                String str=charBuffer.toString();
                Article article=new Article();
                article.setName(str.split("\r\n")[1]);
                article.setContent(str);
                article.setType("智慧故事");

                articleService.insert(article);
            }
        }
        System.out.println("处理完成");
    }


}
