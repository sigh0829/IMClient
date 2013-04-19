package com.im.client.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.im.client.utils.ImageManageUtils;
import com.im.client.utils.ScreenSizeUtils;
import com.sun.awt.AWTUtilities;

/** 
* CopyRright (c)2013:		InstantMessage                          
* Project:					InstantMessageClient                                          
* Module ID:				3    
* Comments:  				IM主界面                                           
* JDK version used:			JDK 1.7                              
* NameSpace:				com.im.client.ui                         
* Author：					Ellery                 
* Create Date：				2011-04-18 23:09
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:					0.1                       
*/ 

@SuppressWarnings("serial")
public class Chat extends JFrame{
	
	//窗口的宽度和窗口的高度
	private int windowWidth = 545;
	private int windowHeight = 515;
	
	//屏幕的宽度和屏幕的高度
	private int screenWidth = 0;
	private int screenHeight = 0;

	//登录界面背景图片
	private ImageIcon main_bg_Icon = ImageManageUtils.getImageIcon("images/background/main/main_bg_snail.jpg");
	//关闭按钮
	private ImageIcon btn_close_normalIcon = ImageManageUtils.getImageIcon("images/common/btn_close_normal.png");
	//关闭按钮高亮
	private ImageIcon btn_close_hoverIcon = ImageManageUtils.getImageIcon("images/common/btn_close_hover.png");
	//关闭按钮被点击
	private ImageIcon btn_close_pressIcon = ImageManageUtils.getImageIcon("images/common/btn_close_press.png");
	//最大化
	private ImageIcon btn_max_normalIcon = ImageManageUtils.getImageIcon("images/common/btn_max_normal.png");
	//最大化按钮高亮
	private ImageIcon btn_max_hoverIcon = ImageManageUtils.getImageIcon("images/common/btn_max_hover.png");
	//最大化按钮被点击
	private ImageIcon btn_max_pressIcon = ImageManageUtils.getImageIcon("images/common/btn_max_press.png");
	//最小化
	private ImageIcon btn_mini_normalIcon = ImageManageUtils.getImageIcon("images/common/btn_minimize_normal.png");
	//最小化按钮高亮
	private ImageIcon btn_mini_hoverIcon = ImageManageUtils.getImageIcon("images/common/btn_minimize_hover.png");
	//最小化按钮被点击
	private ImageIcon btn_mini_pressIcon = ImageManageUtils.getImageIcon("images/common/btn_minimize_press.png");
	//窗口设置
	private ImageIcon btn_frameset_normalIcon = ImageManageUtils.getImageIcon("images/common/btn_windowset_normal.png");
	//窗口设置按钮高亮
	private ImageIcon btn_frameset_hoverIcon = ImageManageUtils.getImageIcon("images/common/btn_windowset_highlight.png");
	//窗口设置按钮被点击
	private ImageIcon btn_frameset_pressIcon = ImageManageUtils.getImageIcon("images/common/btn_windowset_down.png");
	//头像边框高亮
	private ImageIcon user_image_border_highlightIcon = ImageManageUtils.getImageIcon("images/frame/chat/user_image/user_imgbg_hover.png");
	//头像边框
	private ImageIcon user_image_border_normalIcon = ImageManageUtils.getImageIcon("images/frame/chat/user_image/user_imgbg_normal.png");
	//用户头像
	private ImageIcon user_imageIcon = ImageManageUtils.getImageIcon("images/usericon/user_image/user_image.png");
	//menu按钮边框高亮图标
	private ImageIcon btn_icon_broder_highlightIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/allbtn_highlight.png");
	//menu按钮边框点击图标
	private ImageIcon btn_icon_broder_pressIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/allbtn_down.png");
	//空间
	private ImageIcon btn_qzoneIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/btn_qzone_icon.png");
	//微博
	private ImageIcon btn_wblogIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/btn_wblog_icon.png");
	
	//背景图片
    private JLabel main_bg = null;
    //关闭按钮
	private JButton btn_close = null;
	//最大化按钮
	private JButton btn_max = null;
	//最小化按钮
	private JButton btn_mini = null;
	//窗口设置按钮
	private JButton btn_frameset = null;
	//设置头像边框普通
	private JLabel user_img_normal_border = null; 
	//设置头像边框高亮
	private JLabel user_img_hightlight_border = null;
	//设置头像
	private JLabel user_image = null;
	//设置昵称
	private JLabel nickName = null;
	//设置qzone边框高亮
	private JLabel btn_qzone_border = null;
	//设置qq空间按钮
	private JButton btn_qzone = null;
	//设置wblog边框高亮
	private JLabel btn_wblog_border = null; 
	//设置微博按钮
	private JButton btn_wblog = null;
	//个性签名
	private	JLabel sign = null;

	//窗体是否完全不透明
	private boolean isWindowOpaque = true;
	
	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	//定义一个所有圆角都使用 double坐标指定的矩形
	private Shape shape = null;
	
	//颜色绿
	private Color GREEN = new Color(154,205,50);
	//字体
	private Font FONT_15_NOBOLD = new Font("微软雅黑", 0, 15);
	private Font FONT_12_NOBOLD = new Font("微软雅黑", 0, 12);
	
	public Chat(){
		//获取屏幕高度宽度
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
		
		//初始化界面
		initUI();
	}	
	
