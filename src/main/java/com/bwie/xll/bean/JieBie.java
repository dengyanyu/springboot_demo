package com.bwie.xll.bean;

import java.util.List;

/**
  界别
 * */
public class JieBie {
	private Integer id;
	private String jbname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJbname() {
		return jbname;
	}
	public void setJbname(String jbname) {
		this.jbname = jbname;
	}
	
	List<Clazz> clazzList;
	public List<Clazz> getClazzList() {
		return clazzList;
	}
	public void setClazzList(List<Clazz> clazzList) {
		this.clazzList = clazzList;
	}
	 
}
