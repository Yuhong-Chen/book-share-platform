package com.kelly.Test1;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Alien {
	private int id;
	private String userName;
	private String userPwd;
	
	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Alien(int id, String userName, String userPwd) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