	public void initUI(){
		this.setTitle("IM2013");
		this.setLayout(null);
		//设置背景颜色
		this.setBackground(GREEN);

		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		//定义一个所有圆角都使用 double坐标指定的矩形
		shape = new RoundRectangle2D.Double(0, 0, 
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
        main_bg = new JLabel(){
			@Override
			protected void paintComponent(Graphics g) {
				// 图片随窗体大小而变化
                g.drawImage(main_bg_Icon.getImage(), 0, 0, Chat.this);
			}
        };
        
        //设置关闭按钮
		btn_close = new JButton();
		btn_close.setBounds((windowWidth-30), 0, 30, 20);
		btn_close.setIcon(btn_close_normalIcon);
		btn_close.setRolloverIcon(btn_close_hoverIcon);
		btn_close.setPressedIcon(btn_close_pressIcon);
		btn_close.setBorderPainted(false);
		btn_close.setContentAreaFilled(false);
		btn_close.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		          System.exit(0);
		      }
		  });
		
		//设置最大化按钮
		btn_max = new JButton();
		btn_max.setBounds((windowWidth-30-28), 0, 28, 20);
		btn_max.setIcon(btn_max_normalIcon);
		btn_max.setRolloverIcon(btn_max_hoverIcon);
		btn_max.setPressedIcon(btn_max_pressIcon);
		btn_max.setBorderPainted(false);
		btn_max.setContentAreaFilled(false);
		btn_max.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chat.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		//设置最小化按钮
		btn_mini = new JButton();
		btn_mini.setBounds((windowWidth-30-28-30), 0, 30, 20);
		btn_mini.setIcon(btn_mini_normalIcon);
		btn_mini.setRolloverIcon(btn_mini_hoverIcon);
		btn_mini.setPressedIcon(btn_mini_pressIcon);
		btn_mini.setBorderPainted(false);
		btn_mini.setContentAreaFilled(false);
		btn_mini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chat.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		//窗口设置按钮
		btn_frameset = new JButton();
		btn_frameset.setBounds((windowWidth-30-28-30-28), 0, 28, 20);
		btn_frameset.setIcon(btn_frameset_normalIcon);
		btn_frameset.setRolloverIcon(btn_frameset_hoverIcon);
		btn_frameset.setPressedIcon(btn_frameset_pressIcon);
		btn_frameset.setBorderPainted(false);
		btn_frameset.setContentAreaFilled(false);
		btn_frameset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
        
		//设置头像边框普通
		user_img_normal_border = new JLabel(user_image_border_normalIcon);
		user_img_normal_border.setBorder(null);
		user_img_normal_border.setBounds(7, 12, 42, 42);
		user_img_normal_border.setVisible(true);
		
		//设置头像边框高亮
		user_img_hightlight_border = new JLabel(user_image_border_highlightIcon);
		user_img_hightlight_border.setBorder(null);
		user_img_hightlight_border.setBounds(7, 12, 42, 42);
		user_img_hightlight_border.setVisible(false);
		
		//设置头像
		user_image = new JLabel(user_imageIcon);
		user_image.setBounds(9,14,38,38);
		user_image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				user_img_hightlight_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				user_img_hightlight_border.setVisible(true);
			}
		});

		//设置昵称
		nickName = new JLabel("飞翔de企鹅");
		nickName.setFont(FONT_15_NOBOLD);
		nickName.setBounds(60, 14, 200, 17);
		nickName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nickName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				nickName.setText("飞翔de企鹅");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				nickName.setText("<html><u>飞翔de企鹅</u></html>");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		//设置qzone边框高亮
		btn_qzone_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_qzone_border.setBorder(null);
		btn_qzone_border.setBounds(60, 32, 22, 22);
		btn_qzone_border.setVisible(false);
		
		//设置空间按钮
		btn_qzone = new JButton();
		btn_qzone.setBounds(63, 35, 16, 16);
		btn_qzone.setIcon(btn_qzoneIcon);
		btn_qzone.setBorderPainted(false);
		btn_qzone.setContentAreaFilled(false);
		btn_qzone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				btn_qzone_border.setIcon(btn_icon_broder_highlightIcon);
				btn_qzone_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				btn_qzone_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_qzone_border.setIcon(btn_icon_broder_pressIcon);
			}
		});

		//设置wblog边框高亮
		btn_wblog_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_wblog_border.setBorder(null);
		btn_wblog_border.setBounds(82, 32, 22, 22);
		btn_wblog_border.setVisible(false);

		//设置微博按钮
		btn_wblog = new JButton();
		btn_wblog.setBounds(85, 35, 16, 16);
		btn_wblog.setIcon(btn_wblogIcon);
		btn_wblog.setBorderPainted(false);
		btn_wblog.setContentAreaFilled(false);
		btn_wblog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				btn_wblog_border.setIcon(btn_icon_broder_highlightIcon);
				btn_wblog_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				btn_wblog_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_wblog_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//个性签名
		sign = new JLabel("请编辑个性签名...请编辑个性签名...请编辑个性签名...请编辑个性签名...");
		sign.setFont(FONT_12_NOBOLD);
		sign.setBounds(105, 31, 250, 25);
		
		//添加组件
		this.setContentPane(main_bg);
		this.add(btn_close);
		this.add(btn_max);
		this.add(btn_mini);
		this.add(btn_frameset);
		this.add(user_img_hightlight_border);
		this.add(user_img_normal_border);
		this.add(user_image);
		this.add(nickName);
		this.add(btn_qzone_border);
		this.add(btn_qzone);
		this.add(btn_wblog_border);
		this.add(btn_wblog);
		this.add(sign);
	}
	
	public static void main(String[] args) {
		new Chat().setVisible(true);
	}

}
