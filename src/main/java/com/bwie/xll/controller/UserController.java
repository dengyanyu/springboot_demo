package com.bwie.xll.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bwie.xll.bean.Clazz;
import com.bwie.xll.bean.JieBie;
import com.bwie.xll.bean.Student;
import com.bwie.xll.mapper.UserMapper;
import com.bwie.xll.util.CookieUtil;
import com.bwie.xll.util.PoiUtil;
import com.bwie.xll.util.QrCodeUtil;
import com.bwie.xll.util.UploadUtil;
import com.bwie.xll.util.UserUtil;
import com.bwie.xll.util.ZipUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 *  1.教务课表发布管理系统
 * */
@Controller
public class UserController {
    /*映射到mapper层*/
  @Autowired
  private UserMapper mapper;
  
  /**
   *  班级表中的全部数据-分页
 * */
@RequestMapping("page")
public String page(HttpServletRequest request,
		Model model,
		@RequestParam(defaultValue="1") Integer pageNum,
		@RequestParam(defaultValue="5") Integer pageSize,
		@RequestParam(defaultValue="") String tname,
		@RequestParam(defaultValue="") String rname,
		@RequestParam(defaultValue="0") String min ,
		@RequestParam(defaultValue=Integer.MAX_VALUE+"") String max) {
	 
	 
	 PageHelper.startPage(pageNum,pageSize);//设置分页信息
	 
	 List<Student> list=this.mapper.findBy( "%"+tname+"%","%"+rname+"%",min,max);
     
     PageInfo<Student> page = new PageInfo<Student>(list);// 组装分页
     
     model.addAttribute("page",page);
     model.addAttribute("tname",tname);
     model.addAttribute("rname",rname);
	 //跳转页面list
	  return "page";
}


/**
 *  班级表中的全部数据-分页
* */
@RequestMapping("page2")
public String page2(HttpServletRequest request,
		Model model,
		@RequestParam(defaultValue="1") Integer pageNum,
		@RequestParam(defaultValue="5") Integer pageSize,
		@RequestParam(defaultValue="") String tname,
		@RequestParam(defaultValue="") String rname,
		String min ,
		 String max) {
	 
	 
	 PageHelper.startPage(pageNum,pageSize);//设置分页信息
	 
	 List<Student> list=this.mapper.findBy2( "%"+tname+"%","%"+rname+"%",min,max);
   
   PageInfo<Student> page = new PageInfo<Student>(list);// 组装分页
   
   model.addAttribute("page",page);
   model.addAttribute("tname",tname);
   model.addAttribute("rname",rname);
	 //跳转页面list
	  return "page2";
}



  /**
     *  班级表中的全部数据
   * */
  @RequestMapping("list")
  public String findAll(HttpServletRequest request) {
	  /*班级表的数据*/
	 List<Student> list=this.mapper.findAll();
	 //request的请求
	 request.setAttribute("list", list);
	 //跳转页面list
	  return "list";
  }
  /**
    *  根据id删除表中的数据
  * */
  @RequestMapping("del")
  public String del(Integer bid) {
	  //调用删除方法
	  this.mapper.del(bid);
	  //返回查询方法
	  return "redirect:list";
  }
  /**显示所有讲师列表 选择讲师*/
  @RequestMapping("selectTeacher")
  public  String js(HttpServletRequest request,Integer bid) {
      /**把班级编号放到作用域中*/
	  request.getSession().setAttribute("bid", bid);
	  
	  /**查询当前班级的讲师*/
     Integer tid=this.mapper.selectTeacherIdByBid(bid);
	  
	  /**调用查询讲师方法*/
      List<Student> list=this.mapper.selectTeacher();
     //request的请求
      request.setAttribute("list",list);
      request.setAttribute("tid",tid);
	  //返回讲师列表
	  return "selectTeacher";
  }
  
  /**分配讲师职责*/
  @RequestMapping("fen")
  @ResponseBody
  public boolean fen(Integer jid,HttpServletRequest request) {
    Integer bid = (Integer) request.getSession().getAttribute("bid");
     Student stu=this.mapper.findById(bid);
     System.out.println(stu.getJid());
     if(stu.getJid()!=null) {
    	return false;
     }else {
    	 boolean flag=this.mapper.add(jid,bid);
    	 System.out.println(flag);
    	 return flag;
     }
	 
  }
  
  
  
  	/**
	   *  班级表中的全部数据
	 * @throws IOException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * */
	@RequestMapping("export")
	public String export(HttpServletResponse resp) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 
		/*班级表的数据*/
		List<Student> list=this.mapper.findAll();
		String[] head=new String[] {"编号","班级名","讲师名"};
		String[] head_colum=new String[] {"bid","bname","jname"};
		
		PoiUtil.export(head, head_colum, list, resp);
		 
