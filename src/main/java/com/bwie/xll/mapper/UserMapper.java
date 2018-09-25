package com.bwie.xll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bwie.xll.bean.Clazz;
import com.bwie.xll.bean.JieBie;
import com.bwie.xll.bean.Student;
/**
 *  班级表中的全部数据
 * */
@Mapper
public interface UserMapper {

	/*班级表的数据*/
    @Select("select c.bid,c.bname,c.bdate,COUNT(sc.sid) sid,t.jname,cls.cname "+
    		" FROM  z_class  c " + 
    		"   LEFT JOIN z_student_class sc on c.bid=sc.bid "+
    		"   LEFT JOIN z_zhongjian z on z.bid=c.bid " + 
    		"   LEFT JOIN z_teacher t on t.jid=z.jid" + 
    		"   LEFT JOIN z_classroom cls on cls.cid=z.cid" + 
    		"  GROUP BY c.bid")
    List<Student> findAll();
    
    @Select("select c.bid,c.bname,c.bdate,COUNT(sc.sid) sid,t.jname,cls.cname "+
    		" FROM  z_class  c " + 
    		"   LEFT JOIN z_student_class sc on c.bid=sc.bid "+
    		"   LEFT JOIN z_zhongjian z on z.bid=c.bid " + 
    		"   LEFT JOIN z_teacher t on t.jid=z.jid" + 
    		"   LEFT JOIN z_classroom cls on cls.cid=z.cid "+
    		"  WHERE t.jname LIKE CONCAT('%',#{tname},'%')  "+
    		"	and c.bname LIKE  CONCAT('%',#{rname},'%') " + 
    		"  GROUP BY c.bid  "
    		+ " HAVING COUNT(sc.sid) >= #{min} AND COUNT(sc.sid)<= #{max} ")
	List<Student> findBy(String tname, String rname,String min,String max);
    
    
	@SelectProvider(type=UserProvider.class,method="findby2")
    List<Student> findBy2(String tname, String rname,String min,String max);
	
	
	@SelectProvider(type=UserProvider.class,method="findby3")
	List<Student> findBy3(String tname);
    
    /**删除班级*/
    @Select("delete from z_class where  bid=#{bid}")
    void del(Integer bid);
    @Select("select * from z_teacher")
	List<Student> selectTeacher();
    
    @Select("SELECT * from z_class c LEFT JOIN z_zhongjian  z on c.bid=z.bid LEFT JOIN z_teacher t on t.jid=z.jid where c.bid=#{bid}")
	Student findById(Integer bid);
    @Insert("insert into  z_zhongjian set jid=#{jid},bid=#{bid}")
	boolean add(Integer jid, Integer bid);

    @Select("select jid from z_zhongjian where bid=#{bid}")
	Integer selectTeacherIdByBid(Integer bid);
    
    
    @Select("SELECT * from z_student where sname=#{sname} and zhuzhi=#{zhuzhi}")
	Student findBySnameAnZhuzhi(String sname,String zhuzhi);

    @Update("update z_student set token=#{token} where  sid=#{sid}")
    void updateUserToken(String token,Integer sid);

    @Select("SELECT * from z_student where token=#{token}")
	Student findByToken(String token);
    @Select("SELECT * from z_jiebie ")
	List<JieBie> listjb();

    @Select("SELECT * from z_class where jbid=#{s1id} ")
	List<Clazz> listByJbid(String s1id);

//    @Select("SELECT * from z_sudent s left join z_student_class sc on sc.sid=s.sid "+
//    "left join  z_class c on sc.bid=c.bid left join z_jiebie j on j.id=c.jbid  "+
//    		" where j.jbid=#{s1id} and c.bid=#{s2id} and sname like '%#{sname}%' ")
//    
    @SelectProvider(type=UserProvider.class,method="findByJbidAndClzidAndSname")
	List<Student> findByJbidAndClzidAndSname(String s1id, String s2id, String sname);
     
}
