package com.bwie.xll.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
	public static int upload(MultipartFile afile, String filename) {
		if(!afile.isEmpty()){
            try {
				File file = new File(filename);
				if (!file.exists()) {
					file.createNewFile();
				}
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                out.write(afile.getBytes());
                out.flush();
                out.close();
            }catch(FileNotFoundException e) {
                e.printStackTrace();
                return -1;
            }catch (IOException e) {
                e.printStackTrace();
                return -1;
            }

            return 1;

        }else{

            return -1;

        }
	}
	
	
	public static void download(String file, HttpServletResponse resp, String filename)
			throws FileNotFoundException, IOException {
		File f = new File(filename);
		
		if(f.exists()) {
			resp.setContentType("application/force-download");// 设置强制下载不打开
			resp.addHeader("Content-Disposition", "attachment;fileName=" + file);// 设置文件名
			
			FileInputStream fi = new FileInputStream(f);
			byte[] bs=new byte[1024];
			while(fi.read(bs)!=-1) {//还可以读
				resp.getOutputStream().write(bs);
			}
			
		}
	}
}
