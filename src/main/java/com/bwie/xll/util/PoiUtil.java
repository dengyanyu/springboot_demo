package com.bwie.xll.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bwie.xll.bean.Student;

/**
 * @author wc
 * 
 * 生成：
 * 	String head[]=new String[] {"姓名","年龄","生日"};
		String head_colum[]=new String[] {"name","age","birthday"};
		
		List<Stu> list=new  ArrayList<Stu>();
		for (int i = 0; i < 200; i++) {
			Stu u = new Stu("姓名"+i, i, new Date());
			list.add(u);
		}
		FileOutputStream ou = new FileOutputStream("a.xlsx");
		export(head,head_colum,list,ou);
		
		
 * 
 *
 */
public class PoiUtil {
	public static void main(String[] args) throws Exception {
		
	
//		读取
		String path = "a.xlsx";
		
	    ArrayList<Map<String, String>> list = readToMap(path);
	    
	    for (Map<String, String> map : list) {
	    	System.out.println(map);
		}
        
	}



	public static ArrayList<Map<String, String>> readToMap(String path) throws IOException {
		ArrayList<Map<String, String>> list=new ArrayList<Map<String,String>>();//存放结果
		
		XSSFWorkbook wb = new XSSFWorkbook(path);
		XSSFSheet s0 = wb.getSheetAt(0);
		int rnum = s0.getLastRowNum();
		for (int i = 1; i <= rnum; i++) {
			Map<String,String> m=new HashMap<String,String>();//一行记录对应的数据
			XSSFRow r = s0.getRow(i);
			short cnum = r.getLastCellNum();
			
			for (int j = 0; j < cnum; j++) {
				String value = r.getCell(j)+"";//当前单元格内容
				String key=s0.getRow(0).getCell(j)+"";
				m.put(key, value);
			}
			
			list.add(m);
		}
		return list;
	}

	
	
	public static void setExcelHeader(HttpServletResponse res) {
		res.setContentType("application/vnd.ms-excel;charset=utf-8");
		res.setCharacterEncoding("UTF-8");
	}


	public static void export(String[] head, String[] head_colum, List list, OutputStream ou) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (head==null||head.length==0) {
			head=head_colum;
		}
		
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet s1 = wb.createSheet("导出结果");
		//头信息
		XSSFRow r0 = s1.createRow(0);
		for (int i=0;i<head.length;i++) {
			XSSFCell c = r0.createCell(i);
			c.setCellValue(head[i]);
		}
		
		for (int li=1;li<=list.size();li++) {
			Object o = list.get(li-1);
			XSSFRow r = s1.createRow(li);//每条数据一行
			for (int i=0;i<head_colum.length;i++) {
				XSSFCell c = r.createCell(i);
				
				//调用反射获取字段对应的值
				Method m = ReflectionUtils.getMethod(o.getClass(), "get"+upfirst(head_colum[i]));
				Object v = ReflectionUtils.invokeMethod(m, o);
				c.setCellValue(v+"");//通过反射 获取list中的对象的字段值
			}
		}
	
		
		
		wb.write(ou);
		ou.flush();ou.close();
	}

	private static String upfirst(String str) {
		return  str.substring(0,1).toUpperCase().concat(str.substring(1));
	}



	public static void export(String[] head, String[] head_colum, List<Student> list, HttpServletResponse resp) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		setExcelHeader(resp);
		export(head, head_colum, list, resp.getOutputStream());
	}
	
	
}

class Stu{
	
	public Stu(String name, int age, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	private String name;
	private int age;
	private Date birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
