package com.im.client.ui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.im.client.component.NewTabbedPane;
import com.im.client.utils.ImageManageUtils;
import com.im.client.utils.ScreenSizeUtils;
import com.im.client.utils.WeatherUtils;
import com.sun.awt.AWTUtilities;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			IM主界面                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.ui                         
* Author：				Ellery                 
* Create Date：			2011-03-19 23:50 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 
@SuppressWarnings("serial")
public class Main extends JFrame{

	//窗口的宽度和窗口的高度
	private int windowWidth = 285;
	private int windowHeight = 590;
	
	//屏幕的宽度和屏幕的高度
	private int screenWidth = 0;
	private int screenHeight = 0;

	//窗体是否完全不透明
	private boolean isWindowOpaque = true;

	//登录界面背景图片
	private ImageIcon main_bg_Icon = ImageManageUtils.getImageIcon("images/background/main/main_bg_snail.jpg");
	//系统任务栏图标
	private ImageIcon taskbar_logoIcon = ImageManageUtils.getImageIcon("images/common/taskBarIcon.png");
	//系统托盘图标
	private ImageIcon sys_tray_logoIcon = ImageManageUtils.getImageIcon("images/common/systemtray/sysTrayIcon.png");
	//系统托盘图标-away
	private ImageIcon sys_tray_awayIcon = ImageManageUtils.getImageIcon("images/common/systemtray/male/tray_away.png");
	//系统托盘图标-busy
	private ImageIcon sys_tray_busyIcon = ImageManageUtils.getImageIcon("images/common/systemtray/male/tray_busy.png");
	//系统托盘图标-imoffline
	private ImageIcon sys_tray_imofflineIcon = ImageManageUtils.getImageIcon("images/common/systemtray/male/tray_imoffline.png");
	//系统托盘图标-imonline
	private ImageIcon sys_tray_imonlineIcon = ImageManageUtils.getImageIcon("images/common/systemtray/male/tray_imonline.png");
	//系统托盘图标-invisible
	private ImageIcon sys_tray_invisibleIcon = ImageManageUtils.getImageIcon("images/common/systemtray/male/tray_invisible.png");
	//系统托盘图标-mute
	private ImageIcon sys_tray_muteIcon = ImageManageUtils.getImageIcon("images/common/systemtray/male/tray_mute.png");
	//系统托盘图标-qme
	private ImageIcon sys_tray_qmeIcon = ImageManageUtils.getImageIcon("images/common/systemtray/male/tray_qme.png");
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
	//皮肤按钮
	private ImageIcon btn_skin_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/btn_skin_normal.png");
	//皮肤按钮高亮
	private ImageIcon btn_skin_hoverIcon = ImageManageUtils.getImageIcon("images/frame/main/btn_skin_highlight.png");
	//皮肤按钮被点击
	private ImageIcon btn_skin_pressIcon = ImageManageUtils.getImageIcon("images/frame/main/btn_skin_press.png");
	//头像边框高亮
	private ImageIcon user_image_border_highlightIcon = ImageManageUtils.getImageIcon("images/frame/main/user_imgbg_hightlight.png");
	//头像边框
	private ImageIcon user_image_border_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/user_imgbg_normal.png");
	//用户头像
	private ImageIcon user_imageIcon = ImageManageUtils.getImageIcon("images/usericon/user_image.png");
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
	//用户状态-关闭所有声音
	private ImageIcon user_closeallmusic_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/complete.png");
	//用户状态-锁定QQ
	private ImageIcon user_lock_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/lock.png");
	//menu按钮边框高亮图标
	private ImageIcon btn_icon_broder_highlightIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/allbtn_highlight.png");
	//menu按钮边框点击图标
	private ImageIcon btn_icon_broder_pressIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/allbtn_down.png");
	//空间
	private ImageIcon btn_qzoneIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_qzone_icon.png");
	//微博
	private ImageIcon btn_wblogIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_wblog_icon.png");
	//朋友
	//private ImageIcon btn_friendIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_friend_icon.png");
	//mail
	private ImageIcon btn_mailIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_mail_icon.png");
	//today
	private ImageIcon btn_todayIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_today_icon.png");
	//paipai
	private ImageIcon btn_paipaiIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_paipai_icon.png");
	//purse
	private ImageIcon btn_purseIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_purse_icon.png");
	//soso
	//private ImageIcon btn_sosoIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_soso_icon.png");
	//msgbox
	private ImageIcon btn_msgboxIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_messagebox_icon.png");
	//add
	private ImageIcon btn_mgrIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_icon_management.png");
	//搜索框背景
	private ImageIcon search_bg_Icon = ImageManageUtils.getImageIcon("images/frame/main/search/main_search_bkg.png");
	//搜索框搜索按钮
	private ImageIcon btn_search_Icon = ImageManageUtils.getImageIcon("images/frame/main/search/main_search_normal.png");
	//搜索框搜索进入按钮
	private ImageIcon btn_search_enterIcon = ImageManageUtils.getImageIcon("images/frame/main/search/main_search_enter.png");
	//搜索框搜索进入按钮点击
	private ImageIcon btn_search_downIcon = ImageManageUtils.getImageIcon("images/frame/main/search/main_search_down.png");
	//tab 联系人
	private ImageIcon tab_contacts_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/tab/icon_contacts_normal.png");
	//tab 朋友
	private ImageIcon tab_friends_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/tab/icon_friends_normal.png");
	//tab 群
	private ImageIcon tab_group_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/tab/icon_group_normal.png");
	//tab 最近联系人
	private ImageIcon tab_last_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/tab/icon_last_normal.png");
	//tab 微博
	private ImageIcon tab_wblog_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/tab/icon_wblog_normal.png");
	
	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	//定义一个所有圆角都使用 double坐标指定的矩形
	private Shape shape = null;
    //获取系统托盘  
	private SystemTray systemTray = null; 
    //托盘图标对象  
    private TrayIcon trayIcon = null;
	//背景图片
    private JLabel main_bg = null;
    //关闭按钮
	private JButton btn_close = null;
	//最小化按钮
	private JButton btn_mini = null;
	//设置标题栏
	private JLabel title_main = null;
	//设置皮肤按钮
	private JButton btn_skin = null;
	//设置头像边框普通
	private JLabel user_img_normal_border = null; 
	//设置头像边框高亮
	private JLabel user_img_hightlight_border = null;
	//设置头像
	private JLabel user_image = null;
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
	//状态菜单-添加状态信息
	private JMenuItem addStatusItem = null;
	//状态菜单-关闭所有声音
	private JMenuItem closeAllMusicItem = null;
	//状态菜单-锁定QQ
	private JMenuItem lockItem = null;
	//状态菜单-系统设置
	private JMenuItem systemSetItem = null;
	//状态菜单-我的资料
	private JMenuItem myProfileItem = null;
	//状态菜单-我的QQ中心
	private JMenuItem myCenterItem = null;
	//设置昵称
	private JLabel nickName = null;
	//个性签名
	private	JLabel sign = null;
	//天气
	private JButton btn_weather = null;
	//当前天气状态
	private String currentWeatherStatus = "";
	//设置qzone边框高亮
	private JLabel btn_qzone_border = null;
	//设置qq空间按钮
	private JButton btn_qzone = null;
	//设置wblog边框高亮
	private JLabel btn_wblog_border = null; 
	//设置微博按钮
	private JButton btn_wblog = null;
	//设置friends边框高亮
	//private JLabel btn_friend_border = null;
	//设置校友按钮
	//private JButton btn_friend = null;
	//设置email边框高亮
	private JLabel btn_email_border = null;
	//设置email按钮
	private JButton btn_email = null;
	//设置today边框高亮
	private JLabel btn_today_border = null;
	//设置today按钮
	private JButton btn_today = null;
	//设置paipai边框高亮
	private JLabel btn_paipai_border = null;
	//设置paipai按钮
	private JButton btn_paipai = null;
	//设置purse边框高亮
	private JLabel btn_purse_border = null;
	//设置purse按钮
	private JButton btn_purse = null;
	//设置soso边框高亮
	//private JLabel btn_soso_border = null;
	//设置soso按钮
	//private JButton btn_soso = null;
	//设置msgbox边框高亮
	private JLabel btn_msgbox_border = null;
	//设置msgbox按钮
	private JButton btn_msgbox = null;
	//设置mgr边框高亮
	private JLabel btn_mgr_border = null;
	//设置mgr按钮
	private JButton btn_mgr = null;
	//设置搜索框背景
	private JLabel search_textfield_bg = null;
	//设置搜索框
	private JTextField search_textfield = null;
	//设置搜索按钮
	private JButton btn_search = null;
	//设置选项卡
	private JTabbedPane main_tab = null;
	//设置好友列表panel
	private JPanel friendsPanel = null;

