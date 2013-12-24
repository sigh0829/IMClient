package com.im.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/** 
* CopyRright (c)2013:		InstantMessage                          
* Project:					InstantMessageClient                                          
* Module ID:				3    
* Comments:  				用户类                        
* JDK version used:			JDK 1.7                              
* NameSpace:				com.im.common.dto                         
* Author：					Ellery                 
* Create Date：				2013-05-03 10:45
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:					0.1                       
*/ 

@SuppressWarnings("serial")
public class User implements Serializable{

	private long id = 0L;
	
	private String imcode = "";
	
	private String password = "";
	
	private Timestamp registration_date = null;
	
	private String username = "";
	
	private String avatar = "";
	
	@Override
	public String toString() {
		return "用户信息：id = " + id + ",imcode = " + imcode 
				+ ",registration_date = " + registration_date 
				+ ",username = " + username + ",avatar = " + avatar;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImcode() {
		return imcode;
	}

	public void setImcode(String imcode) {
		this.imcode = imcode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Timestamp registration_date) {
		this.registration_date = registration_date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
