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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.tree.TreePath;

import com.im.client.component.NewScrollBarUI;
import com.im.client.component.NewTabbedPane;
import com.im.client.component.NewTreeIconNodeRenderer;
import com.im.client.component.NewTreeUI;
import com.im.client.utils.ImageManageUtils;
import com.im.client.utils.ScreenSizeUtils;
import com.im.client.utils.WeatherUtils;
import com.im.common.dto.IconTreeNode;
import com.sun.awt.AWTUtilities;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			2    
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
	private ImageIcon main_bg_Icon = ImageManageUtils.getImageIcon("images/background/common/main_bg_snail.jpg");
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
	private ImageIcon user_imageIcon = ImageManageUtils.getImageIcon("images/usericon/user_image/user_image.png");
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
	//mlive
	private ImageIcon btn_app_mliveIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_mlive_icon.png");
	//game
	private ImageIcon btn_app_gameIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_game_icon.png");
	//pet
	private ImageIcon btn_app_petIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_pet_icon.png");
	//music
	private ImageIcon btn_app_musicIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_music_icon.png");
	//live
	private ImageIcon btn_app_liveIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_live_icon.png");
	//团购
	private ImageIcon btn_app_group_purchaseIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_group_purchase_icon.png");
	//pcmgr
	private ImageIcon btn_app_pcmgrIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_pcmgr_icon.png");
	//ecommerce
	private ImageIcon btn_app_ecommerceIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_ecommerce_icon.png");
	//appboxmgr
	private ImageIcon btn_app_appbox_mgrIcon = ImageManageUtils.getImageIcon("images/frame/main/icon/btn_app_appbox_mgr_icon.png");
	//btn menu normal
	private ImageIcon btn_menu_normalIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/btn_menu_normal.png");
	//btn menu highlight
	private ImageIcon btn_menu_highlightIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/btn_menu_highlight.png");
	//menu菜单-所有服务
	private ImageIcon allservices_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_allservices_icon.png");
	//menu菜单-所有服务-腾讯网
	private ImageIcon tencent_SubMenuItemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/allservice/tencent_website_icon.png");
	//menu菜单-所有服务-空间
	private ImageIcon space_SubMenuItemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/allservice/space_icon.png");
	//menu菜单-所有服务-paipai
	private ImageIcon paipai_SubMenuItemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/allservice/paipai_icon.png");
	//menu菜单-所有服务-soso
	private ImageIcon soso_SubMenuItemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/allservice/soso_icon.png");
	//menu菜单-所有服务-充值
	private ImageIcon recharge_SubMenuItemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/allservice/recharge_icon.png");
	//menu菜单-所有服务-腾讯游戏
	private ImageIcon game_SubMenuItemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/allservice/tencent_game_icon.png");
	//menu菜单-所有服务-手机生活
	private ImageIcon mobilelife_SubMenuItemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/allservice/mobile_life_icon.png");
	//menu菜单-所有服务-财付通
	private ImageIcon tenpay_SubMenuItemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/allservice/tenpay_icon.png");
	//menu菜单-QQ会员
	private ImageIcon vip_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_vip_icon.png");
	//menu菜单-我的qq中心
	private ImageIcon mycenter_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_mycenter_icon.png");
	//menu菜单-工具
	private ImageIcon tools_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_tools_icon.png");
	//menu菜单-系统设置
	private ImageIcon systemSetting_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_system_setting_icon.png");
	//menu菜单-软件更新
	private ImageIcon softUpdate_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_soft_update_icon.png");
	//menu菜单-安全中心
	private ImageIcon securityCenter_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_safety_center_icon.png");
	//menu菜单-帮助中心
	private ImageIcon helpCenter_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_help_center_icon.png");
	//menu菜单-帮助中心-腾讯客服
	private ImageIcon customerService_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/help/customer_service.png");
	//menu菜单-帮助中心-反馈问题
	private ImageIcon feedback_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/help/feedback.png");
	//menu菜单-帮助中心-新特性
	private ImageIcon whats_new_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/help/whats_new.png");
	//menu菜单-帮助中心-I'm QQ.com
	private ImageIcon imqqcom_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/help/imqqcom.png");
	//menu菜单-帮助中心-官方微博
	private ImageIcon official_wblog_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/help/official_wblog.png");
	//menu菜单-帮助中心-关于
	private ImageIcon about_qq_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/help/about.png");
	//menu菜单-好友管理器
	private ImageIcon contactMgr_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_contact_mgr.png");
	//menu菜单-修改密码
	private ImageIcon changepswd_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_changepswd.png");
	//menu菜单-更改用户
	private ImageIcon changeuser_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_switch.png");
	//menu菜单-锁定QQ
	private ImageIcon lockqq_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_lock_qq.png");
	//menu菜单-退出
	private ImageIcon quite_itemIcon = ImageManageUtils.getImageIcon("images/frame/main/menu/main/menu_exit.png");
	//设置按钮
	private ImageIcon btn_setting_Icon = ImageManageUtils.getImageIcon("images/frame/main/menu/btn_setting.png");
	//消息管理
	private ImageIcon btn_message_Icon = ImageManageUtils.getImageIcon("images/frame/main/menu/btn_message.png");
	//安全概况
	private ImageIcon btn_security_Icon = ImageManageUtils.getImageIcon("images/frame/main/menu/btn_security.png");
	//圈子按钮
	private ImageIcon btn_circle_Icon = ImageManageUtils.getImageIcon("images/frame/main/menu/btn_circle.png");
	//查找按钮
	private ImageIcon btn_find_Icon = ImageManageUtils.getImageIcon("images/frame/main/menu/btn_find.png");

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
	private JScrollPane friends_scrollpane = null; 
	//定义好友列表根节点
	private IconTreeNode root = null; 
	//定义好友列表二级节点
	private IconTreeNode root1 = null;
	private IconTreeNode root2 = null;
	private IconTreeNode root3 = null;
	private IconTreeNode root4 = null;
	private IconTreeNode root5 = null;
	//定义好友列表节点渲染器
	private NewTreeIconNodeRenderer renderer = null;
	//定义树
	private JTree tree = null;
	//设置app背景
	private JLabel appbg = null;
	//设置mlive边框高亮
	private JLabel btn_app_mlive_border = null;
	//设置mlive按钮
	private JButton btn_app_mlive = null;
	//设置game边框高亮
	private JLabel btn_app_game_border = null;
	//设置game按钮
	private JButton btn_app_game = null;
	//设置pet边框高亮
	private JLabel btn_app_pet_border = null;
	//设置pet按钮
	private JButton btn_app_pet = null;
	//设置music边框高亮
	private JLabel btn_app_music_border = null;
	//设置music按钮
	private JButton btn_app_music = null;
	//设置live边框高亮
	private JLabel btn_app_live_border = null;
	//设置live按钮
	private JButton btn_app_live = null;
	//设置团购边框高亮
	private JLabel btn_app_group_purchase_border = null;
	//设置团购按钮
	private JButton btn_app_group_purchase = null;
	//设置pcmgr边框高亮
	private JLabel btn_app_pcmgr_border = null;
	//设置pcmgr按钮
	private JButton btn_app_pcmgr = null;
	//设置网购边框高亮
	private JLabel btn_app_ecommerce_border = null;
	//设置网购按钮
	private JButton btn_app_ecommerce = null;
	//设置appbox边框高亮
	private JLabel btn_app_appbox_mgr_border = null;
	//设置appbox按钮
	private JButton btn_app_appbox_mgr = null;
	//设置menu按钮边框
	private JLabel btn_menu_border = null;
	//设置menu按钮
	private JButton btn_menu = null;
	//设置menu菜单
	private JPopupMenu menuPopupMenu = null;
    //menu下拉菜单-所有服务-子菜单
    private JMenu allServiceSubMenu = null;
	//menu下拉菜单-QQ会员
    private JMenuItem vipMenuItem = null;
	//menu下拉菜单-我的QQ中心
    private JMenuItem myCenterMenuItem = null;
	//menu下拉菜单-工具
    private JMenuItem toolsMenuItem = null;
    //menu下拉菜单-系统设置-子菜单
    private JMenu systemSettingSubMenu = null;
	//menu下拉菜单-软件更新
    private JMenuItem softUpdateMenuItem = null;
    //menu下拉菜单-安全中心-子菜单
    private JMenu securityCenterSubMenu = null;
    //menu下拉菜单-帮助中心-子菜单
    private JMenu helpCenterSubMenu = null;
	//menu下拉菜单-好友管理器
    private JMenuItem contactMgrMenuItem = null;
	//menu下拉菜单-修改密码
    private JMenuItem changepswdMenuItem = null;
	//menu下拉菜单-更改用户
    private JMenuItem changeuserMenuItem = null;
	//menu下拉菜单-锁定QQ
    private JMenuItem lockQQMenuItem = null;
	//menu下拉菜单-退出
    private JMenuItem quiteMenuItem = null;
	//设置按钮边框
	private JLabel btn_setting_border = null;
	//设置按钮
	private JButton btn_setting = null;
	//设置message按钮边框
	private JLabel btn_message_border = null;
	//设置message按钮
	private JButton btn_message = null;
	//设置security按钮边框
	private JLabel btn_security_border = null;
	//设置security按钮
	private JButton btn_security = null;
	//设置圈子按钮边框
	private JLabel btn_circle_border = null;
	//设置圈子按钮
	private JButton btn_circle = null;
	//设置查找按钮边框
	private JLabel btn_find_border = null;
	//设置查找按钮
	private JButton btn_find = null;

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
		//设置背景颜色
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
                g.drawImage(main_bg_Icon.getImage(), (windowWidth-main_bg_Icon.getIconWidth()), 0, Main.this);
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
		nickName = new JLabel("飞翔de企鹅");
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

		//定义根节点
		root = new IconTreeNode(null, null);
		
		//好友列表 定义二级节点
		root1 = new IconTreeNode(null, "我的好友 [0/3]");
		root2 = new IconTreeNode(null, "我的家人 [5/8]");
		root3 = new IconTreeNode(null, "我的朋友 [6/11]");
		root4 = new IconTreeNode(null, "陌生人 [1/4]");
		root5 = new IconTreeNode(null, "黑名单 [0/0]");

		//二级节点添加叶子节点
		root1.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/1.png"), "雅君"));
		root1.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/2.png"), "伟旭"));
		root1.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/3.png"), "宜群"));

		root2.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/4.png"), "彬强"));
		root2.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/5.png"), "小强"));

		root3.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/4.png"), "彬强"));
		root3.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/5.png"), "小强"));

		root4.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/4.png"), "彬强"));
		root4.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/5.png"), "小强"));

		root5.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/4.png"), "彬强"));
		root5.add(new IconTreeNode(new ImageIcon("images/usericon/system_image/5.png"), "小强"));

		//根节点添加二级节点
		root.add(root1);
		root.add(root2);
		root.add(root3);
		root.add(root4);
		root.add(root5);
		
		//节点渲染器
		renderer = new NewTreeIconNodeRenderer();
		//定义树
		tree = new JTree(root);
		//设置单元格描述
		tree.setCellRenderer(renderer);
		tree.setUI(new NewTreeUI());
		//设置树是否可编辑
		tree.setEditable(false);
		//设置树的根节点是否可视
		tree.setRootVisible(false);
        //设置是否显示根节点的“展开/折叠”图标,默认是false   
		tree.setShowsRootHandles(false);   
		//设置单击几次展开数节点
		tree.setToggleClickCount(1);

		// 测试事件
		tree.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
			}

			public void mouseClicked(MouseEvent e) {
				// 双击节点
				if (e.getClickCount() == 2) {
					// 获取选中节点路径
					TreePath path = tree.getSelectionPath();
					// 通过路径将指针指向该节点
					IconTreeNode node = (IconTreeNode) path.getLastPathComponent();
					// 如果该节点是叶子节点
					if (node.isLeaf()){
						// DefaultTreeModel
						// model=(DefaultTreeModel)tree.getModel();//获取该树的模型
						// model.removeNodeFromParent(node);//从本树删除该节点
						
						//修改该节点的图片
						node.setIcon(new ImageIcon("3.png"));
						//修改该节点的文本
						node.setText("双击");
						//重绘更新树
						tree.repaint();
					} else {

					// 不是叶子节点
					}
				}
			}
		});

		//设置好友列表scrollpane
		friends_scrollpane = new JScrollPane(tree);
		friends_scrollpane.getVerticalScrollBar().setUI(new NewScrollBarUI());
		friends_scrollpane.setBorder(null);
		JScrollBar bar = friends_scrollpane.getVerticalScrollBar();
		bar.setBackground(new Color(255, 255, 255, 255));
		
		//设置选项卡
		main_tab = new JTabbedPane();
		main_tab.setUI(new NewTabbedPane());
		main_tab.addTab("", tab_contacts_normalIcon, friends_scrollpane, "联系人");
		main_tab.addTab("", tab_friends_normalIcon, new JLabel("This is tab two."), "朋友");
		main_tab.addTab("", tab_group_normalIcon, new JLabel("This is tab three."),"群/讨论组");
		main_tab.addTab("", tab_wblog_normalIcon, new JLabel("This is tab four."), "微博");
		main_tab.addTab("", tab_last_normalIcon, new JLabel("This is tab five."), "最近联系人");
		main_tab.setBounds(0, 126, 285, 400);
		
		//设置app背景
		appbg = new JLabel();
		appbg.setBackground(new Color(255, 255, 255, 160));
		appbg.setBounds(0, 520, 285, 70);
		appbg.setOpaque(true);
		
		//设置mlive边框高亮
		btn_app_mlive_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_mlive_border.setBorder(null);
		btn_app_mlive_border.setBounds(3, 533, 22, 22);
		btn_app_mlive_border.setVisible(false);
		
		//设置mlive按钮
		btn_app_mlive = new JButton();
		btn_app_mlive.setBounds(6, 536, 16, 16);
		btn_app_mlive.setIcon(btn_app_mliveIcon);
		btn_app_mlive.setBorderPainted(false);
		btn_app_mlive.setContentAreaFilled(false);
		btn_app_mlive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_mlive_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_mlive_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_mlive_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_mlive_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置game边框高亮
		btn_app_game_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_game_border.setBorder(null);
		btn_app_game_border.setBounds(33, 533, 22, 22);
		btn_app_game_border.setVisible(false);
		
		//设置game按钮
		btn_app_game = new JButton();
		btn_app_game.setBounds(36, 536, 16, 16);
		btn_app_game.setIcon(btn_app_gameIcon);
		btn_app_game.setBorderPainted(false);
		btn_app_game.setContentAreaFilled(false);
		btn_app_game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_game_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_game_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_game_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_game_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置pet边框高亮
		btn_app_pet_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_pet_border.setBorder(null);
		btn_app_pet_border.setBounds(63, 533, 22, 22);
		btn_app_pet_border.setVisible(false);
		
		//设置pet按钮
		btn_app_pet = new JButton();
		btn_app_pet.setBounds(66, 536, 16, 16);
		btn_app_pet.setIcon(btn_app_petIcon);
		btn_app_pet.setBorderPainted(false);
		btn_app_pet.setContentAreaFilled(false);
		btn_app_pet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_pet_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_pet_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_pet_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_pet_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置music边框高亮
		btn_app_music_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_music_border.setBorder(null);
		btn_app_music_border.setBounds(93, 533, 22, 22);
		btn_app_music_border.setVisible(false);
		
		//设置music按钮
		btn_app_music = new JButton();
		btn_app_music.setBounds(96, 536, 16, 16);
		btn_app_music.setIcon(btn_app_musicIcon);
		btn_app_music.setBorderPainted(false);
		btn_app_music.setContentAreaFilled(false);
		btn_app_music.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_music_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_music_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_music_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_music_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置live边框高亮
		btn_app_live_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_live_border.setBorder(null);
		btn_app_live_border.setBounds(123, 533, 22, 22);
		btn_app_live_border.setVisible(false);
		
		//设置live按钮
		btn_app_live = new JButton();
		btn_app_live.setBounds(126, 536, 16, 16);
		btn_app_live.setIcon(btn_app_liveIcon);
		btn_app_live.setBorderPainted(false);
		btn_app_live.setContentAreaFilled(false);
		btn_app_live.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_live_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_live_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_live_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_live_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置团购边框高亮
		btn_app_group_purchase_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_group_purchase_border.setBorder(null);
		btn_app_group_purchase_border.setBounds(153, 533, 22, 22);
		btn_app_group_purchase_border.setVisible(false);
		
		//设置团购按钮
		btn_app_group_purchase = new JButton();
		btn_app_group_purchase.setBounds(156, 536, 16, 16);
		btn_app_group_purchase.setIcon(btn_app_group_purchaseIcon);
		btn_app_group_purchase.setBorderPainted(false);
		btn_app_group_purchase.setContentAreaFilled(false);
		btn_app_group_purchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_group_purchase_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_group_purchase_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_group_purchase_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_group_purchase_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置pcmgr边框高亮
		btn_app_pcmgr_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_pcmgr_border.setBorder(null);
		btn_app_pcmgr_border.setBounds(183, 533, 22, 22);
		btn_app_pcmgr_border.setVisible(false);
		
		//设置pcmgr按钮
		btn_app_pcmgr = new JButton();
		btn_app_pcmgr.setBounds(186, 536, 16, 16);
		btn_app_pcmgr.setIcon(btn_app_pcmgrIcon);
		btn_app_pcmgr.setBorderPainted(false);
		btn_app_pcmgr.setContentAreaFilled(false);
		btn_app_pcmgr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_pcmgr_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_pcmgr_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_pcmgr_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_pcmgr_border.setIcon(btn_icon_broder_pressIcon);
			}
		});

		//设置网购边框高亮
		btn_app_ecommerce_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_ecommerce_border.setBorder(null);
		btn_app_ecommerce_border.setBounds(213, 533, 22, 22);
		btn_app_ecommerce_border.setVisible(false);
		
		//设置网购按钮
		btn_app_ecommerce = new JButton();
		btn_app_ecommerce.setBounds(216, 536, 16, 16);
		btn_app_ecommerce.setIcon(btn_app_ecommerceIcon);
		btn_app_ecommerce.setBorderPainted(false);
		btn_app_ecommerce.setContentAreaFilled(false);
		btn_app_ecommerce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_ecommerce_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_ecommerce_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_ecommerce_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_ecommerce_border.setIcon(btn_icon_broder_pressIcon);
			}
		});

		//设置appbox边框高亮
		btn_app_appbox_mgr_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_app_appbox_mgr_border.setBorder(null);
		btn_app_appbox_mgr_border.setBounds(259, 533, 22, 22);
		btn_app_appbox_mgr_border.setVisible(false);
		
		//设置appbox按钮
		btn_app_appbox_mgr = new JButton();
		btn_app_appbox_mgr.setBounds(262, 536, 16, 16);
		btn_app_appbox_mgr.setIcon(btn_app_appbox_mgrIcon);
		btn_app_appbox_mgr.setBorderPainted(false);
		btn_app_appbox_mgr.setContentAreaFilled(false);
		btn_app_appbox_mgr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_app_appbox_mgr_border.setIcon(btn_icon_broder_highlightIcon);
				btn_app_appbox_mgr_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_app_appbox_mgr_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_appbox_mgr_border.setIcon(btn_icon_broder_pressIcon);
			}
		});

		//设置menu菜单
		menuPopupMenu = new JPopupMenu("MenuPopupMenu"); 
	    String[] menuItems = {"所有服务", "QQ会员", "我的QQ中心", "工具", "系统设置", 
	    		"软件升级", "安全中心", "帮助", "好友管理器", "修改密码", "更改用户", "锁定QQ", "退出"};  

        //menu下拉菜单-所有服务-子菜单
        allServiceSubMenu = new JMenu(menuItems[0]);
        allServiceSubMenu.setIcon(allservices_itemIcon);
        allServiceSubMenu.setFont(FONT_12_NOBOLD);
        String[] allServiceSubMenuItem = {"腾讯网", "QQ空间", "拍拍购物", "SOSO搜索", 
        		"QQ充值", "腾讯游戏", "手机生活", "新闻资讯", "财付通"};
        //腾讯网
        JMenuItem tencentSubMenuItem = new JMenuItem(allServiceSubMenuItem[0], tencent_SubMenuItemIcon);
        tencentSubMenuItem.setFont(FONT_12_NOBOLD);
        //QQ空间
        JMenuItem spaceSubMenuItem = new JMenuItem(allServiceSubMenuItem[1], space_SubMenuItemIcon);
        spaceSubMenuItem.setFont(FONT_12_NOBOLD);
        //拍拍购物
        JMenuItem paipaiSubMenuItem = new JMenuItem(allServiceSubMenuItem[2], paipai_SubMenuItemIcon);
        paipaiSubMenuItem.setFont(FONT_12_NOBOLD);
        //SOSO搜索
        JMenuItem sosoSubMenuItem = new JMenuItem(allServiceSubMenuItem[3], soso_SubMenuItemIcon);
        sosoSubMenuItem.setFont(FONT_12_NOBOLD);
        //QQ充值
        JMenuItem rechargeSubMenuItem = new JMenuItem(allServiceSubMenuItem[4], recharge_SubMenuItemIcon);
        rechargeSubMenuItem.setFont(FONT_12_NOBOLD);
        //腾讯游戏
        JMenuItem tencentGameSubMenuItem = new JMenuItem(allServiceSubMenuItem[5], game_SubMenuItemIcon);
        tencentGameSubMenuItem.setFont(FONT_12_NOBOLD);
        //手机生活
        JMenuItem mobileLifeSubMenuItem = new JMenuItem(allServiceSubMenuItem[6], mobilelife_SubMenuItemIcon);
        mobileLifeSubMenuItem.setFont(FONT_12_NOBOLD);
        //新闻资讯
        JMenuItem newsSubMenuItem = new JMenuItem(allServiceSubMenuItem[7], tencent_SubMenuItemIcon);
        newsSubMenuItem.setFont(FONT_12_NOBOLD);
        //财付通
        JMenuItem tenpaySubMenuItem = new JMenuItem(allServiceSubMenuItem[8], tenpay_SubMenuItemIcon);
        tenpaySubMenuItem.setFont(FONT_12_NOBOLD);
        //所有服务下拉菜单添加条目
        allServiceSubMenu.add(tencentSubMenuItem);
        allServiceSubMenu.add(spaceSubMenuItem);
        allServiceSubMenu.add(paipaiSubMenuItem);
        allServiceSubMenu.add(sosoSubMenuItem);
        allServiceSubMenu.addSeparator(); 
        allServiceSubMenu.add(rechargeSubMenuItem);
        allServiceSubMenu.add(tencentGameSubMenuItem);
        allServiceSubMenu.add(mobileLifeSubMenuItem);
        allServiceSubMenu.add(newsSubMenuItem);
        allServiceSubMenu.add(tenpaySubMenuItem);
        
	    //menu下拉菜单-QQ会员
        vipMenuItem = new JMenuItem(menuItems[1], vip_itemIcon);  
        vipMenuItem.setFont(FONT_12_NOBOLD);
        vipMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 
        
	    //menu下拉菜单-我的QQ中心
        myCenterMenuItem = new JMenuItem(menuItems[2], mycenter_itemIcon);  
        myCenterMenuItem.setFont(FONT_12_NOBOLD);
        myCenterMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 
        
	    //menu下拉菜单-工具
        toolsMenuItem = new JMenuItem(menuItems[3], tools_itemIcon);  
        toolsMenuItem.setFont(FONT_12_NOBOLD);
        toolsMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 
        
	    //menu下拉菜单-系统设置
        systemSettingSubMenu = new JMenu(menuItems[4]);
        systemSettingSubMenu.setIcon(systemSetting_itemIcon);
        systemSettingSubMenu.setFont(FONT_12_NOBOLD);
        String[] systemSettingSubMenuItem = {"个人资料", "基本设置", "安全设置", "隐私设置"};
        //个人资料
        JMenuItem userInfoSubMenuItem = new JMenuItem(systemSettingSubMenuItem[0]);
        userInfoSubMenuItem.setFont(FONT_12_NOBOLD);
        //基本设置
        JMenuItem basicSettingSubMenuItem = new JMenuItem(systemSettingSubMenuItem[1]);
        basicSettingSubMenuItem.setFont(FONT_12_NOBOLD);
        //安全设置
        JMenuItem securitySettingSubMenuItem = new JMenuItem(systemSettingSubMenuItem[2]);
        securitySettingSubMenuItem.setFont(FONT_12_NOBOLD);
        //隐私设置
        JMenuItem privacySettingSubMenuItem = new JMenuItem(systemSettingSubMenuItem[3]);
        privacySettingSubMenuItem.setFont(FONT_12_NOBOLD);
        //系统设置下拉菜单添加条目
        systemSettingSubMenu.add(userInfoSubMenuItem);
        systemSettingSubMenu.add(basicSettingSubMenuItem);
        systemSettingSubMenu.add(securitySettingSubMenuItem);
        systemSettingSubMenu.add(privacySettingSubMenuItem);
        
	    //menu下拉菜单-软件升级
        softUpdateMenuItem = new JMenuItem(menuItems[5], softUpdate_itemIcon);  
        softUpdateMenuItem.setFont(FONT_12_NOBOLD);
        softUpdateMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 

	    //menu下拉菜单-安全中心
        securityCenterSubMenu = new JMenu(menuItems[6]);
        securityCenterSubMenu.setIcon(securityCenter_itemIcon);
        securityCenterSubMenu.setFont(FONT_12_NOBOLD);
        String[] securityCenterSubMenuItem = {"安全沟通", "安全中心首页", "申请密码保护", 
        		"举报恶意行为", "QQ安全帮助"};
        //安全沟通
        JMenuItem securityCommunication = new JMenuItem(securityCenterSubMenuItem[0]);
        securityCommunication.setIcon(securityCenter_itemIcon);
        securityCommunication.setFont(FONT_12_NOBOLD);
        //安全中心首页
        JMenuItem securityCenterIndex = new JMenuItem(securityCenterSubMenuItem[1]);
        securityCenterIndex.setFont(FONT_12_NOBOLD);
        //申请密码保护
        JMenuItem applyPasswordProtected = new JMenuItem(securityCenterSubMenuItem[2]);
        applyPasswordProtected.setFont(FONT_12_NOBOLD);
        //举报恶意行为
        JMenuItem reportMaliciousAct = new JMenuItem(securityCenterSubMenuItem[3]);
        reportMaliciousAct.setFont(FONT_12_NOBOLD);
        //QQ安全帮助
        JMenuItem securityHelp = new JMenuItem(securityCenterSubMenuItem[4]);
        securityHelp.setFont(FONT_12_NOBOLD);
        //安全中下拉菜单添加条目
        securityCenterSubMenu.add(securityCommunication);
        securityCenterSubMenu.add(securityCenterIndex);
        securityCenterSubMenu.add(applyPasswordProtected);
        securityCenterSubMenu.add(reportMaliciousAct);
        securityCenterSubMenu.add(securityHelp);

	    //menu下拉菜单-帮助中心
        helpCenterSubMenu = new JMenu(menuItems[7]);
        helpCenterSubMenu.setIcon(helpCenter_itemIcon);
        helpCenterSubMenu.setFont(FONT_12_NOBOLD);
        String[] helpCenterSubMenuItem = {"使用帮助", "腾讯客服", "反馈问题", 
        		"QQ新特性", "I'm QQ官网", "QQ官方微博", "关于QQ2013"};
        //使用帮助
        JMenuItem userHelp = new JMenuItem(helpCenterSubMenuItem[0]);
        userHelp.setIcon(helpCenter_itemIcon);
        userHelp.setFont(FONT_12_NOBOLD);
        //腾讯客服
        JMenuItem customerService = new JMenuItem(helpCenterSubMenuItem[1]);
        customerService.setIcon(customerService_itemIcon);
        customerService.setFont(FONT_12_NOBOLD);
        //反馈问题
        JMenuItem feedback = new JMenuItem(helpCenterSubMenuItem[2]);
        feedback.setIcon(feedback_itemIcon);
        feedback.setFont(FONT_12_NOBOLD);
        //QQ新特性
        JMenuItem whats_new = new JMenuItem(helpCenterSubMenuItem[3]);
        whats_new.setIcon(whats_new_itemIcon);
        whats_new.setFont(FONT_12_NOBOLD);
        //I'm QQ官网
        JMenuItem imqqcom = new JMenuItem(helpCenterSubMenuItem[4]);
        imqqcom.setIcon(imqqcom_itemIcon);
        imqqcom.setFont(FONT_12_NOBOLD);
        //QQ官方微博
        JMenuItem official_wblog = new JMenuItem(helpCenterSubMenuItem[5]);
        official_wblog.setIcon(official_wblog_itemIcon);
        official_wblog.setFont(FONT_12_NOBOLD);
        //关于QQ2013
        JMenuItem about_qq = new JMenuItem(helpCenterSubMenuItem[6]);
        about_qq.setIcon(about_qq_itemIcon);
        about_qq.setFont(FONT_12_NOBOLD);
        //帮助中心中下拉菜单添加条目
        helpCenterSubMenu.add(userHelp);
        helpCenterSubMenu.add(customerService);
        helpCenterSubMenu.add(feedback);
        helpCenterSubMenu.addSeparator();  
        helpCenterSubMenu.add(whats_new);
        helpCenterSubMenu.addSeparator();  
        helpCenterSubMenu.add(imqqcom);
        helpCenterSubMenu.add(official_wblog);
        helpCenterSubMenu.add(about_qq);
        
	    //menu下拉菜单-好友管理
        contactMgrMenuItem = new JMenuItem(menuItems[8], contactMgr_itemIcon);  
        contactMgrMenuItem.setFont(FONT_12_NOBOLD);
        contactMgrMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 

	    //menu下拉菜单-修改密码
        changepswdMenuItem = new JMenuItem(menuItems[9], changepswd_itemIcon);  
        changepswdMenuItem.setFont(FONT_12_NOBOLD);
        changepswdMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 
        
	    //menu下拉菜单-更改用户
        changeuserMenuItem = new JMenuItem(menuItems[10], changeuser_itemIcon);  
        changeuserMenuItem.setFont(FONT_12_NOBOLD);
        changeuserMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 
        
	    //menu下拉菜单-锁定QQ
        lockQQMenuItem = new JMenuItem(menuItems[11], lockqq_itemIcon);  
        lockQQMenuItem.setFont(FONT_12_NOBOLD);
        lockQQMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 
        
	    //menu下拉菜单-退出
        quiteMenuItem = new JMenuItem(menuItems[12], quite_itemIcon);  
        quiteMenuItem.setFont(FONT_12_NOBOLD);
        quiteMenuItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  

            }  
        }); 
        
        //menu下拉菜单添加条目
        menuPopupMenu.add(allServiceSubMenu); 
        menuPopupMenu.add(vipMenuItem);  
        menuPopupMenu.add(myCenterMenuItem);  
        menuPopupMenu.addSeparator(); 
        menuPopupMenu.add(toolsMenuItem);  
        menuPopupMenu.add(systemSettingSubMenu);  
        menuPopupMenu.add(softUpdateMenuItem);  
        menuPopupMenu.addSeparator();  
        menuPopupMenu.add(securityCenterSubMenu);  
        menuPopupMenu.add(helpCenterSubMenu);  
        menuPopupMenu.addSeparator();  
        menuPopupMenu.add(contactMgrMenuItem);  
        menuPopupMenu.add(changepswdMenuItem); 
        menuPopupMenu.add(changeuserMenuItem);  
        menuPopupMenu.add(lockQQMenuItem);  
        menuPopupMenu.add(quiteMenuItem);  
		
		//设置menu按钮边框高亮
		btn_menu_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_menu_border.setBorder(null);
		btn_menu_border.setBounds(3, 563, 22, 22);
		btn_menu_border.setVisible(false);
		
		//设置menu按钮按钮
		btn_menu = new JButton();
		btn_menu.setBounds(6, 566, 16, 16);
		btn_menu.setIcon(btn_menu_normalIcon);
		btn_menu.setBorderPainted(false);
		btn_menu.setContentAreaFilled(false);
		btn_menu.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(menuPopupMenu.getSubElements().length != 0) {  
                	//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
                	menuPopupMenu.show(Main.this, 3, 226);  
                    //请求此 Component 获取输入焦点
                	menuPopupMenu.requestFocus();  
                }  
            }  
        });  
		btn_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_menu_border.setIcon(btn_icon_broder_highlightIcon);
				btn_menu_border.setVisible(false);
				btn_menu.setIcon(btn_menu_normalIcon);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_menu_border.setVisible(true);
				btn_menu.setIcon(btn_menu_highlightIcon);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_menu_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置setting按钮边框高亮
		btn_setting_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_setting_border.setBorder(null);
		btn_setting_border.setBounds(33, 563, 22, 22);
		btn_setting_border.setVisible(false);
		
		//设置setting按钮按钮
		btn_setting = new JButton();
		btn_setting.setBounds(36, 566, 16, 16);
		btn_setting.setIcon(btn_setting_Icon);
		btn_setting.setBorderPainted(false);
		btn_setting.setContentAreaFilled(false);
		btn_setting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_setting_border.setIcon(btn_icon_broder_highlightIcon);
				btn_setting_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_setting_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_setting_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置message按钮边框高亮
		btn_message_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_message_border.setBorder(null);
		btn_message_border.setBounds(63, 563, 22, 22);
		btn_message_border.setVisible(false);
		
		//设置message按钮按钮
		btn_message = new JButton();
		btn_message.setBounds(66, 566, 16, 16);
		btn_message.setIcon(btn_message_Icon);
		btn_message.setBorderPainted(false);
		btn_message.setContentAreaFilled(false);
		btn_message.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_message_border.setIcon(btn_icon_broder_highlightIcon);
				btn_message_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_message_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_message_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置security按钮边框高亮
		btn_security_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_security_border.setBorder(null);
		btn_security_border.setBounds(93, 563, 22, 22);
		btn_security_border.setVisible(false);
		
		//设置security按钮按钮
		btn_security = new JButton();
		btn_security.setBounds(96, 566, 16, 16);
		btn_security.setIcon(btn_security_Icon);
		btn_security.setBorderPainted(false);
		btn_security.setContentAreaFilled(false);
		btn_security.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_security_border.setIcon(btn_icon_broder_highlightIcon);
				btn_security_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_security_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_security_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置圈子按钮边框高亮
		btn_circle_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_circle_border.setBorder(null);
		btn_circle_border.setBounds(123, 563, 22, 22);
		btn_circle_border.setVisible(false);
		
		//设置圈子按钮
		btn_circle = new JButton();
		btn_circle.setBounds(126, 566, 16, 16);
		btn_circle.setIcon(btn_circle_Icon);
		btn_circle.setHorizontalTextPosition(SwingConstants.RIGHT);
		btn_circle.setBorderPainted(false);
		btn_circle.setContentAreaFilled(false);
		btn_circle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_circle_border.setIcon(btn_icon_broder_highlightIcon);
				btn_circle_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_circle_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_circle_border.setIcon(btn_icon_broder_pressIcon);
			}
		});
		
		//设置查找按钮边框高亮
		btn_find_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_find_border.setBorder(null);
		btn_find_border.setBounds(153, 563, 22, 22);
		btn_find_border.setVisible(false);
		
		//设置查找按钮
		btn_find = new JButton();
		btn_find.setBounds(156, 566, 16, 16);
		btn_find.setIcon(btn_find_Icon);
		btn_find.setBorderPainted(false);
		btn_find.setContentAreaFilled(false);
		btn_find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("1");
				btn_find_border.setIcon(btn_icon_broder_highlightIcon);
				btn_find_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("2");
				btn_find_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_find_border.setIcon(btn_icon_broder_pressIcon);
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
		this.add(btn_app_mlive);
		this.add(btn_app_mlive_border);
		this.add(btn_app_game);
		this.add(btn_app_game_border);
		this.add(btn_app_pet);
		this.add(btn_app_pet_border);
		this.add(btn_app_music);
		this.add(btn_app_music_border);
		this.add(btn_app_live);
		this.add(btn_app_live_border);
		this.add(btn_app_group_purchase);
		this.add(btn_app_group_purchase_border);
		this.add(btn_app_pcmgr);
		this.add(btn_app_pcmgr_border);
		this.add(btn_app_ecommerce);
		this.add(btn_app_ecommerce_border);
		this.add(btn_app_appbox_mgr);
		this.add(btn_app_appbox_mgr_border);
		this.add(btn_menu);
		this.add(btn_menu_border);
		this.add(btn_setting);
		this.add(btn_setting_border);
		this.add(btn_message);
		this.add(btn_message_border);
		this.add(btn_security);
		this.add(btn_security_border);
		this.add(btn_circle);
		this.add(btn_circle_border);
		this.add(btn_find);
		this.add(btn_find_border);
		
		this.add(appbg);
		
		//添加界面拖拽移动监听器
		this.addMouseListener(moveWindowListener);
		this.addMouseMotionListener(moveWindowListener); 
	}
	
	//边框
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Color color = new Color(192, 192, 192);
		g.setColor(color);
		g.drawLine(2, 589, 283, 589);
		g.drawLine(284, 2, 284, 588);
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
