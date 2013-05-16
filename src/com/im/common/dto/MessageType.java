package com.im.common.dto;

import java.io.Serializable;

/** 
* CopyRright (c)2013:		InstantMessage                          
* Project:					InstantMessageServer                                          
* Module ID:				3    
* Comments:  				消息类                 
* JDK version used:			JDK 1.7                              
* NameSpace:				com.im.common.dto                         
* Author：					Ellery                 
* Create Date：				2013-05-09 14:54
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:					0.1                       
*/ 

@SuppressWarnings("serial")
public class MessageType implements Serializable{

	private int messageTypeID = 0;
	
	//消息类型名称
	private String messageTypeName = "";
	
	//消息发送者
	private String sender = "";
	
	//消息接收者
	private String receiver = "";
	
	//消息内容
	private String message = "";
	
	//消息发送时间
	private String sendTime = "";

	public int getMessageTypeID() {
		return messageTypeID;
	}

	public void setMessageTypeID(int messageTypeID) {
		this.messageTypeID = messageTypeID;
	}

	public String getMessageTypeName() {
		return messageTypeName;
	}

	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
}
