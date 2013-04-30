package com.im.client.utils;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageServer                                          
* Module ID:			1    
* Comments:  			服务器字体工具类                                         
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.server.utils                         
* Author：				Ellery                 
* Create Date：			2011-04-27 22:05 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 

public class FontUtils {
	
	//统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体 
	public static void initGlobalFont(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys
				.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}
}
