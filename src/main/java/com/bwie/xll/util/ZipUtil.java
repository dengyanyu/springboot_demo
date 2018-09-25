package com.bwie.xll.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ZipUtil {
	
	
	public static void main(String[] args) throws FileNotFoundException, Exception {
		generateZip(new FileOutputStream("x.zip"), new File("H:\\xx"));
	}
	
	public static void setZipHeader(HttpServletResponse res) {
		res.setContentType("application/x-zip-compressed; charset=UTF-8");
	}
	
	
	public static void generateZip(HttpServletResponse res, File file) throws Exception {
		 
		generateZip(res, Arrays.asList(file.listFiles()));
	}
	public static void generateZip(HttpServletResponse res, List<File> files) throws Exception {
		setZipHeader(res);
		ServletOutputStream out = res.getOutputStream();
		generateZip(out, files);
		out.flush();out.close();
		
	}
	
	
	public static void generateZip(FileOutputStream os, File file) throws Exception {
		generateZip(os, file.listFiles());
	}


	public static void generateZip(OutputStream os, File[] files) throws Exception {
		generateZip(os, Arrays.asList(files));
	}
	 /**
     * 打包成zip包
     */
    public static void generateZip(OutputStream os, List<File> files) throws Exception {
        ZipOutputStream out = null;
        try {
            byte[] buffer = new byte[1024];
            //生成的ZIP文件名为Demo.zip
            out = new ZipOutputStream(os);
            //需要同时下载的两个文件result.txt ，source.txt
            for (File file : files) {
                FileInputStream fis = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                //读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                out.flush();
                out.closeEntry();
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
