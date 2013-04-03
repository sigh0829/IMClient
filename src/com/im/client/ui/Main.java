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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.im.client.utils.ImageManageUtils;
import com.im.client.utils.ScreenSizeUtils;
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
	private int windowWidth = 280;
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
	private ImageIcon sys_tray_logoIcon = ImageManageUtils.getImageIcon("images/common/sysTrayIcon.png");
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
	private ImageIcon user_border_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/statusborder.png");
	//用户状态按钮-隐身
	private ImageIcon btn_user_invisible_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/btn_invisible.png");
	//用户状态按钮-离开
	private ImageIcon btn_user_away_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/btn_away.png");
	//用户状态按钮-忙碌
	private ImageIcon btn_user_busy_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/btn_busy.png");
	//用户状态按钮-隐身
	private ImageIcon btn_user_mute_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/btn_mute.png");
	//用户状态按钮-Q我吧
	private ImageIcon btn_user_qme_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/btn_qme.png");
	//用户状态按钮-在线
	private ImageIcon btn_user_imonline_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/btn_imonline.png");
	//用户状态按钮-离线
	private ImageIcon btn_user_imoffline_statusIcon = ImageManageUtils.getImageIcon("images/frame/main/status/btn_imoffline.png");
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

	//颜色绿
	private Color GREEN = new Color(154,205,50);
	//字体
	private Font FONT_12_BOLD = new Font("微软雅黑", 1, 12);
	private Font FONT_12_NOBOLD = new Font("微软雅黑", 0, 12);
	
	public Main(){
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
	    String[] items = {"我在线上", "Q我吧", "离开", "忙碌", "请勿打扰", "隐身", "离线"};  
        
	    //下拉菜单-我在线上
        imonlineItem = new JMenuItem(items[0], user_imonline_statusIcon);  
        imonlineItem.setFont(FONT_12_NOBOLD);
        imonlineItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(btn_user_imonline_statusIcon);
            }  
        }); 
        
        //下拉菜单-Q我吧
        qMeItem = new JMenuItem(items[1], user_qme_statusIcon);  
        qMeItem.setFont(FONT_12_NOBOLD);
        qMeItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(btn_user_qme_statusIcon);
            }  
        });  

        //下拉菜单-离开
        awayItem = new JMenuItem(items[2], user_away_statusIcon);  
        awayItem.setFont(FONT_12_NOBOLD);
        awayItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(btn_user_away_statusIcon);
            }  
        }); 

        //下拉菜单-忙碌
        busyItem = new JMenuItem(items[3], user_busy_statusIcon);  
        busyItem.setFont(FONT_12_NOBOLD);
        busyItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(btn_user_busy_statusIcon);
            }  
        }); 

        //下拉菜单-请勿打扰
        muteItem = new JMenuItem(items[4], user_mute_statusIcon);  
        muteItem.setFont(FONT_12_NOBOLD);
        muteItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(btn_user_mute_statusIcon);
            }  
        }); 

        //下拉菜单-隐身
        invisibleItem = new JMenuItem(items[5], user_invisible_statusIcon);  
        invisibleItem.setFont(FONT_12_NOBOLD);
        invisibleItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(btn_user_invisible_statusIcon);
            }  
        }); 

        //下拉菜单-离线
        imofflineItem = new JMenuItem(items[6], user_imoffline_statusIcon);  
        imofflineItem.setFont(FONT_12_NOBOLD);
        imofflineItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                btn_user_status.setIcon(btn_user_imoffline_statusIcon);
            }  
        }); 

        statusPopupMenu.add(imonlineItem);  
        statusPopupMenu.add(qMeItem);  
        statusPopupMenu.add(awayItem);  
        statusPopupMenu.add(busyItem);  
        statusPopupMenu.add(muteItem);  
        statusPopupMenu.add(invisibleItem);  
        statusPopupMenu.add(imofflineItem);  
		
		//设置用户状态边框
		user_stauts_hightlight_border = new JLabel(user_border_statusIcon);
		user_stauts_hightlight_border.setBorder(null);
		user_stauts_hightlight_border.setBounds(75, 34, 36, 22);
		user_stauts_hightlight_border.setVisible(false);
        
        //设置用户状态
		btn_user_status = new JButton();
		btn_user_status.setBounds(78, 39, 30, 11);
		btn_user_status.setIcon(btn_user_imonline_statusIcon);
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
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
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