		return null;
	}
	
	@RequestMapping("qrcode")
	public String qrcode(HttpServletResponse resp) throws IOException{
		QrCodeUtil.create("http://sina.com", resp);
		return null;
	}
	@RequestMapping("zip")
	public String zip(HttpServletResponse resp) throws Exception{
		
		
		QrCodeUtil.create("http://sina.com", "a.png");
		QrCodeUtil.create("http://sina.com", "b.png");
		QrCodeUtil.create("http://sina.com", "c.png");
		ArrayList<File> fs = new ArrayList<File>() {
			{
				add(new File("a.png"));
				add(new File("b.png"));
				add(new File("c.png"));
			}
		};
		ZipUtil.generateZip(resp, fs);
		return null;
	}
	
	@ResponseBody
	@RequestMapping("login")
	public Student login(String name,String pwd,String rem,HttpServletResponse resp,HttpServletRequest req) {
		if ("true".equals(rem)) {
			//记住密码
			CookieUtil.addCookie(resp, "name", name, 30*24*3600);
			CookieUtil.addCookie(resp, "pwd", pwd, 30*24*3600);
		}
		
		Student stu = mapper.findBySnameAnZhuzhi(name, pwd);
		
		
		if (stu!=null) {//密码正确
			String token=UUID.randomUUID().toString();
			mapper.updateUserToken(token,stu.getSid());
			
			CookieUtil.addCookie(resp, "token", token, 30*24*3600);
			UserUtil.setUser(req, stu.getSid()+"");
		}
		return stu;
	}
	
	@RequestMapping("loginPage")
	public String loginPage(HttpServletRequest req,HttpServletResponse resp,Model model) {
		model.addAttribute("name",CookieUtil.getCookie(req, "name"));
		model.addAttribute("pwd",CookieUtil.getCookie(req, "pwd"));
		
		
		String token = CookieUtil.getCookie(req, "token");
		if (token!=null) {
			Student stu=mapper.findByToken(token);
			if (stu!=null) {
				UserUtil.setUser(req, stu.getSid()+"");
				model.addAttribute("stu",stu);
			}
		}
		
		return "loginPage";
	}

  
	
	@ResponseBody
	@RequestMapping("s1")
	public List<JieBie> s1(HttpServletResponse resp,HttpServletRequest req) {
		List<JieBie> list=mapper.listjb();
		return list;
	}
	@ResponseBody
	@RequestMapping("s2")
	public List<Clazz> s2(String s1id,HttpServletResponse resp,HttpServletRequest req) {
		List<Clazz> list=mapper.listByJbid(s1id);
		return list;
	}
	@RequestMapping("select")
	public String s2(String s1id,String s2id,String sname,HttpServletResponse resp,HttpServletRequest req) {
		List<Student> list=mapper.findByJbidAndClzidAndSname( s1id, s2id, sname);
		req.setAttribute("list", list);
		req.setAttribute("s1id", s1id);
		req.setAttribute("s2id", s2id);
		req.setAttribute("sname", sname);
		return "select";
	}
	
	
	 @RequestMapping("/upload1")
	 public String upload1() {
		 return "upload1";
	 }
	
	@RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("a") MultipartFile afile,@RequestParam("b") MultipartFile bfile){
		String afilename = "H://"+UUID.randomUUID()+".jpg";//afile.getOriginalFilename();//根前台文件名一致
		String bfilename = "H://"+UUID.randomUUID()+".jpg";//afile.getOriginalFilename();//根前台文件名一致
		int ars = UploadUtil.upload(afile, afilename);
		int brs = UploadUtil.upload(bfile, bfilename);
        return ars+" "+brs;
    }
	
	
	
	@RequestMapping("/uploadExcel")
    @ResponseBody
    public String uploadExcel(@RequestParam("a") MultipartFile afile ) throws IOException{
		String afilename = "H://"+UUID.randomUUID()+".xlsx";//afile.getOriginalFilename();//根前台文件名一致
		int ars = UploadUtil.upload(afile, afilename);
		
		ArrayList<Map<String, String>> list = PoiUtil.readToMap(afilename.toString());
		
		for (Map<String, String> map : list) {
			Student s=new Student();
			s.setBname(map.get("姓名"));
			s.setBdate(map.get("生日"));
		}
		
        return "上传成功 请核对数据库";
    }
	
	
	
	@RequestMapping("/download")
    @ResponseBody
    public String download(String file,HttpServletResponse resp) throws IOException{
		String filename = "H://"+file;//afile.getOriginalFilename();//根前台文件名一致
		
		UploadUtil.download(file, resp, filename);
		
        return "文件不存在";
    }

	
	
	@ResponseBody
	@RequestMapping("ztreejson")
	public List<JieBie> ztreejson(HttpServletResponse resp,HttpServletRequest req) {
		List<JieBie> list=mapper.listjb();
		for (JieBie jieBie : list) {
			List<Clazz> clazzList=mapper.listByJbid(jieBie.getId()+"");
			jieBie.setClazzList(clazzList);
		}
		return list;
	}

	


	
}
