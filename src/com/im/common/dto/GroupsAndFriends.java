package com.im.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
* CopyRright (c)2013:		InstantMessage                          
* Project:					InstantMessageClient                                          
* Module ID:				3    
* Comments:  				组和好友类                        
* JDK version used:			JDK 1.7                              
* NameSpace:				com.im.common.dto                         
* Author：					Ellery                 
* Create Date：				2013-12-12 15:36
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:					0.1                       
*/

@SuppressWarnings("serial")
public class GroupsAndFriends implements Serializable{

	//当前用户所拥有的组名称
	private String group_name = "";
	
	//组下面包含的用户列表
	private List<User> friends = new ArrayList<User>();

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
}
