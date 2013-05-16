package com.im.client.function;

import com.im.client.connection.IMClientConnectServer;
import com.im.common.dto.MessageType;
import com.im.common.dto.User;

/** 
* CopyRright (c)2013:		InstantMessage                          
* Project:					InstantMessageClient                                          
* Module ID:				3    
* Comments:  				登录管理              
* JDK version used:			JDK 1.7                              
* NameSpace:				com.im.client.function                   
* Author：					Ellery                 
* Create Date：				2013-05-03 10:55
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:					0.1                       
*/ 

public class IMLoginManager {

	public MessageType userAuthentication(User user){
		return new IMClientConnectServer().authenticationLoginInfoFromServer(user);
	}
}
