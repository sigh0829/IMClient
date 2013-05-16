package com.im.client.ui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.im.client.component.NewButton;
import com.im.client.component.NewCheckbox;
import com.im.client.component.NewPasswordField;
import com.im.client.component.NewTextField;
import com.im.client.function.IMLoginManager;
import com.im.client.utils.DateUtils;
import com.im.client.utils.ImageManageUtils;
import com.im.client.utils.LimitedDocumentUtils;
import com.im.client.utils.ScreenSizeUtils;
import com.im.common.dto.MessageType;
import com.im.common.dto.User;
import com.sun.awt.AWTUtilities;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			Mini版用户登陆界面                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.ui                         
* Author：				Ellery                 
* Create Date：			2013-03-16 14:23 
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
	private ImageIcon login_bg_morningIcon = ImageManageUtils.getImageIcon("images/background/login/login_bg_morning.jpg");
	private ImageIcon login_bg_noonIcon = ImageManageUtils.getImageIcon("images/background/login/login_bg_noon.jpg");
	private ImageIcon login_bg_afternoonIcon = ImageManageUtils.getImageIcon("images/background/login/login_bg_afternoon.jpg");
	private ImageIcon login_bg_nightIcon = ImageManageUtils.getImageIcon("images/background/login/login_bg_night.jpg");
	//登录界面背景材质图片
	private ImageIcon login_bg_textureIcon = ImageManageUtils.getImageIcon("images/frame/login/bg_texture.png");
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
	private ImageIcon user_imageIcon = ImageManageUtils.getImageIcon("images/usericon/user_image/user_image.png");
	private ImageIcon user_image_bg_normalIcon = ImageManageUtils.getImageIcon("images/usericon/login_head_bkg_normal.png");
	private ImageIcon user_image_bg_hoverIcon = ImageManageUtils.getImageIcon("images/usericon/login_head_bkg_highlight.png");
	//密码框中的键盘
	private ImageIcon pwd_keyboard_Icon = ImageManageUtils.getImageIcon("images/frame/login/passwordfield/btn_loginpwd_keyboard.png");
	//输入框边框
	private ImageIcon textfield_borderIcon = ImageManageUtils.getImageIcon("images/frame/login/textfield/textfield_border.png");
	//帐号输入框下拉按钮
	private ImageIcon avatarIcon = ImageManageUtils.getImageIcon("images/frame/login/btn_arrow_avatar.png");
	//注册新用户按钮
	private ImageIcon btn_register_normalIcon = ImageManageUtils.getImageIcon("images/frame/login/fontbutton/btn_register_normal.png");
	//注册新用户按钮高亮
	private ImageIcon btn_register_hoverIcon = ImageManageUtils.getImageIcon("images/frame/login/fontbutton/btn_register_hover.png");
	//注册新用户按钮点击
	private ImageIcon btn_register_pressIcon = ImageManageUtils.getImageIcon("images/frame/login/fontbutton/btn_register_press.png");
	//注册新用户按钮
	private ImageIcon btn_forgetPwd_normalIcon = ImageManageUtils.getImageIcon("images/frame/login/fontbutton/btn_forgetPwd_normal.png");
	//注册新用户按钮高亮
	private ImageIcon btn_forgetPwd_hoverIcon = ImageManageUtils.getImageIcon("images/frame/login/fontbutton/btn_forgetPwd_hover.png");
	//注册新用户按钮点击
	private ImageIcon btn_forgetPwd_pressIcon = ImageManageUtils.getImageIcon("images/frame/login/fontbutton/btn_forgetPwd_press.png");
	//系统托盘图标
	private ImageIcon sys_tray_logoIcon = ImageManageUtils.getImageIcon("images/common/systemtray/sysTrayIcon.png");
	//系统任务栏图标
	private ImageIcon taskbar_logoIcon = ImageManageUtils.getImageIcon("images/common/taskBarIcon.png");
	//登录取消按钮
	private ImageIcon btn_login_cancelIcon = ImageManageUtils.getImageIcon("images/frame/login/button/button_red_normal.png");
	//登录取消按钮高亮
	private ImageIcon btn_login_cancel_hoverIcon = ImageManageUtils.getImageIcon("images/frame/login/button/button_red_hover.png");
	//登录取消按钮点击
	private ImageIcon btn_login_cancel_pressIcon = ImageManageUtils.getImageIcon("images/frame/login/button/button_red_press.png");
	//登录加载图标
	private ImageIcon login_loadingIcon = ImageManageUtils.getImageIcon("images/frame/login/login_loading.gif");
	//多帐户登录图标
	private ImageIcon multiple_accounts_normalIcon = ImageManageUtils.getImageIcon("images/frame/login/multipleaccounts/multiple_accounts_normal.png");
	//多帐户登录图标高亮
	private ImageIcon multiple_accounts_hoverIcon = ImageManageUtils.getImageIcon("images/frame/login/multipleaccounts/multiple_accounts_hover.png");
	//多帐户登录图标点击
	private ImageIcon multiple_accounts_pressIcon = ImageManageUtils.getImageIcon("images/frame/login/multipleaccounts/multiple_accounts_press.png");
	//帐号闪登图标
	private ImageIcon quick_login_normalIcon = ImageManageUtils.getImageIcon("images/frame/login/quicklogin/quick_login_normal.png");
	//帐号闪登图标高亮
	private ImageIcon quick_login_hoverIcon = ImageManageUtils.getImageIcon("images/frame/login/quicklogin/quick_login_hover.png");
	//帐号闪登图标点击
	private ImageIcon quick_login_pressIcon = ImageManageUtils.getImageIcon("images/frame/login/quicklogin/quick_login_press.png");
	//设置按钮
	private ImageIcon btn_set_normalIcon = ImageManageUtils.getImageIcon("images/common/btn_set_normal.png");
	//设置按钮高亮
	private ImageIcon btn_set_hoverIcon = ImageManageUtils.getImageIcon("images/common/btn_set_hover.png");
	//设置按钮被点击
	private ImageIcon btn_set_pressIcon = ImageManageUtils.getImageIcon("images/common/btn_set_press.png");
	//设置按钮被点击
	private ImageIcon logining_Icon = ImageManageUtils.getImageIcon("images/frame/login/loginingIcon.png");
	//警告消息提示
	private ImageIcon error_messageIcon = ImageManageUtils.getImageIcon("images/frame/login/warning/error_message_icon.png");
	//警告消息提示关闭按钮
	private ImageIcon error_message_closeIcon = ImageManageUtils.getImageIcon("images/frame/login/warning/btn_warning_close_normal.png");
	//警告消息提示关闭按钮高亮
	private ImageIcon error_message_close_hoverIcon = ImageManageUtils.getImageIcon("images/frame/login/warning/btn_warning_close_hover.png");
	//警告消息提示关闭按钮点击
	private ImageIcon error_message_close_pressIcon = ImageManageUtils.getImageIcon("images/frame/login/warning/btn_warning_close_press.png");
	//用户状态边框高亮
	private ImageIcon user_border_status_highlightIcon = ImageManageUtils.getImageIcon("images/frame/main/status/allbtn_highlight.png");
	//用户状态边框点击
	private ImageIcon user_border_status_pressIcon = ImageManageUtils.getImageIcon("images/frame/main/status/allbtn_down.png");
	//用户状态-隐身
	private ImageIcon user_invisible_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/invisible.png");
	//用户状态-离开
	private ImageIcon user_away_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/away.png");
	//用户状态-忙碌
	private ImageIcon user_busy_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/busy.png");
	//用户状态-隐身
	private ImageIcon user_mute_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/mute.png");
	//用户状态-Q我吧
	private ImageIcon user_qme_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/qme.png");
	//用户状态-在线
	private ImageIcon user_imonline_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/imonline.png");
	//用户状态-离线
	private ImageIcon user_imoffline_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/imoffline.png");

	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	//定义一个所有圆角都使用 double坐标指定的矩形
	private Shape shape = null;
    //获取系统托盘  
	private SystemTray systemTray = null; 
    //托盘图标对象  
    private TrayIcon trayIcon = null;
	//背景图片
    private JLabel login_bg = null;
	private JLabel login_bg_texture = null; 
	//背景图片时间
	private DateUtils dateUtils = null;
	//关闭按钮
	private JButton btn_close = null;
	//最小化按钮
	private JButton btn_mini = null;
	//设置按钮
	private JButton btn_set = null;
	//头像边框
	private JLabel user_image_normalbg = null;
	//头像图片
	private JLabel user_image = null;
	//头像边框高亮
	private JLabel user_image_hoverbg = null;
	//账户输入框的边框
	private JLabel user_textfield_border = null;
	//帐号输入框
	private NewTextField user_field = null;
	//密码框边框
	private JLabel pass_textfield_border = null;
	//密码框
	public static NewPasswordField password_field = null;
	//注册新用户按钮
	private JButton btn_register = null;
	//忘记密码按钮
	private JButton btn_forget_password = null;
	//记住密码复选框
	private NewCheckbox remember_password = null;
	//自动登录复选框
	private NewCheckbox automatic_login = null;
	//加载图片
	private JLabel login_loading = null;
	//登录取消按钮
	private JButton btn_login_cancel = null;
	//登录按钮
	private NewButton btn_login = null;
	//多帐户登录
	private JButton btn_multiple_accounts = null;
	//闪登
	private JButton btn_quick_login = null;
	//正在登录图标
	private JLabel loginingIcon = null;
	//正在登录号码
	private JLabel loginingAccount = null;
	//输入框最大长度及类型限定
	private LimitedDocumentUtils limitedDocumentUtils = null;
	//警告消息提示
	private JPanel errorMessagePanel = null;
	//警告图标
	private JLabel errorMessageIcon = null;
	//警告文字
	private JLabel errorMessage = null;
	//警告消息面板关闭按钮
	private JButton btn_errorMessage_close = null; 
	//设置用户状态边框高亮
	private JLabel user_stauts_hightlight_border = null;
	//设置用户状态按钮
	private JButton btn_user_status = null;
	//设置用户状态
    private JPopupMenu statusPopupMenu = null;
	//状态菜单-我在线上
	private JMenuItem imonlineItem = null;
	//状态菜单-Q我吧
	private JMenuItem qMeItem = null;
	//状态菜单-离开
	private JMenuItem awayItem = null;
	//状态菜单-忙碌
	private JMenuItem busyItem = null;
	//状态菜单-请勿打扰
	private JMenuItem muteItem = null;
	//状态菜单-隐身
	private JMenuItem invisibleItem = null;
	//状态菜单-离线
	private JMenuItem imofflineItem = null;
	
	//颜色灰
	private Color BLACK = new Color(32, 32, 32);
	//字体
	private Font FONT_12_BOLD = new Font("微软雅黑", 0, 12);
	private Font FONT_12_NOBOLD = new Font("微软雅黑", 0, 12);
	
	public MiniLogin(){
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
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		
		//设置任务栏图标
		this.setIconImage(taskbar_logoIcon.getImage());
		
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

	    //获取系统托盘  
	    systemTray = SystemTray.getSystemTray();
	    //创建一个托盘图标对象  
	    trayIcon = new TrayIcon(sys_tray_logoIcon.getImage());  
		//判断系统是否托盘
		if(SystemTray.isSupported()){  
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
		    trayIcon.setPopupMenu(menu);  
		    try {
		    	systemTray.add(trayIcon);//将托盘图表添加到系统托盘  
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		} 
		
		//设置背景图片
		dateUtils = new DateUtils();
		login_bg = new JLabel();  
		//判断当前时间以确定背景图片
		if("morning".equals(dateUtils.getCurrentHours())){
			login_bg.setIcon(login_bg_morningIcon);
		}else if("afternoon".equals(dateUtils.getCurrentHours())){
			login_bg.setIcon(login_bg_afternoonIcon);
		}else if("night".equals(dateUtils.getCurrentHours())){
			login_bg.setIcon(login_bg_nightIcon);
		}else if("noon".equals(dateUtils.getCurrentHours())){
			login_bg.setIcon(login_bg_noonIcon);
		}
		login_bg.setBounds(0, 0, windowWidth, windowHeight);
		login_bg_texture = new JLabel(login_bg_textureIcon);  
		login_bg_texture.setBounds(0, 0, windowWidth, windowHeight);
		
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
            	systemTray.remove(trayIcon);
                System.exit(0);
            }
        });

		//设置最小化按钮
		btn_mini = new JButton();
		btn_mini.setBounds((windowWidth-30-30), 0, 30, 20);
		btn_mini.setIcon(btn_mini_normalIcon);
		btn_mini.setRolloverIcon(btn_mini_hoverIcon);
		btn_mini.setPressedIcon(btn_mini_pressIcon);
		btn_mini.setBorderPainted(false);
		btn_mini.setContentAreaFilled(false);
		btn_mini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MiniLogin.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		//设置按钮
		btn_set = new JButton();
		btn_set.setBounds((windowWidth-30-30-28), 0, 28, 20);
		btn_set.setIcon(btn_set_normalIcon);
		btn_set.setRolloverIcon(btn_set_hoverIcon);
		btn_set.setPressedIcon(btn_set_pressIcon);
		btn_set.setBorderPainted(false);
		btn_set.setContentAreaFilled(false);
		
		//设置头像
		//头像边框
		user_image_normalbg = new JLabel(user_image_bg_normalIcon);
		user_image_normalbg.setBounds(15, 140, 87, 87);
		//头像图片
		user_image = new JLabel(user_imageIcon);
		user_image.setBounds(15, 140, 87, 87);
		//头像边框高亮
		user_image_hoverbg = new JLabel(user_image_bg_hoverIcon);
		user_image_hoverbg.setBounds(13, 138, 91, 91);
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
		user_textfield_border = new JLabel(textfield_borderIcon);
		user_textfield_border.setBorder(null);
		user_textfield_border.setBounds(110, 141, 192, 26);
		user_textfield_border.setVisible(false);

		//设置帐号输入框
		user_field = new NewTextField(avatarIcon);
		user_field.setBorder(null);
		user_field.setBounds(111, 142, 190, 24); 
		//设置输入框参数能输入的最大长度
		limitedDocumentUtils = new LimitedDocumentUtils(10);
		//只能输入的字符
		limitedDocumentUtils.setAllowChar("0123456789");
		//运用到文本框中
		user_field.setDocument(limitedDocumentUtils);
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
		pass_textfield_border = new JLabel(textfield_borderIcon);
		pass_textfield_border.setBorder(null);
		pass_textfield_border.setBounds(110, 171, 192, 26);
		pass_textfield_border.setVisible(false);
		
		//密码框
		password_field = new NewPasswordField(pwd_keyboard_Icon);
		password_field.setBorder(null);
		password_field.setBounds(111, 172, 190, 24);
		password_field.addMouseListener(new MouseListener() {
			
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
		
		//设置用户状态菜单
		statusPopupMenu = new JPopupMenu("JPopupMenu"); 
	    String[] items = {"我在线上", "Q我吧", "离开", "忙碌", "请勿打扰", "隐身", 
	    		"离线", "添加状态信息", "关闭所有声音", "锁定QQ", "系统设置...", "我的资料...", "我的QQ中心"};  
	    
	    //下拉菜单-我在线上
        imonlineItem = new JMenuItem(items[0], user_imonline_statusIcon);  
        imonlineItem.setFont(FONT_12_NOBOLD);
        imonlineItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_imonline_statusIcon);
            }  
        }); 
        
        //下拉菜单-Q我吧
        qMeItem = new JMenuItem(items[1], user_qme_statusIcon);  
        qMeItem.setFont(FONT_12_NOBOLD);
        qMeItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_qme_statusIcon);
            }  
        });  

        //下拉菜单-离开
        awayItem = new JMenuItem(items[2], user_away_statusIcon);  
        awayItem.setFont(FONT_12_NOBOLD);
        awayItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_away_statusIcon);
            }  
        }); 

        //下拉菜单-忙碌
        busyItem = new JMenuItem(items[3], user_busy_statusIcon);  
        busyItem.setFont(FONT_12_NOBOLD);
        busyItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_busy_statusIcon);
            }  
        }); 

        //下拉菜单-请勿打扰
        muteItem = new JMenuItem(items[4], user_mute_statusIcon);  
        muteItem.setFont(FONT_12_NOBOLD);
        muteItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_mute_statusIcon);
            }  
        }); 

        //下拉菜单-隐身
        invisibleItem = new JMenuItem(items[5], user_invisible_statusIcon);  
        invisibleItem.setFont(FONT_12_NOBOLD);
        invisibleItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_invisible_statusIcon);
            }  
        }); 

        //下拉菜单-离线
        imofflineItem = new JMenuItem(items[6], user_imoffline_statusIcon);  
        imofflineItem.setFont(FONT_12_NOBOLD);
        imofflineItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_imoffline_statusIcon);
            }  
        }); 

        //下拉菜单添加条目
        statusPopupMenu.add(imonlineItem);  
        statusPopupMenu.add(qMeItem);  
        statusPopupMenu.add(awayItem);  
        statusPopupMenu.add(busyItem);  
        statusPopupMenu.add(muteItem);  
        statusPopupMenu.add(invisibleItem);  
        statusPopupMenu.add(imofflineItem);  
		
		//设置用户状态边框
		user_stauts_hightlight_border = new JLabel(user_border_status_highlightIcon);
		user_stauts_hightlight_border.setBorder(null);
		user_stauts_hightlight_border.setBounds(110, 200, 22, 22);
		user_stauts_hightlight_border.setVisible(false);
        
        //设置用户状态
		btn_user_status = new JButton();
		btn_user_status.setBounds(115, 205, 12, 11);
		btn_user_status.setIcon(user_imonline_statusIcon);
		btn_user_status.setBorderPainted(false);
		btn_user_status.setContentAreaFilled(false);
		btn_user_status.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(statusPopupMenu.getSubElements().length != 0) {  
                	//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
                	statusPopupMenu.show(MiniLogin.this, 110, 222);  
                    //请求此 Component 获取输入焦点
                	statusPopupMenu.requestFocus();  
                }  
            }  
        });  
		btn_user_status.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				user_stauts_hightlight_border.setIcon(user_border_status_pressIcon);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				user_stauts_hightlight_border.setIcon(user_border_status_highlightIcon);
				user_stauts_hightlight_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				user_stauts_hightlight_border.setVisible(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

		//设置注册新用户按钮
		btn_register = new JButton();
		btn_register.setBounds(310, 148, 51, 16);
		btn_register.setIcon(btn_register_normalIcon);
		btn_register.setRolloverIcon(btn_register_hoverIcon);
		btn_register.setPressedIcon(btn_register_pressIcon);
		btn_register.setBorderPainted(false);
		btn_register.setContentAreaFilled(false);
		
		//设置忘记密码按钮
		btn_forget_password = new JButton();
		btn_forget_password.setBounds(310, 179, 51, 16);
		btn_forget_password.setIcon(btn_forgetPwd_normalIcon);
		btn_forget_password.setRolloverIcon(btn_forgetPwd_hoverIcon);
		btn_forget_password.setPressedIcon(btn_forgetPwd_pressIcon);
		btn_forget_password.setBorderPainted(false);
		btn_forget_password.setContentAreaFilled(false);
		
		//记住密码复选框
		remember_password = new NewCheckbox("记住密码");
		remember_password.setBounds(135, 203, 80, 15);
		remember_password.setFont(FONT_12_BOLD);
		remember_password.setForeground(BLACK);
		remember_password.setOpaque(false);
		
		//自动登录复选框
		automatic_login = new NewCheckbox("自动登录");
		automatic_login.setBounds(210, 203, 80, 15);
		automatic_login.setFont(FONT_12_BOLD);
		automatic_login.setForeground(BLACK);
		automatic_login.setOpaque(false);
		
		//登录加载图片
		login_loading = new JLabel(login_loadingIcon);  
		login_loading.setBounds(1, 240, 377, 2);
		login_loading.setVisible(false);
		
		//警告消息提示
		errorMessagePanel = new JPanel(null);
		errorMessagePanel.setBounds(0, 220, 380, 25);
		errorMessagePanel.setBackground(new Color(179, 217, 239, 240));
		errorMessagePanel.setVisible(false);
		
		//警告图标
		errorMessageIcon = new JLabel(error_messageIcon);
		errorMessageIcon.setBounds(10, 5, 16, 16);
		errorMessageIcon.setVisible(true);
		
		//警告文字
		errorMessage = new JLabel();
		//errorMessage.setText("您已登录10000 , 不能重复登录。");
		errorMessage.setFont(FONT_12_NOBOLD);
		errorMessage.setBounds(36, 4, 300, 16);
		errorMessage.setVisible(true);
		
		//警告消息面板关闭按钮
		btn_errorMessage_close = new JButton();
		btn_errorMessage_close.setBounds(365, 5, 12, 12);
		btn_errorMessage_close.setIcon(error_message_closeIcon);
		btn_errorMessage_close.setRolloverIcon(error_message_close_hoverIcon);
		btn_errorMessage_close.setPressedIcon(error_message_close_pressIcon);
		btn_errorMessage_close.setBorderPainted(false);
		btn_errorMessage_close.setContentAreaFilled(false);
		btn_errorMessage_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMessagePanel.setVisible(false);
			}
		});
		
		//警告消息提示面板添加组件
		errorMessagePanel.add(errorMessageIcon);
		errorMessagePanel.add(errorMessage);
		errorMessagePanel.add(btn_errorMessage_close);

		//设置登录按钮
		btn_login = new NewButton("登录");
		btn_login.setBounds(71, 245, 237, 48);
		btn_login.setBorderPainted(false);
		btn_login.setContentAreaFilled(false);
		btn_login.setFont(FONT_12_BOLD);
		//设置文字在按钮水平垂直上的位置
		btn_login.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_login.setVerticalTextPosition(SwingConstants.CENTER);
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_login.setVisible(false);
				btn_login_cancel.setVisible(true);
				login_loading.setVisible(true);
				btn_multiple_accounts.setVisible(false);
				btn_quick_login.setVisible(false);
				//登录中
				loginingIcon.setVisible(true);
				loginingAccount.setVisible(true);
				user_image.setVisible(false);
				user_image_normalbg.setVisible(false);
				user_image_hoverbg.setVisible(false);
				user_textfield_border.setVisible(false);
				user_field.setVisible(false);
				pass_textfield_border.setVisible(false);
				password_field.setVisible(false);
				btn_forget_password.setVisible(false);
				btn_register.setVisible(false);
				remember_password.setVisible(false);
				automatic_login.setVisible(false);
				btn_user_status.setVisible(false);
				
				//登录验证
				User user = new User();
				user.setIm(user_field.getText());
				user.setPassword(new String(password_field.getPassword()));
				
				IMLoginManager loginManager = new IMLoginManager();
				MessageType loginMessageType = loginManager.userAuthentication(user);
				
				if(loginMessageType.getMessageTypeName().equals("authenticationsuccess")){
					MiniLogin.this.dispose();
					new Main().setVisible(true);
				} else if(loginMessageType.getMessageTypeName().equals("authenticationfailure")){
					//登录失败，显示警告消息
					System.out.println("登录失败");
					errorMessage.setText("您输入的帐号或密码不正确, 请确认登录。");
					errorMessagePanel.setVisible(true);
					
					btn_login.setVisible(true);
					btn_login_cancel.setVisible(false);
					login_loading.setVisible(false);
					btn_multiple_accounts.setVisible(true);
					btn_quick_login.setVisible(true);
					//登录中
					loginingIcon.setVisible(false);
					loginingAccount.setVisible(false);
					user_image.setVisible(true);
					user_image_normalbg.setVisible(true);
					user_image_hoverbg.setVisible(true);
					user_textfield_border.setVisible(true);
					user_field.setVisible(true);
					pass_textfield_border.setVisible(true);
					password_field.setVisible(true);
					btn_forget_password.setVisible(true);
					btn_register.setVisible(true);
					remember_password.setVisible(true);
					automatic_login.setVisible(true);
				}
			}
		});
		
		//设置登录取消按钮
		btn_login_cancel = new JButton("取消");
		btn_login_cancel.setBounds(71, 245, 237, 48);
		btn_login_cancel.setIcon(btn_login_cancelIcon);
		btn_login_cancel.setRolloverIcon(btn_login_cancel_hoverIcon);
		btn_login_cancel.setPressedIcon(btn_login_cancel_pressIcon);
		btn_login_cancel.setBorderPainted(false);
		btn_login_cancel.setContentAreaFilled(false);
		btn_login_cancel.setFont(FONT_12_BOLD);
		//设置文字在按钮水平垂直上的位置
		btn_login_cancel.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_login_cancel.setVerticalTextPosition(SwingConstants.CENTER);
		//默认不显示
		btn_login_cancel.setVisible(false);
		btn_login_cancel.addMouseListener(new MouseListener() {
			
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

			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
								
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_login.setVisible(true);
				btn_login_cancel.setVisible(false);
				login_loading.setVisible(false);
				btn_multiple_accounts.setVisible(true);
				btn_quick_login.setVisible(true);
				//登录中
				loginingIcon.setVisible(false);
				loginingAccount.setVisible(false);
				user_image.setVisible(true);
				user_image_normalbg.setVisible(true);
				user_image_hoverbg.setVisible(true);
				user_textfield_border.setVisible(true);
				user_field.setVisible(true);
				pass_textfield_border.setVisible(true);
				password_field.setVisible(true);
				btn_forget_password.setVisible(true);
				btn_register.setVisible(true);
				remember_password.setVisible(true);
				automatic_login.setVisible(true);
				btn_user_status.setVisible(true);
			}
		});
		
		//设置多帐户登录按钮
		btn_multiple_accounts = new JButton();
		btn_multiple_accounts.setBounds(0, 252, 40, 40);
		btn_multiple_accounts.setIcon(multiple_accounts_normalIcon);
		btn_multiple_accounts.setRolloverIcon(multiple_accounts_hoverIcon);
		btn_multiple_accounts.setPressedIcon(multiple_accounts_pressIcon);
		btn_multiple_accounts.setBorderPainted(false);
		btn_multiple_accounts.setContentAreaFilled(false);
		btn_multiple_accounts.addMouseListener(new MouseListener() {
			
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

			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
								
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		//设置闪登按钮
		btn_quick_login = new JButton();
		btn_quick_login.setBounds(340, 252, 40, 40);
		btn_quick_login.setIcon(quick_login_normalIcon);
		btn_quick_login.setRolloverIcon(quick_login_hoverIcon);
		btn_quick_login.setPressedIcon(quick_login_pressIcon);
		btn_quick_login.setBorderPainted(false);
		btn_quick_login.setContentAreaFilled(false);
		btn_quick_login.addMouseListener(new MouseListener() {
			
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

			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
								
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		//正在登录图片
		loginingIcon = new JLabel(logining_Icon);
		loginingIcon.setBounds(90, 142, 30, 30);
		loginingIcon.setVisible(false);
		
		//正在登录号码
		loginingAccount = new JLabel("正在登录(" + "921728078" + ")...");
		loginingAccount.setBounds(120, 142, 200, 30);
		loginingAccount.setFont(FONT_12_NOBOLD);
		loginingAccount.setForeground(Color.WHITE);
		loginingAccount.setVisible(false);
		
		//添加界面组件
		this.setContentPane(login_bg);
		this.add(btn_close);
		this.add(btn_mini);
		this.add(btn_set);
		this.add(errorMessagePanel);
		this.add(user_image_normalbg);
		this.add(user_image_hoverbg);
		this.add(user_image);
		this.add(user_textfield_border);
		this.add(user_field);
		this.add(pass_textfield_border);
		this.add(password_field);
		this.add(btn_register);
		this.add(btn_forget_password);
		this.add(remember_password);
		this.add(automatic_login);
		this.add(login_loading);
		this.add(btn_login);
		this.add(btn_login_cancel);
		this.add(btn_multiple_accounts);
		this.add(btn_quick_login);
		this.add(loginingIcon);
		this.add(loginingAccount);
		this.add(user_stauts_hightlight_border);
		this.add(btn_user_status);
		login_bg.add(login_bg_texture);
		
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
