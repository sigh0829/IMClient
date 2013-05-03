package com.im.client.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.im.common.dto.MessageType;
import com.im.common.dto.User;

/** 
* CopyRright (c)2013:		InstantMessage                          
* Project:					InstantMessageClient                                          
* Module ID:				3    
* Comments:  				客户端与服务器连接类                        
* JDK version used:			JDK 1.7                              
* NameSpace:				com.im.client.connection                         
* Author：					Ellery                 
* Create Date：				2011-05-03 11:03
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:					0.1                       
*/ 

public class IMClientConnectServer {

	public MessageType authenticationLoginInfoFromServer(Object object){
		
		Socket socket = null;
		MessageType messageType = null;
		
		try {
			messageType = new MessageType();
			socket = new Socket("127.0.0.1", 8989);
			
			//向服务器传送用户信息
			User user = (User)object;
			System.out.println("---"+user.getIm()+user.getPassword());
			ObjectOutputStream userInfoOOS = new ObjectOutputStream(socket.getOutputStream());
			userInfoOOS.writeObject(object);
			
			//读取服务器返回数据信息
			ObjectInputStream userInfoOIS = new ObjectInputStream(socket.getInputStream());
			messageType = (MessageType)userInfoOIS.readObject();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return messageType;
		
	}
}
