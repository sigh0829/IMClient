package com.im.client.component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			重写JButton                                          
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.component                         
* Author：				Ellery                 
* Create Date：			2011-03-19 15:22 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/
@SuppressWarnings("serial")
public class NewButton extends JButton{

	public NewButton(String text) {
		super(text);
	}

	@Override
	public Icon getIcon() {
		//普通按钮样式
		return new ImageIcon("images/frame/login/button_normal.png");
	}

	@Override
	public Icon getPressedIcon() {
		//按钮被点击时样式
		return new ImageIcon("images/frame/login/button_press.png");
	}

	@Override
	public Icon getRolloverIcon() {
		//按钮高亮样式
		return new ImageIcon("images/frame/login/button_hover.png");
	}
}
