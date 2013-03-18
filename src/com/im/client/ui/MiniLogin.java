package com.im.client.ui;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.im.client.component.NewPasswordField;
import com.im.client.component.NewTextField;
import com.im.client.utils.ImageManageUtils;
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
	private ImageIcon loginbgIcon = ImageManageUtils.getImageIcon("images/background/login/login_bg_noon.jpg");
	//关闭按钮
	private ImageIcon btn_close_normalIcon = ImageManageUtils.getImageIcon("images/common/btn_close_normal.png");
	//关闭按钮高亮
	private ImageIcon btn_close_hoverIcon = ImageManageUtils.getImageIcon("images/common/btn_close_hover.png");
	//关闭按钮被点击
	private ImageIcon btn_close_pressIcon = ImageManageUtils.getImageIcon("images/common/btn_close_press.png");
	//最小化
	private ImageIcon btn_mini_normalIcon = ImageManageUtils.getImageIcon("images/common/btn_minimize_normal.png");
	//最小化按钮高亮
	private ImageIcon btn_mini_hoverIcon = ImageManageUtils.getImageIcon("images/common/btn_minimize_hover.png");
	//最小化按钮被点击
	private ImageIcon btn_mini_pressIcon = ImageManageUtils.getImageIcon("images/common/btn_minimize_press.png");
	//用户头像
	private ImageIcon user_imageIcon = ImageManageUtils.getImageIcon("images/usericon/user_image.png");
	private ImageIcon user_image_bg_normalIcon = ImageManageUtils.getImageIcon("images/usericon/user_imgbg_normal.png");
	private ImageIcon user_image_bg_hoverIcon = ImageManageUtils.getImageIcon("images/usericon/user_imgbg_hover.png");
	//密码框中的键盘
	private ImageIcon pwd_keyboard_Icon = ImageManageUtils.getImageIcon("images/login/btn_loginpwd_keyboard.png");
	//输入框边框
	private ImageIcon textfield_borderIcon = ImageManageUtils.getImageIcon("images/login/textfield_border.png");
	//帐号前面的企鹅
	private ImageIcon avatarIcon = ImageManageUtils.getImageIcon("images/login/btn_penguin_avatar.png");
	//注册新用户按钮
	private ImageIcon btn_register_normalIcon = ImageManageUtils.getImageIcon("images/login/btn_register_normal.png");
	//注册新用户按钮高亮
	private ImageIcon btn_register_hoverIcon = ImageManageUtils.getImageIcon("images/login/btn_register_hover.png");
	//注册新用户按钮点击
	private ImageIcon btn_register_pressIcon = ImageManageUtils.getImageIcon("images/login/btn_register_press.png");
	//注册新用户按钮
	private ImageIcon btn_forgetPwd_normalIcon = ImageManageUtils.getImageIcon("images/login/btn_forgetPwd_normal.png");
	//注册新用户按钮高亮
	private ImageIcon btn_forgetPwd_hoverIcon = ImageManageUtils.getImageIcon("images/login/btn_forgetPwd_hover.png");
	//注册新用户按钮点击
	private ImageIcon btn_forgetPwd_pressIcon = ImageManageUtils.getImageIcon("images/login/btn_forgetPwd_press.png");
	//系统托盘图标
	private ImageIcon sys_tray_logoIcon = ImageManageUtils.getImageIcon("images/common/sysTrayIcon.png");
	//系统任务栏图标
	private ImageIcon taskbar_logoIcon = ImageManageUtils.getImageIcon("images/common/taskBarIcon.png");
	
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

		this.setIconImage(taskbar_logoIcon.getImage());
		
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
		
		//判断系统是否托盘
		if(SystemTray.isSupported()){  
		    //创建一个托盘图标对象  
		    TrayIcon icon = new TrayIcon(sys_tray_logoIcon.getImage());  
		    //创建弹出菜单  
		    PopupMenu menu = new PopupMenu();  
		    //添加一个用于退出的按钮  
		    MenuItem item = new MenuItem("Exit");  
		    item.addActionListener(new ActionListener() {  
		        public void actionPerformed(ActionEvent e) {  
		            System.exit(0);  
		        }  
		    });  
		    menu.add(item);  
		    //添加弹出菜单到托盘图标  
		    icon.setPopupMenu(menu);  
		    SystemTray tray = SystemTray.getSystemTray();//获取系统托盘  
		    try {
				tray.add(icon);//将托盘图表添加到系统托盘  
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
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
		
		//设置头像
		//头像边框
		JLabel user_image_normalbg = new JLabel(user_image_bg_normalIcon);
		user_image_normalbg.setBounds(20, 140, 84, 84);
		//头像图片
		JLabel user_image = new JLabel(user_imageIcon);
		user_image.setBounds(22, 142, 80, 80);
		//头像边框高亮
		final JLabel user_image_hoverbg = new JLabel(user_image_bg_hoverIcon);
		user_image_hoverbg.setBounds(20, 140, 84, 84);
		user_image_hoverbg.setVisible(false);
		user_image.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("ddddddddddddd");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				user_image_hoverbg.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				user_image_hoverbg.setVisible(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		//设置账户输入框的边框
		final JLabel user_textfield_border = new JLabel(textfield_borderIcon);
		user_textfield_border.setBorder(null);
		user_textfield_border.setBounds(110, 141, 192, 26);
		user_textfield_border.setVisible(false);

		//设置帐号输入框
		final NewTextField user_field = new NewTextField(avatarIcon);
		user_field.setBorder(null);
		user_field.setBounds(111, 142, 190, 24);
		user_field.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("ddddddddddddd");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				user_textfield_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				user_textfield_border.setVisible(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		//密码框边框
		final JLabel pass_textfield_border = new JLabel(textfield_borderIcon);
		pass_textfield_border.setBorder(null);
		pass_textfield_border.setBounds(110, 171, 192, 26);
		pass_textfield_border.setVisible(false);
		
		//密码框
		final NewPasswordField pass_field = new NewPasswordField(pwd_keyboard_Icon);
		pass_field.setBorder(null);
		pass_field.setBounds(111, 172, 190, 24);
		pass_field.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("ddddddddddddd");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				pass_textfield_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				pass_textfield_border.setVisible(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

		//设置注册新用户按钮
		JButton btn_register = new JButton();
		btn_register.setBounds(310, 148, 51, 16);
		btn_register.setIcon(btn_register_normalIcon);
		btn_register.setRolloverIcon(btn_register_hoverIcon);
		btn_register.setPressedIcon(btn_register_pressIcon);
		btn_register.setBorderPainted(false);
		btn_register.setContentAreaFilled(false);
		
		//设置注册新用户按钮
		JButton btn_forget_password = new JButton();
		btn_forget_password.setBounds(310, 179, 51, 16);
		btn_forget_password.setIcon(btn_forgetPwd_normalIcon);
		btn_forget_password.setRolloverIcon(btn_forgetPwd_hoverIcon);
		btn_forget_password.setPressedIcon(btn_forgetPwd_pressIcon);
		btn_forget_password.setBorderPainted(false);
		btn_forget_password.setContentAreaFilled(false);
		
		//添加界面组件
		this.setContentPane(loginbg);
		this.add(btn_close);
		this.add(btn_mini);
		this.add(user_image_normalbg);
		this.add(user_image_hoverbg);
		this.add(user_image);
		this.add(user_textfield_border);
		this.add(user_field);
		this.add(pass_textfield_border);
		this.add(pass_field);
		this.add(btn_register);
		this.add(btn_forget_password);
		
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
