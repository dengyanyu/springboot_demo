package com.bwie.xll.bean;
/**
  *   学生班级管理属性
 * */
public class Student {
    /**班级编号   */
	private Integer bid;
	/**班级名称*/
	private String bname;
	/**班级组建日期*/
	private String bdate;
	/**学生姓名*/
	private  String sname;
	/**学生家庭住址*/
	private  String zhuzhi;
	/**学生编号*/
	private  Integer sid;
	/**讲师id*/
	private Integer jid;
	/**讲师名称*/
	private  String jname;
	/**讲师年龄*/
	private Integer age;
	/**讲师入职日期*/
	private String jdate;
	/**班级编号*/
	private Integer cid;
	/**班级地址编号*/
	private String cname;
	/**班级地址*/
	private String address;
	
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getZhuzhi() {
		return zhuzhi;
	}
	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getJdate() {
		return jdate;
	}
	public void setJdate(String jdate) {
		this.jdate = jdate;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
