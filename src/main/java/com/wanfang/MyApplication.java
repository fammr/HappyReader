package com.wanfang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyApplication {

    public static void main(String[] args) throws Exception{
        String logFile="D:\\logfile.txt";
        BufferedWriter logFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(logFile)),"UTF-8"));

        //String basepath="D:\\小说网站数据\\处理后\\小说天堂\\侦探悬疑\\";
       String basepath="D:\\小说网站数据\\处理后\\下书网\\";
        List<File> allfile=getListFiles(basepath);
        for(File file:allfile){
            if(file.isFile()&&file.getName().endsWith(".txt")){
                //processFile(file,logFileWriter);
               /* if(!file.getName().contains("new.txt")){
                    file.delete();
                }*/
                if(file.getName().contains("new.txt")){
                    File file1=new File(file.getAbsolutePath().replace(".new.txt",""));
                    file.renameTo(file1);
                }
            }
        }
    }

    private static void processFile(File file,BufferedWriter writer){
        /* 读取数据 */
        BufferedReader br=null;
        BufferedWriter bw =null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String newFile=file.getAbsolutePath()+".new.txt";
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(newFile)),"UTF-8"));

            String lineTxt = null;
            int lineNum=0;
            while ((lineTxt = br.readLine()) != null) {
                lineNum++;
                if(contains(lineTxt)){
                    String logText=file.getAbsolutePath()+"###"+lineNum+"###"+lineTxt;
                    writer.write(logText);
                    writer.newLine();
                    continue;
                }
                bw.write(lineTxt);
                bw.newLine();
            }
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }finally {
            try {
                bw.close();
                br.close();
            }catch (Exception e){
                System.err.println("colse errors :" + e);
            }
        }

    }
    private static boolean contains(String text){
        if(text.indexOf("www")!=-1){
            return true;
        }
        if(text.indexOf("Ｗww")!=-1){
            return true;
        }
        if(text.indexOf("w w w")!=-1){
            return true;
        }
        if(text.indexOf("ｗｗｗ")!=-1){
            return true;
        }
        if(text.indexOf("xiaoshuotxt")!=-1){
            return true;
        }
        if(text.indexOf("cＯm")!=-1){
            return true;
        }
        if(text.indexOf("c o m")!=-1){
            return true;
        }
        if(text.indexOf("com")!=-1){
            return true;
        }
        //(下)(.*)(书)(.*)(网)
        //(w|W|ｗ)(.*)(m|M|Ｍ)
        if(text.contains("小")&&text.contains("说")&&text.contains("天")&&text.contains("堂")){
            return true;
        }if(text.contains("大")&&text.contains("学")&&text.contains("生")&&text.contains("小")&&text.contains("说")&&text.contains("网")){
            return true;
        }
        return false;
    }
    /*
     * 获取指定目录下的所有的文件（不包括文件夹），采用了递归
     *
     * @param obj
     * @return
     */
    public static List<File> getListFiles(Object obj) {
        File directory = null;
        if (obj instanceof File) {
            directory = (File) obj;
        } else {
            directory = new File(obj.toString());
        }
        ArrayList<File> files = new ArrayList<File>();
        if (directory.isFile()) {
            files.add(directory);
            return files;
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            for (int i = 0; i < fileArr.length; i++) {
                File fileOne = fileArr[i];
                files.addAll(getListFiles(fileOne));
            }
        }
        return files;
    }

}
