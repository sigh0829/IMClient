package com.im.client.ui;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.im.client.utils.GetImageUtils;
import com.im.client.utils.ScreenSizeUtils;
import com.sun.awt.AWTUtilities;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			Mini版用户登陆界面                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.ui                         
* Author：				Ellery                 
* Create Date：			2011-03-16 14:23 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 
@SuppressWarnings("serial")
public class MiniLogin extends JFrame{

	//窗口的宽度和窗口的高度
	private int windowWidth = 380;
	private int windowHeight = 292;
	
	//屏幕的宽度和屏幕的高度
	private int screenWidth = 0;
	private int screenHeight = 0;
	
	//窗体是否完全不透明
	private boolean isWindowOpaque = true;
	
	//登录界面背景图片
	private ImageIcon loginbgIcon = GetImageUtils.getImageIcon("images/background/login/login_bg_noon.jpg");
	//关闭按钮
	private ImageIcon btn_close_normalIcon = GetImageUtils.getImageIcon("images/common/btn_close_normal.png");
	//关闭按钮高亮
	private ImageIcon btn_close_hoverIcon = GetImageUtils.getImageIcon("images/common/btn_close_hover.png");
	//关闭按钮被点击
	private ImageIcon btn_close_pressIcon = GetImageUtils.getImageIcon("images/common/btn_close_press.png");
	//最小化
	private ImageIcon btn_mini_normalIcon = GetImageUtils.getImageIcon("images/common/btn_minimize_normal.png");
	//最小化按钮高亮
	private ImageIcon btn_mini_hoverIcon = GetImageUtils.getImageIcon("images/common/btn_minimize_hover.png");
	//最小化按钮被点击
	private ImageIcon btn_mini_pressIcon = GetImageUtils.getImageIcon("images/common/btn_minimize_press.png");
	
	public MiniLogin(){
		//获取屏幕高度宽度
		ScreenSizeUtils screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
		
		//初始化界面
		initUI();
	}
	
	public void initUI(){
		this.setTitle("IM2013");
		this.setLayout(null);
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		
		//定义一个所有圆角都使用 double坐标指定的矩形
		Shape shape = new RoundRectangle2D.Double(0, 0, 
				windowWidth, windowHeight, 6.5D, 6.5D);  
		AWTUtilities.setWindowShape(this, shape); 
		
		//判断窗体是否透明
		if(isWindowOpaque){
			//设置窗体完全不透明
			AWTUtilities.setWindowOpaque(this, true);
		}else {
			//设置窗体透明度，取值范围从0到1，透明度逐渐减小
			AWTUtilities.setWindowOpacity(this, 0.8f);
		}
		
		//设置背景图片
		JLabel loginbg = new JLabel(loginbgIcon);  
		loginbg.setBounds(0, 0, windowWidth, windowHeight);
		
		//设置关闭按钮
		JButton btn_close = new JButton();
		btn_close.setBounds((windowWidth-30), 0, 30, 20);
		btn_close.setIcon(btn_close_normalIcon);
		btn_close.setRolloverIcon(btn_close_hoverIcon);
		btn_close.setPressedIcon(btn_close_pressIcon);
		btn_close.setBorderPainted(false);
		btn_close.setContentAreaFilled(false);
		
		//设置最小化按钮
		JButton btn_mini = new JButton();
		btn_mini.setBounds((windowWidth-30-30), 0, 30, 20);
		btn_mini.setIcon(btn_mini_normalIcon);
		btn_mini.setRolloverIcon(btn_mini_hoverIcon);
		btn_mini.setPressedIcon(btn_mini_pressIcon);
		btn_mini.setBorderPainted(false);
		btn_mini.setContentAreaFilled(false);
		
		//添加界面组件
		this.setContentPane(loginbg);
		this.add(btn_close);
		this.add(btn_mini);
		
		//添加界面拖拽移动监听器
		this.addMouseListener(moveWindowListener);
		this.addMouseMotionListener(moveWindowListener); 
	}
	
	//界面拖拽移动监听器内部类
	private MouseAdapter moveWindowListener = new MouseAdapter() {

        private Point lastPoint = null;

        @Override
        public void mousePressed(MouseEvent e) {
            lastPoint = e.getLocationOnScreen();
        }

        @Override
        public void mouseDragged(MouseEvent e){  
            Point point = e.getLocationOnScreen();
            int offsetX = point.x - lastPoint.x;
            int offsetY = point.y - lastPoint.y;
            Rectangle bounds = MiniLogin.this.getBounds();
            bounds.x += offsetX;
            bounds.y += offsetY;
            MiniLogin.this.setBounds(bounds);
            lastPoint = point;
        }
	};
	
	public static void main(String[] args) {
		new MiniLogin().setVisible(true);
	}

}
