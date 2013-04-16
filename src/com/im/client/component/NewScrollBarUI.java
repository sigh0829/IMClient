package com.im.client.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

import com.im.client.utils.ImageManageUtils;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			ScrollBarUI                                        
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.component                         
* Author：				Ellery                 
* Create Date：			2011-04-15 20:50 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/

public class NewScrollBarUI extends BasicScrollBarUI {

	// scrollbar向下箭头
	private ImageIcon scrollbar_arrowdown_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/scrollbar/scrollbar_arrowdown_normal.png");
	// scrollbar向下箭头高亮
	private ImageIcon scrollbar_arrowdown_highlightIcon = ImageManageUtils.getImageIcon("images/frame/main/scrollbar/scrollbar_arrowdown_highlight.png");
	// scrollbar向下箭头点击
	private ImageIcon scrollbar_arrowdown_downIcon = ImageManageUtils.getImageIcon("images/frame/main/scrollbar/scrollbar_arrowdown_down.png");
	// scrollbar向上箭头
	private ImageIcon scrollbar_arrowup_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/scrollbar/scrollbar_arrowup_normal.png");
	// scrollbar向上箭头高亮
	private ImageIcon scrollbar_arrowup_highlightIcon = ImageManageUtils.getImageIcon("images/frame/main/scrollbar/scrollbar_arrowup_highlight.png");
	// scrollbar向上箭头点击
	private ImageIcon scrollbar_arrowup_downIcon = ImageManageUtils.getImageIcon("images/frame/main/scrollbar/scrollbar_arrowup_down.png");

	// 向下箭头按钮
	private JButton arrowdown = null;
	// 向上箭头按钮
	private JButton arrwoup = null;
	//滑块边框颜色
	private Color thumbBorderColor = new Color(164, 164, 164);  

	//设置滑块bounds
	@Override
	protected void setThumbBounds(int x, int y, int width, int height) {
		super.setThumbBounds(x+width/4, y, width/2, height);
	}

	// 重绘滚动条的滑块
	public void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		super.paintThumb(g, c, thumbBounds);
		int tw = thumbBounds.width;
		int th = thumbBounds.height;
		// 重定图形上下文的原点，这句一定要写，不然会出现拖动滑块时滑块不动的现象
		g.translate(thumbBounds.x, thumbBounds.y);

		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gp = null;
		if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			gp = new GradientPaint(0, 0, new Color(204, 204, 204), tw, 0,
					new Color(204, 204, 204));
		}
		if (this.scrollbar.getOrientation() == JScrollBar.HORIZONTAL) {
			gp = new GradientPaint(0, 0, new Color(204, 204, 204), 0, th,
					new Color(204, 204, 204));
		}
		g2.setPaint(gp);
		g2.fillRoundRect(0, 0, (tw - 1), (th - 1), 5, 5);
		//边框颜色
		g2.setColor(thumbBorderColor);
		g2.drawRoundRect(0, 0, (tw - 1), (th - 1), 5, 5);
	}

	// 重绘滑块的滑动区域背景
	public void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gp = null;
		if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			gp = new GradientPaint(0, 0, new Color(229, 229, 229),
					trackBounds.width/2, 0, new Color(229, 229, 229));
		}
		if (this.scrollbar.getOrientation() == JScrollBar.HORIZONTAL) {
			gp = new GradientPaint(0, 0, new Color(229, 229, 229), 0,
					trackBounds.height/2, new Color(229, 229, 229));
		}
		g2.setPaint(gp);
		g2.fillRect(trackBounds.x+trackBounds.width/4, trackBounds.y, trackBounds.width/2,
				trackBounds.height);
		//边框颜色
		//g2.setColor(new Color(175, 155, 95));
		g2.drawRect(trackBounds.x+trackBounds.width/4, trackBounds.y, (trackBounds.width - 1)/2,
				(trackBounds.height - 1));
		if (trackHighlight == BasicScrollBarUI.DECREASE_HIGHLIGHT)
			this.paintDecreaseHighlight(g);
		if (trackHighlight == BasicScrollBarUI.INCREASE_HIGHLIGHT)
			this.paintIncreaseHighlight(g);
	}
	
	//设置向上箭头
	@Override
	protected JButton createDecreaseButton(int orientation) {

		arrwoup = new JButton();
		arrwoup.setIcon(scrollbar_arrowup_normalIcon);
		arrwoup.setRolloverIcon(scrollbar_arrowup_highlightIcon);
		arrwoup.setPressedIcon(scrollbar_arrowup_downIcon);
		arrwoup.setBorderPainted(false);
		arrwoup.setContentAreaFilled(false);

		return arrwoup;
	}

	//设置向下箭头
	@Override
	protected JButton createIncreaseButton(int orientation) {

		arrowdown = new JButton();
		arrowdown.setIcon(scrollbar_arrowdown_normalIcon);
		arrowdown.setRolloverIcon(scrollbar_arrowdown_highlightIcon);
		arrowdown.setPressedIcon(scrollbar_arrowdown_downIcon);
		arrowdown.setBorderPainted(false);
		arrowdown.setContentAreaFilled(false);

		return arrowdown;
	}

}