	//颜色绿
	private Color GREEN = new Color(154,205,50);
	//字体
	private Font FONT_12_BOLD = new Font("微软雅黑", 1, 12);
	private Font FONT_12_NOBOLD = new Font("微软雅黑", 0, 12);
	private Font FONT_14_NOBOLD = new Font("微软雅黑", 0, 14);
	private Font FONT_13_NOBOLD = new Font("微软雅黑", 0, 13);
	
	public Main(){
		//获取屏幕高度宽度
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
		
		//设置天气
		currentWeatherStatus = "sunny";
		
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
		this.setBackground(GREEN);
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
        main_bg = new JLabel(){
			@Override
			protected void paintComponent(Graphics g) {
				// 图片随窗体大小而变化
                g.drawImage(main_bg_Icon.getImage(), 0, 0, Main.this);
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
				Main.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		//设置标题栏
		title_main = new JLabel("IM2013");
		title_main.setFont(FONT_12_BOLD);
		title_main.setForeground(Color.white);
		title_main.setBounds(9, 4, 57, 17);

		//设置皮肤按钮
		btn_skin = new JButton();
		btn_skin.setBounds((windowWidth-30-30-28), 0, 28, 20);
		btn_skin.setIcon(btn_skin_normalIcon);
		btn_skin.setRolloverIcon(btn_skin_hoverIcon);
		btn_skin.setPressedIcon(btn_skin_pressIcon);
		btn_skin.setBorderPainted(false);
		btn_skin.setContentAreaFilled(false);

		//设置头像边框普通
		user_img_normal_border = new JLabel(user_image_border_normalIcon);
		user_img_normal_border.setBorder(null);
		user_img_normal_border.setBounds(9, 30, 61, 61);
		user_img_normal_border.setVisible(true);
		
		//设置头像边框高亮
		user_img_hightlight_border = new JLabel(user_image_border_highlightIcon);
		user_img_hightlight_border.setBorder(null);
		user_img_hightlight_border.setBounds(9, 30, 61, 61);
		user_img_hightlight_border.setVisible(false);
		
		//设置头像
		user_image = new JLabel(user_imageIcon);
		user_image.setBounds(13,34,53,53);
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
                trayIcon.setImage(sys_tray_imonlineIcon.getImage());
            }  
        }); 
        
