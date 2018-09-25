package com.bwie.xll.mapper;

import org.apache.ibatis.annotations.Select;

public class UserProvider {
	public String findby2(String tname, String rname,String min,String max) {
		  String sql=  "select c.bid,c.bname,c.bdate,COUNT(sc.sid) sid,t.jname,cls.cname "+
   		" FROM  z_class  c " + 
   		"   LEFT JOIN z_student_class sc on c.bid=sc.bid "+
   		"   LEFT JOIN z_zhongjian z on z.bid=c.bid " + 
   		"   LEFT JOIN z_teacher t on t.jid=z.jid" + 
   		"   LEFT JOIN z_classroom cls on cls.cid=z.cid "+
   		"  WHERE t.jname LIKE CONCAT('%',#{tname},'%')  "+
   		"	and c.bname LIKE  CONCAT('%',#{rname},'%') " + 
   		"  GROUP BY c.bid   ";
		if (min!=null || max!=null) {
			sql+=" HAVING "; 
		}
		if (min!=null) {
			sql+=" COUNT(sc.sid) >= #{min} ";
		}
		if (max!=null) {
			sql+=" AND COUNT(sc.sid)<= #{max} ";
		}
		  
		return sql;
	}
	
	
	public String findby3(String tname) {
		return "";
	}
	
	
	public String findByJbidAndClzidAndSname(String s1id, String s2id, String sname){
		 String sql="SELECT * FROM z_student s LEFT JOIN z_student_class sc ON sc.sid=s.sid  \r\n" + 
		 		"LEFT JOIN  z_class c ON sc.bid=c.bid LEFT JOIN z_jiebie j ON j.id=c.jbid where 1=1  ";
		 if (s1id!=null&&!"0".equals(s1id)) {
			sql+=" and j.id= #{s1id} ";
		 }
		 if (s2id!=null&&!"0".equals(s2id)) {
				sql+=" and c.bid=#{s2id} ";
		 }
		 if (sname!=null) {
				sql+=" and sname like '%"+sname+"%' ";
		 }
		 
		return sql;
	}
}
