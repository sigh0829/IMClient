package com.im.client.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			2   
* Comments:  			IM主界面选项卡                                        
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.component                         
* Author：				Ellery                 
* Create Date：			2013-04-10 21:50 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/

public class NewTabbedPane extends BasicTabbedPaneUI {

	private static final Insets NO_INSETS = new Insets(0, 0, 0, 0);
	private ColorSet selectedColorSet;
	private ColorSet defaultColorSet;
	private ColorSet hoverColorSet;
	private boolean contentTopBorderDrawn = true;
	private Color lineColor = new Color(255, 255, 255);
	private Color dividerColor = new Color(200, 200, 200);
	private Insets contentInsets = new Insets(1, 1, 1, 1);
	private int lastRollOverTab = -1;

	public static ComponentUI createUI(JComponent c) {
		return new NewTabbedPane();
	}

	public NewTabbedPane() {

		//默认未选中时背景颜色
		defaultColorSet = new ColorSet();
		defaultColorSet.topGradColor1 = new Color(255, 255, 255, 90);
		defaultColorSet.topGradColor2 = new Color(255, 255, 255, 90);
		defaultColorSet.bottomGradColor1 = new Color(255, 255, 255, 90);
		defaultColorSet.bottomGradColor2 = new Color(255, 255, 255, 90);

		//选中时选项卡背景颜色
		selectedColorSet = new ColorSet();
		selectedColorSet.topGradColor1 = new Color(255, 255, 255);
		selectedColorSet.topGradColor2 = new Color(255, 255, 255);
		selectedColorSet.bottomGradColor1 = new Color(255, 255, 255);
		selectedColorSet.bottomGradColor2 = new Color(255, 255, 255);

		//选项卡高亮时背景颜色
		hoverColorSet = new ColorSet();
		hoverColorSet.topGradColor1 = new Color(255, 255, 255, 130);
		hoverColorSet.topGradColor2 = new Color(255, 255, 255, 130);
		hoverColorSet.bottomGradColor1 = new Color(255, 255, 255, 130);
		hoverColorSet.bottomGradColor2 = new Color(255, 255, 255, 130);

		//每个选项卡最大高度
		maxTabHeight = 33;

		//设置组件间间距
		setContentInsets(1);
	}

	public void setContentTopBorderDrawn(boolean b) {
		contentTopBorderDrawn = b;
	}

	public void setContentInsets(Insets i) {
		contentInsets = i;
	}

	public void setContentInsets(int i) {
		contentInsets = new Insets(i, i, i, i);
	}

	// 返回当前运行的用于显示选项卡的选项卡数
	public int getTabRunCount(JTabbedPane pane) {
		return 1;
	}

	// 可以改变一些BasicTabbedPaneUI中默认的属性
	protected void installDefaults() {
		super.installDefaults();

		RollOverListener l = new RollOverListener();
		tabPane.addMouseListener(l);
		tabPane.addMouseMotionListener(l);

		tabAreaInsets = NO_INSETS; // tab色insets边框
		tabInsets = new Insets(0, 0, 50, 50);
	}

	protected boolean scrollableTabLayoutEnabled() {
		return false;
	}

	protected Insets getContentBorderInsets(int tabPlacement) {
		return contentInsets;
	}

	protected int calculateTabHeight(int tabPlacement, int tabIndex,
			int fontHeight) {
		return 33;
	}

	//每个选项卡高度
	protected int calculateTabWidth(int tabPlacement, int tabIndex,
			FontMetrics metrics) {
		return 57;
	}

	protected int calculateMaxTabHeight(int tabPlacement) {
		return 32;
	}

	// 绘制整个选项卡区域
	protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintTabArea(g, tabPlacement, selectedIndex);

