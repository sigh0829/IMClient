package com.im.client.component;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.im.client.dto.IconTreeNode;

/**
 * CopyRright (c)2013: 			InstantMessage 
 * Project: 					InstantMessageClient Module ID: 1
 * Comments: 					重写DefaultTreeCellRenderer 
 * JDK version used: 			JDK 1.7 
 * NameSpace:					com.im.client.component 
 * Author： 						Ellery 
 * Create Date： 				2011-04-15 15:22 
 * Modified By： 
 * Modified Date: 
 * Why&What is modified: 
 * Version: 					0.1
 */

@SuppressWarnings("serial")
public class NewTreeIconNodeRenderer extends DefaultTreeCellRenderer {

	//字体
	private Font FONT_12_NOBOLD = new Font("微软雅黑", 0, 12);
	//从节点读取图片
	private Icon icon = null;
	//从节点读取文本
	private String text = "";
	
	// 重写该方法
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		// 调用父类的该方法
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		//从节点读取图片
		icon = ((IconTreeNode) value).getIcon();
		//从节点读取文本
		text = ((IconTreeNode) value).getText();
		//设置图片
		this.setIcon(icon);
		//设置文本
		this.setText(text);
		//设置字体
		this.setFont(FONT_12_NOBOLD);

		// 设置节点间的间距
		if (leaf) {
			this.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
			this.setOpaque(false);
		} else {
			this.setBorder(BorderFactory.createEmptyBorder(4, 0, 4, 0));
			this.setOpaque(false);
		}
		
		// 设置节点展开/关闭图标
		if (expanded && !leaf) {
			// 设置展开的节点的图标
			this.setIcon(new ImageIcon(
					"images/frame/main/friendlist/list_down.png"));
		} else if (!expanded && !leaf) {
			// 设置关闭的节点的图标
			this.setIcon(new ImageIcon(
					"images/frame/main/friendlist/list_right.png"));
		}

		// DefaultTreeCellRenderer默认返回的是一个JLabel
		return this;
	}
}
