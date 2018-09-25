package com.bwie.xll.util;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QrCodeUtil {
	
	
	public static void main(String[] args) throws IOException {
	    String text="http://google.com";
	    String pathname = "new.png";
	    
	    create(text, pathname);
	}

	public static void create(String text, String pathname) throws IOException {
		create(text, pathname, 200, 200);
	}
	public static void create(String text, OutputStream out) throws IOException {
		create(text, out, 200, 200);
	}
	
	public static void setQrCodeHeader(HttpServletResponse res) {
		res.setContentType("image/png; charset=UTF-8");
	}
	public static void create(String text, HttpServletResponse res) throws IOException {
		setQrCodeHeader(res);
		create(text, res.getOutputStream());
	}

	public static void create(String text, String pathname, int width, int height) throws IOException {
		String format="png";
//	    Hashtable hints=new Hashtable();
//	    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//	    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
//	    hints.put(EncodeHintType.MARGIN, 2);
	    try {
	    BitMatrix bitMatrix=new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
		Path file=new File(pathname).toPath();//在D盘生成二维码图片
	     MatrixToImageWriter.writeToPath(bitMatrix, format, file);
	    } catch (WriterException e) {
	    	e.printStackTrace();
	    }
	}
	
	public static void create(String text, OutputStream out, int width, int height) throws IOException {
		String format="png";
//	    Hashtable hints=new Hashtable();
//	    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//	    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
//	    hints.put(EncodeHintType.MARGIN, 2);
	    try {
	    BitMatrix bitMatrix=new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
	     MatrixToImageWriter.writeToStream(bitMatrix, format, out);
	     out.flush();out.close();
	    } catch (WriterException e) {
	    	e.printStackTrace();
	    }
	}
}

