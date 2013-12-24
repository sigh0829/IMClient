package com.im.client.utils;

import java.awt.Toolkit;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			2    
* Comments:  			获取屏幕高度宽度工具类                                          
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.utils                         
* Author：				Ellery                 
* Create Date：			2013-03-16 15:05 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 

public class ScreenSizeUtils {
	
	//屏幕的宽度和屏幕的高度
	private int screenWidth = 0;
	private int screenHeight = 0;
	
	/*
	 * 此类是所有 Abstract Window Toolkit 实际实现的抽象超类。
	 * Toolkit 的子类被用于将各种组件绑定到特定本机工具包实现。
	 * 大多数应用程序不应直接调用该类中的任何方法。
	 * Toolkit 定义的方法是一种“胶水”，将 java.awt 包中与平台无关的类与java.awt.peer 中的对应物连接起来。
	 * Toolkit 定义的一些方法能直接查询本机操作系统。
	 */
	private Toolkit tool = null;
	
	public ScreenSizeUtils(){
		//获取默认工具包
		tool =  Toolkit.getDefaultToolkit();
	}
	
	//返回屏幕的宽度
	public int getScreenWidth(){
		screenWidth = this.tool.getScreenSize().width;
		return screenWidth;
	}
	
	//返回屏幕的高度
	public int getScreenHeight(){
		screenHeight = tool.getScreenSize().height;
		return screenHeight;
	}
}