        //下拉菜单-Q我吧
        qMeItem = new JMenuItem(items[1], user_qme_statusIcon);  
        qMeItem.setFont(FONT_12_NOBOLD);
        qMeItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_qme_statusIcon);
                trayIcon.setImage(sys_tray_qmeIcon.getImage());
            }  
        });  

        //下拉菜单-离开
        awayItem = new JMenuItem(items[2], user_away_statusIcon);  
        awayItem.setFont(FONT_12_NOBOLD);
        awayItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_away_statusIcon);
                trayIcon.setImage(sys_tray_awayIcon.getImage());
            }  
        }); 

        //下拉菜单-忙碌
        busyItem = new JMenuItem(items[3], user_busy_statusIcon);  
        busyItem.setFont(FONT_12_NOBOLD);
        busyItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_busy_statusIcon);
                trayIcon.setImage(sys_tray_busyIcon.getImage());
            }  
        }); 

        //下拉菜单-请勿打扰
        muteItem = new JMenuItem(items[4], user_mute_statusIcon);  
        muteItem.setFont(FONT_12_NOBOLD);
        muteItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_mute_statusIcon);
                trayIcon.setImage(sys_tray_muteIcon.getImage());
            }  
        }); 

        //下拉菜单-隐身
        invisibleItem = new JMenuItem(items[5], user_invisible_statusIcon);  
        invisibleItem.setFont(FONT_12_NOBOLD);
        invisibleItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_invisible_statusIcon);
                trayIcon.setImage(sys_tray_invisibleIcon.getImage());
            }  
        }); 

        //下拉菜单-离线
        imofflineItem = new JMenuItem(items[6], user_imoffline_statusIcon);  
        imofflineItem.setFont(FONT_12_NOBOLD);
        imofflineItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(user_imoffline_statusIcon);
                trayIcon.setImage(sys_tray_imofflineIcon.getImage());
            }  
        }); 

        //下拉菜单-添加状态信息
        addStatusItem = new JMenuItem(items[7]);  
        addStatusItem.setFont(FONT_12_NOBOLD);
        addStatusItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                //btn_user_status.setIcon(btn_user_imoffline_statusIcon);
            }  
        }); 
        
        //下拉菜单-关闭所有声音
        closeAllMusicItem = new JMenuItem(items[8], user_closeallmusic_statusIcon);  
        closeAllMusicItem.setFont(FONT_12_NOBOLD);
        closeAllMusicItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                //btn_user_status.setIcon(btn_user_imoffline_statusIcon);
            }  
        }); 
        
        //下拉菜单-锁定QQ
        lockItem = new JMenuItem(items[9], user_lock_statusIcon);  
        lockItem.setFont(FONT_12_NOBOLD);
        //设置快捷键
        lockItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
        lockItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	System.out.println("lock qq ctrl+alt+l");
            }  
        }); 

        //下拉菜单-系统设置
        systemSetItem = new JMenuItem(items[10]);  
        systemSetItem.setFont(FONT_12_NOBOLD);
        systemSetItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                //btn_user_status.setIcon(btn_user_imoffline_statusIcon);
            }  
        }); 

        //下拉菜单-我的资料
        myProfileItem = new JMenuItem(items[11]);  
        myProfileItem.setFont(FONT_12_NOBOLD);
        myProfileItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                //btn_user_status.setIcon(btn_user_imoffline_statusIcon);
            }  
        }); 

        //下拉菜单-我的QQ中心
        myCenterItem = new JMenuItem(items[12]);  
        myCenterItem.setFont(FONT_12_NOBOLD);
        myCenterItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                //btn_user_status.setIcon(btn_user_imoffline_statusIcon);
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
        //下拉菜单添加分割线
        statusPopupMenu.addSeparator(); 
        statusPopupMenu.add(addStatusItem);
        statusPopupMenu.addSeparator(); 
        statusPopupMenu.add(closeAllMusicItem);
        statusPopupMenu.addSeparator();  
        statusPopupMenu.add(lockItem); 
        statusPopupMenu.addSeparator();  
        statusPopupMenu.add(systemSetItem); 
        statusPopupMenu.add(myProfileItem);
        statusPopupMenu.add(myCenterItem);
		
		//设置用户状态边框
		user_stauts_hightlight_border = new JLabel(user_border_status_highlightIcon);
		user_stauts_hightlight_border.setBorder(null);
		user_stauts_hightlight_border.setBounds(75, 34, 22, 22);
		user_stauts_hightlight_border.setVisible(false);
        
        //设置用户状态
		btn_user_status = new JButton();
		btn_user_status.setBounds(80, 39, 12, 11);
		btn_user_status.setIcon(user_imonline_statusIcon);
		btn_user_status.setBorderPainted(false);
		btn_user_status.setContentAreaFilled(false);
		btn_user_status.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(statusPopupMenu.getSubElements().length != 0) {  
                	//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
                	statusPopupMenu.show(Main.this, 75, 61);  
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

		//设置昵称
		nickName = new JLabel("蔚蓝de天空");
		nickName.setFont(FONT_14_NOBOLD);
		nickName.setBounds(100, 37, 75, 17);

		//个性签名
		sign = new JLabel("请编辑个性签名...");
		sign.setFont(FONT_12_NOBOLD);
		sign.setBounds(75, 51, 229, 25);

		//设置天气按钮
		btn_weather = new JButton();
		btn_weather.setBounds(220, 27, 60, 50);
		btn_weather.setIcon(new WeatherUtils(currentWeatherStatus)
			.getCurrentWeatherInfo().getWeatherImageIcon());
		btn_weather.setBorderPainted(false);
		btn_weather.setContentAreaFilled(false);
		btn_weather.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("weather");
			}
		});

		//设置qzone边框高亮
		btn_qzone_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_qzone_border.setBorder(null);
		btn_qzone_border.setBounds(75, 73, 22, 22);
		btn_qzone_border.setVisible(false);
		
		//设置空间按钮
		btn_qzone = new JButton();
		btn_qzone.setBounds(78, 76, 16, 16);
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
		btn_wblog_border.setBounds(97, 73, 22, 22);
		btn_wblog_border.setVisible(false);

		//设置微博按钮
		btn_wblog = new JButton();
		btn_wblog.setBounds(100, 76, 16, 16);
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

		//设置email边框高亮
		btn_email_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_email_border.setBorder(null);
		btn_email_border.setBounds(119, 73, 22, 22);
		btn_email_border.setVisible(false);
		
		//设置email按钮
		btn_email = new JButton();
		btn_email.setBounds(122, 76, 16, 16);
		btn_email.setIcon(btn_mailIcon);
		btn_email.setBorderPainted(false);
		btn_email.setContentAreaFilled(false);
		btn_email.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_email_border.setIcon(btn_icon_broder_highlightIcon);
				btn_email_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_email_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_email_border.setIcon(btn_icon_broder_pressIcon);
			}
		});

		//设置today边框高亮
		btn_today_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_today_border.setBorder(null);
		btn_today_border.setBounds(141, 73, 22, 22);
		btn_today_border.setVisible(false);
		
		//设置today按钮
		btn_today = new JButton();
		btn_today.setBounds(144, 76, 16, 16);
		btn_today.setIcon(btn_todayIcon);
		btn_today.setBorderPainted(false);
		btn_today.setContentAreaFilled(false);
		btn_today.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_today_border.setIcon(btn_icon_broder_highlightIcon);
				btn_today_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_today_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_today_border.setIcon(btn_icon_broder_pressIcon);
			}
		});

		//设置paipai边框高亮
		btn_paipai_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_paipai_border.setBorder(null);
		btn_paipai_border.setBounds(163, 73, 22, 22);
		btn_paipai_border.setVisible(false);
		
		//设置paipai按钮
		btn_paipai = new JButton();
		btn_paipai.setBounds(166, 76, 16, 16);
		btn_paipai.setIcon(btn_paipaiIcon);
		btn_paipai.setBorderPainted(false);
		btn_paipai.setContentAreaFilled(false);
		btn_paipai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_paipai_border.setIcon(btn_icon_broder_highlightIcon);
				btn_paipai_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_paipai_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_paipai_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置purse边框高亮
		btn_purse_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_purse_border.setBorder(null);
		btn_purse_border.setBounds(185, 73, 22, 22);
		btn_purse_border.setVisible(false);
		
		//设置purse按钮
		btn_purse = new JButton();
		btn_purse.setBounds(188, 76, 16, 16);
		btn_purse.setIcon(btn_purseIcon);
		btn_purse.setBorderPainted(false);
		btn_purse.setContentAreaFilled(false);
		btn_purse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_purse_border.setIcon(btn_icon_broder_highlightIcon);
				btn_purse_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_purse_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_purse_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置mgr边框高亮
		btn_mgr_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_mgr_border.setBorder(null);
		btn_mgr_border.setBounds(207, 73, 22, 22);
		btn_mgr_border.setVisible(false);
		
		//设置mgr按钮
		btn_mgr = new JButton();
		btn_mgr.setBounds(210, 76, 16, 16);
		btn_mgr.setIcon(btn_mgrIcon);
		btn_mgr.setBorderPainted(false);
		btn_mgr.setContentAreaFilled(false);
		btn_mgr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_mgr_border.setIcon(btn_icon_broder_highlightIcon);
				btn_mgr_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_mgr_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_mgr_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置msgbox边框高亮
		btn_msgbox_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_msgbox_border.setBorder(null);
		btn_msgbox_border.setBounds(259, 73, 22, 22);
		btn_msgbox_border.setVisible(false);
		
		//设置msgbox按钮
		btn_msgbox = new JButton();
		btn_msgbox.setBounds(262, 76, 16, 16);
		btn_msgbox.setIcon(btn_msgboxIcon);
		btn_msgbox.setBorderPainted(false);
		btn_msgbox.setContentAreaFilled(false);
		btn_msgbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_msgbox_border.setIcon(btn_icon_broder_highlightIcon);
				btn_msgbox_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_msgbox_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_msgbox_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置搜索框背景
		search_textfield_bg = new JLabel(search_bg_Icon);
		search_textfield_bg.setBorder(null);
		search_textfield_bg.setBounds(0, 98, 285, 28);
		
		//设置搜索框
		search_textfield = new JTextField(40);
		search_textfield.setBounds(5, 100, 254, 25);
		search_textfield.setBorder(BorderFactory.createEmptyBorder());
		search_textfield.setOpaque(false);
		search_textfield.setFont(FONT_13_NOBOLD);
		search_textfield.setForeground(Color.BLACK);
		search_textfield.setText("输入关键字搜索联系人");
		search_textfield.addFocusListener(new FocusListener() {  
    	  public void focusLost(FocusEvent e) {
			  btn_search.setIcon(btn_search_Icon);
			  btn_search.setRolloverIcon(btn_search_Icon);
			  search_textfield.setText("输入关键字搜索联系人");
    	  }
		  public void focusGained(FocusEvent e) {
			  btn_search.setIcon(btn_search_enterIcon);
			  btn_search.setRolloverIcon(btn_search_downIcon);
			  search_textfield.setText("");
		  }
        });
		
		//设置搜索按钮
		btn_search = new JButton();
		btn_search.setBounds(255, 98, 31, 28);
		btn_search.setIcon(btn_search_Icon);
		btn_search.setBorderPainted(false);
		btn_search.setContentAreaFilled(false);
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
			}
		});
		
		//选项卡JPanel
		//设置好友列表panel
		friendsPanel = new JPanel(null);
		friendsPanel.setBackground(Color.WHITE);
		
		//设置选项卡
		main_tab = new JTabbedPane();
		main_tab.setUI(new NewTabbedPane());
		main_tab.addTab("", tab_contacts_normalIcon, friendsPanel, "联系人");
		main_tab.addTab("", tab_friends_normalIcon, new JLabel("This is tab two."), "朋友");
		main_tab.addTab("", tab_group_normalIcon, new JLabel("This is tab three."),"群/讨论组");
		main_tab.addTab("", tab_wblog_normalIcon, new JLabel("This is tab four."), "微博");
		main_tab.addTab("", tab_last_normalIcon, new JLabel("This is tab five."), "最近联系人");
		main_tab.setBounds(0, 126, 285, 395);
		
		
		//添加组件
		this.setContentPane(main_bg);
		this.add(btn_close);
		this.add(btn_mini);
		this.add(title_main);
		this.add(btn_skin);
		this.add(user_img_hightlight_border);
		this.add(user_img_normal_border);
		this.add(user_image);
		this.add(user_stauts_hightlight_border);
		this.add(btn_user_status);
		this.add(nickName);
		this.add(sign);
		this.add(btn_weather);
		this.add(btn_qzone_border);
		this.add(btn_qzone);
		this.add(btn_wblog_border);
		this.add(btn_wblog);
		this.add(btn_email_border);
		this.add(btn_email);
		this.add(btn_today_border);
		this.add(btn_today);
		this.add(btn_paipai_border);
		this.add(btn_paipai);
		this.add(btn_purse_border);
		this.add(btn_purse);
		this.add(btn_msgbox);
		this.add(btn_msgbox_border);
		this.add(btn_mgr);
		this.add(btn_mgr_border);
		this.add(search_textfield);
		this.add(btn_search);
		this.add(search_textfield_bg);
		this.add(main_tab);
		
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
            Rectangle bounds = Main.this.getBounds();
            bounds.x += offsetX;
            bounds.y += offsetY;
            Main.this.setBounds(bounds);
            lastPoint = point;
        }
	};
	
	public static void main(String[] args) {
		new Main().setVisible(true);
	}

}
