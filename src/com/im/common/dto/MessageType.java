package com.im.common.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MessageType implements Serializable{

	private int messageTypeID = 0;
	
	private String messageTypeName = "";

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
	
	
}
