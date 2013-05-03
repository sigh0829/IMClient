package com.im.common.dto;

import javax.swing.ImageIcon;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			天气getter setter                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.dto                         
* Author：				Ellery                 
* Create Date：			2011-04-03 23:29 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 
public class Weather {

	//天气图标
	private ImageIcon weatherImageIcon = null;
	
	//天气名称
	private String weatherName = null;

	public ImageIcon getWeatherImageIcon() {
		return weatherImageIcon;
	}

	public void setWeatherImageIcon(ImageIcon weatherImageIcon) {
		this.weatherImageIcon = weatherImageIcon;
	}

	public String getWeatherName() {
		return weatherName;
	}

	public void setWeatherName(String weatherName) {
		this.weatherName = weatherName;
	}
	
}
