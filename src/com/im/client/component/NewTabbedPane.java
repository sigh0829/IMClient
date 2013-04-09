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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

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

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setBounds(300, 300, 800, 600);

		JTabbedPane main_tab = new JTabbedPane();
		main_tab.setUI(new NewTabbedPane());
		main_tab.addTab("Tab1", null, new JLabel("This is tab one."), "Tab #1");
		main_tab.addTab("Tab2", null, new JLabel("This is tab two."), "Tab #2");
		main_tab.addTab("Tab3", null, new JLabel("This is tab three."),
				"Tab #3");
		main_tab.addTab("", null, new JLabel("This is tab four."), "Tab #4");
		main_tab.addTab("Tab5", null, new JLabel("This is tab five."), "Tab #5");
		main_tab.setBounds(0, 125, 292, 216);

		f.add(main_tab);
		f.setVisible(true);
	}

	public static ComponentUI createUI(JComponent c) {
		return new NewTabbedPane();
	}

	public NewTabbedPane() {

		/*
		 * selectedColorSet = new ColorSet(); selectedColorSet.topGradColor1 =
		 * new Color(233, 237, 248); selectedColorSet.topGradColor2 = new
		 * Color(158, 199, 240);
		 * 
		 * selectedColorSet.bottomGradColor1 = new Color(112, 173, 239);
		 * selectedColorSet.bottomGradColor2 = new Color(183, 244, 253);
		 * 
		 * defaultColorSet = new ColorSet(); defaultColorSet.topGradColor1 = new
		 * Color(253, 253, 253); defaultColorSet.topGradColor2 = new Color(237,
		 * 237, 237);
		 * 
		 * defaultColorSet.bottomGradColor1 = new Color(222, 222, 222);
		 * defaultColorSet.bottomGradColor2 = new Color(255, 255, 255);
		 */

		defaultColorSet = new ColorSet();
		defaultColorSet.topGradColor1 = new Color(253, 253, 253, 90);
		defaultColorSet.topGradColor2 = new Color(237, 237, 237, 90);

		defaultColorSet.bottomGradColor1 = new Color(222, 222, 222, 90);
		defaultColorSet.bottomGradColor2 = new Color(255, 255, 255, 90);

		selectedColorSet = new ColorSet();
		selectedColorSet.topGradColor1 = new Color(255, 255, 255, 240);
		selectedColorSet.topGradColor2 = new Color(255, 255, 255, 240);

		selectedColorSet.bottomGradColor1 = new Color(255, 255, 255, 240);
		selectedColorSet.bottomGradColor2 = new Color(255, 255, 255, 240);

		hoverColorSet = new ColorSet();
		hoverColorSet.topGradColor1 = new Color(253, 253, 253, 130);
		hoverColorSet.topGradColor2 = new Color(237, 237, 237, 130);

		hoverColorSet.bottomGradColor1 = new Color(253, 253, 253, 130);
		hoverColorSet.bottomGradColor2 = new Color(237, 237, 237, 130);

		maxTabHeight = 31;

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
		return 31;
	}

	protected int calculateTabWidth(int tabPlacement, int tabIndex,
			FontMetrics metrics) {
		// int w = super.calculateTabWidth(tabPlacement, tabIndex, metrics);
		// int wid = metrics.charWidth('M');
		// w += wid * 2;
		return 57;
	}

	protected int calculateMaxTabHeight(int tabPlacement) {
		return 30;
	}

	// 绘制整个选项卡区域
	protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintTabArea(g, tabPlacement, selectedIndex);

		if (contentTopBorderDrawn) {
			g2d.setColor(lineColor);
			g2d.drawLine(0, 31, tabPane.getWidth() - 1, 31);
		}
	}

	// 绘制某个选项卡的背景色
	protected void paintTabBackground(Graphics g, int tabPlacement,
			int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		Graphics2D g2d = (Graphics2D) g;
		ColorSet colorSet;

		Rectangle rect = rects[tabIndex];

		if (isSelected) {
			colorSet = selectedColorSet;
		} else if (getRolloverTab() == tabIndex) {
			 colorSet = hoverColorSet;
		}
		else {
			colorSet = defaultColorSet;
		}

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

		g2d.setPaint(new GradientPaint(xpos, 0, colorSet.topGradColor1, xpos,
				h / 2, colorSet.topGradColor2));
		g2d.fill(this.getUpArea(xpos, yPos, width, h - 2));

		g2d.setPaint(new GradientPaint(0, h / 2, colorSet.bottomGradColor1, 0,
				h, colorSet.bottomGradColor2));
		g2d.fill(this.getDownArea(xpos, yPos, width, h - 2));

		if (contentTopBorderDrawn) {
			g2d.setColor(lineColor);
			g2d.drawLine(rect.x, 31, rect.x + rect.width - 1, 31);
		}
	}

	// 上半部分
	private Shape getUpArea(int x, int y, int w, int h) {
		Rectangle2D rec = new Rectangle2D.Float(x, y, w, h / 2 + 1);
		Area a = new Area(rec);
		RoundRectangle2D rect = new RoundRectangle2D.Float(x, y, w, h, 6.5f,
				6.5f);
		Area b = new Area(rect);
		a.intersect(b);
		return a;
	}

	// 下半部分
	private Shape getDownArea(int x, int y, int w, int h) {
		Rectangle2D rec = new Rectangle2D.Float(x, y + h / 2, w, h / 2 + 1);
		Area a = new Area(rec);
		return a;
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

	private class ColorSet {
		Color topGradColor1;
		Color topGradColor2;

		Color bottomGradColor1;
		Color bottomGradColor2;
	}

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
				Rectangle tabsRect = new Rectangle(0, 0, tabPane.getWidth(), 20);
				tabPane.repaint(tabsRect);
			}
		}
	}

}