		if (contentTopBorderDrawn) {
			g2d.setColor(lineColor);
			g2d.drawLine(0, 32, tabPane.getWidth() - 1, 32);
		}
	}

	// 绘制某个选项卡的背景色
	protected void paintTabBackground(Graphics g, int tabPlacement,
			int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		Graphics2D g2d = (Graphics2D) g;
		ColorSet colorSet;

		//Rectangle 指定坐标空间中的一个区域，通过坐标空间中 Rectangle 对象左上方的点 (x,y)、宽度和高度可以定义这个区域。 
		Rectangle rect = rects[tabIndex];

		if(isSelected) {
			colorSet = selectedColorSet;
		}else if(getRolloverTab() == tabIndex) {
			//返回当前有鼠标位于其上方的选项卡；如果鼠标不再位于任何选项卡上，则返回 -1。
			colorSet = hoverColorSet;
		}else {
			colorSet = defaultColorSet;
		}

		//为呈现算法设置单个首选项的值。提示类别包括对呈现过程中的呈现质量和总时间/质量折衷的控制。
		//参数：抗锯齿提示键
		//	      抗锯齿提示值——使用抗锯齿模式完成呈现。
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		int width = rect.width;
		int xpos = rect.x;
		int yPos = rect.y;
		if (tabIndex > -1) {
			width--;
			xpos++;
			yPos += 2;
		}

		//setPaint - 为 Graphics2D 上下文设置 Paint 属性。使用为 null 的 Paint 对象调用此方法对此 Graphics2D 的当前 Paint 属性没有任何影响。 
		//paint - 呈现过程中用于生成颜色的 Paint 对象
		//GradientPaint - 类提供了使用线性颜色渐变模式填充 Shape 的方法。
		//GradientPaint(float x1,float y1,Color color1,float x2,float y2,Color color2) - 构造一个简单的非周期性 GradientPaint 对象。
		//参数：
		//	x1 - 用户空间中第一个指定 Point 的 x 坐标
		//	y1 - 用户空间中第一个指定 Point 的 y 坐标
		//	color1 - 第一个指定 Point 处的 Color
		//	x2 - 用户空间中第二个指定 Point 的 x 坐标
		//	y2 - 用户空间中第二个指定 Point 的 y 坐标
		//	color2 - 第二个指定 Point 处的 Color 
		//g2d.setPaint(new GradientPaint(xpos, 0, colorSet.topGradColor1, xpos, h / 2, colorSet.topGradColor2));
		g2d.setPaint(new GradientPaint(xpos, 0, colorSet.topGradColor1, xpos, h/2, colorSet.topGradColor2));
		//使用 Graphics2D 上下文的设置，填充 Shape 的内部区域。
		g2d.fill(this.getUpArea(xpos, yPos, width, h - 2));

		//g2d.setPaint(new GradientPaint(0, h / 2, colorSet.bottomGradColor1, 0, h, colorSet.bottomGradColor2));
		g2d.setPaint(new GradientPaint(0, h/2, colorSet.bottomGradColor1, 0, h, colorSet.bottomGradColor2));
		g2d.fill(this.getDownArea(xpos, yPos, width, h - 2));

		if (contentTopBorderDrawn) {
			g2d.setColor(lineColor);
			g2d.drawLine(rect.x, 32, rect.x + rect.width - 1, 32);
		}
	}
	
	// 上半部分
	//Shape 接口提供了表示一些几何形状的对象的定义，public class Area extends Object implements Shape, Cloneable
	private Shape getUpArea(int x, int y, int w, int h) {
		//Rectangle2D 类描述通过位置 (x,y) 和尺寸 (w * h) 定义的矩形。 
		Rectangle2D rec = new Rectangle2D.Float(x, y, w, h / 2 );
		Area a = new Area(rec);
		//RoundRectangle2D 类定义一个矩形，该矩形具有由位置 (x,y)、维度 (w x h) 以及圆角弧的宽度和高度定义的圆角。
		RoundRectangle2D rect = new RoundRectangle2D.Float(x, y, w, h, 6.5f, 6.5f);
		Area b = new Area(rect);
		//intersect(Area rhs)-将此 Area 的形状设置为其当前形状与指定 Area 形状的交集。得到的 Area形状将仅包括那些既包含在此 Area中也包含在指定 Area中的区域。 
		a.intersect(b);
		return a;
	}

	// 下半部分
	private Shape getDownArea(int x, int y, int w, int h) {
		Rectangle2D rec = new Rectangle2D.Float(x, y + h / 2, w, h / 2+1 );
		Area c = new Area(rec);
		return c;
	}

	// 绘制TabbedPane容器的四周边框样式
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex,
			int x, int y, int w, int h, boolean isSelected) {
		Rectangle rect = getTabBounds(tabIndex, new Rectangle(x, y, w, h));
		Graphics2D g2 = (Graphics2D) g;
		Composite old = g2.getComposite();
		AlphaComposite comp = AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, 0.0f);
		g2.setComposite(comp);
		g2.setColor(dividerColor);
		g2.drawLine(rect.x + rect.width, 0, (rect.x + rect.width) / 2, 31);
		g2.setComposite(old);
	}

	protected void paintContentBorderTopEdge(Graphics g, int tabPlacement,
			int selectedIndex, int x, int y, int w, int h) {
	}

	protected void paintContentBorderRightEdge(Graphics g, int tabPlacement,
			int selectedIndex, int x, int y, int w, int h) {
	}

	protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement,
			int selectedIndex, int x, int y, int w, int h) {
	}

	protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement,
			int selectedIndex, int x, int y, int w, int h) {
	}

	// 绘制选中某个Tab后，获得焦点的样式
	protected void paintFocusIndicator(Graphics g, int tabPlacement,
			Rectangle[] rects, int tabIndex, Rectangle iconRect,
			Rectangle textRect, boolean isSelected) {
	}

	protected int getTabLabelShiftY(int tabPlacement, int tabIndex,
			boolean isSelected) {
		return 0;
	}

	//设置颜色集
	private class ColorSet {
		Color topGradColor1;
		Color topGradColor2;

		Color bottomGradColor1;
		Color bottomGradColor2;
	}

	//设置选项卡鼠标监听器
	private class RollOverListener implements MouseMotionListener,
			MouseListener {

		public void mouseDragged(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
			checkRollOver();
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			checkRollOver();
		}

		public void mouseExited(MouseEvent e) {
			tabPane.repaint();
		}

		private void checkRollOver() {
			int currentRollOver = getRolloverTab();
			if (currentRollOver != lastRollOverTab) {
				lastRollOverTab = currentRollOver;
				Rectangle tabsRect = new Rectangle(0, 0, tabPane.getWidth(), 31);
				tabPane.repaint(tabsRect);
			}
		}
	}

}