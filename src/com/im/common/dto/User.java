package com.im.common.dto;

import java.io.Serializable;
import java.util.Date;

/** 
* CopyRright (c)2013:		InstantMessage                          
* Project:					InstantMessageClient                                          
* Module ID:				3    
* Comments:  				用户类                        
* JDK version used:			JDK 1.7                              
* NameSpace:				com.im.client.dto                         
* Author：					Ellery                 
* Create Date：				2011-05-03 10:45
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:					0.1                       
*/ 

@SuppressWarnings("serial")
public class User implements Serializable{

	private long id = 0L;
	
	private String im = "";
	
	private String password = "";
	
	private Date registrationDate = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIm() {
		return im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
}
