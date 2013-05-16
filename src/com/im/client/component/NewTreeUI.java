package com.im.client.component;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTreeUI;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			2   
* Comments:  			重写BasicTreeUI                                          
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.component                         
* Author：				Ellery                 
* Create Date：			2013-04-15 15:12 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/

public class NewTreeUI extends BasicTreeUI{

	//重写以下两个方法用于去掉节点缩进直线
	@Override
	protected void paintVerticalLine(Graphics g, JComponent c, int x, int top, int bottom) {
		
	}

	@Override
	protected void paintHorizontalLine(Graphics g, JComponent c, int y, int left, int right) {
		
	}

	//重写以下两个方法用于设置父节点与子节点之间的缩进大小
	@Override
	public void setLeftChildIndent(int newAmount) {
		super.setLeftChildIndent(10);
	}

	@Override
	public void setRightChildIndent(int newAmount) {
		//super.setRightChildIndent(newAmount);
	}

}
