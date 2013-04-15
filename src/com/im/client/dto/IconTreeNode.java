package com.im.client.dto;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;
/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			重写DefaultMutableTreeNode                                          
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.component                         
* Author：				Ellery                 
* Create Date：			2011-04-15 15:16 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/
@SuppressWarnings("serial")
public class IconTreeNode extends DefaultMutableTreeNode {

	//节点图标
	protected Icon icon;
	//节点文字
	protected String text;

	// 只包含文本的节点构造
	public IconTreeNode(String text) {
		super();
		this.text = text;
	}

	// 包含文本和图片的节点构造
	public IconTreeNode(Icon icon, String text) {
		super();
		this.icon = icon;
		this.text = text;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
