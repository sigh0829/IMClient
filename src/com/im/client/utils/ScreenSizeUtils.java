package com.im.client.utils;

import java.awt.Toolkit;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessage                                          
* Module ID:			3    
* Comments:  			��ȡ��Ļ�߶ȿ�ȹ�����                                          
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.utils                         
* Author��				Ellery                 
* Create Date��			2013-03-16 15:05 
* Modified By��			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 
public class ScreenSizeUtils {
	
	//��Ļ�Ŀ�Ⱥ���Ļ�ĸ߶�
	private int screenWidth = 0;
	private int screenHeight = 0;
	
	/*
	 * ���������� Abstract Window Toolkit ʵ��ʵ�ֵĳ����ࡣ
	 * Toolkit �����౻���ڽ���������󶨵��ض��������߰�ʵ�֡�
	 * �����Ӧ�ó���Ӧֱ�ӵ��ø����е��κη�����
	 * Toolkit ����ķ�����һ�֡���ˮ������ java.awt ������ƽ̨�޹ص�����java.awt.peer �еĶ�Ӧ������������
	 * Toolkit �����һЩ������ֱ�Ӳ�ѯ��������ϵͳ��
	 */
	private Toolkit tool = null;
	
	public ScreenSizeUtils(){
		//��ȡĬ�Ϲ��߰�
		tool =  Toolkit.getDefaultToolkit();
	}
	
	//������Ļ�Ŀ��
	public int getScreenWidth(){
		screenWidth = tool.getScreenSize().width;
		return screenWidth;
	}
	
	//������Ļ�ĸ߶�
	public int getScreenHeight(){
		screenHeight = tool.getScreenSize().height;
		return screenHeight;
	}
}
