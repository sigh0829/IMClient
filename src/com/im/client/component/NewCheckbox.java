package com.im.client.component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			重写JCheckBox                                          
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.component                       
* Author：				Ellery                 
* Create Date：			2011-03-19 11:35 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/
@SuppressWarnings("serial")
public class NewCheckbox extends JCheckBox{

	public NewCheckbox(String string) {
		super(string);
	}

	@Override
	public Icon getIcon() {
		//复选框未被选中时的样式
		return new ImageIcon("images/login/btn_checkbox_normal.png");
	}

	@Override
	public Icon getPressedIcon() {
		//复选框被点击时图片样式
		return new ImageIcon("images/login/btn_checkbox_press.png");
	}


	@Override
	public Icon getRolloverIcon() {
		//复选框未被选中时高亮
		return new ImageIcon("images/login/btn_checkbox_hover.png");
	}

	@Override
	public Icon getRolloverSelectedIcon() {
		//复选框被选中后高亮
		return new ImageIcon("images/login/btn_checkbox_selected_hover.png");
	}

	@Override
	public Icon getSelectedIcon() {
		//复选框被选中正常样式
		return new ImageIcon("images/login/btn_checkbox_selected_normal.png");
	}
	
}
