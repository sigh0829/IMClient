package com.im.client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.im.client.component.NewScrollBarUI;
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
	private ImageIcon main_bg_Icon = ImageManageUtils.getImageIcon("images/background/common/main_bg_snail.jpg");
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
	//menu大边框
	private ImageIcon menu_border_large_icon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_border_large_icon.png");
	//menu大边框点击
	private ImageIcon menu_border_large_press_icon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_border_large_press_icon.png");
	//menu边框
	private ImageIcon menu_border_icon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_border_icon.png");
	//menu边框点击
	private ImageIcon menu_border_press_icon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_border_press_icon.png");
	//视频通话
	private ImageIcon menu_videoIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_video_icon.png");
	//视频通话 -开始视频会话
	private ImageIcon start_videoIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/video/start_video_icon.png");
	//视频通话 -发送视频消息会话
	private ImageIcon send_video_messageIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/video/send_video_message_icon.png");
	//语音通话
	private ImageIcon menu_audioIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_audio_icon.png");
	//文件传输
	private ImageIcon menu_file_transferIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_file_transfer_icon.png");
	//创建讨论组
	private ImageIcon menu_create_groupIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_create_group_icon.png");
	//远程协助
	private ImageIcon menu_remote_helpIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_remote_help_icon.png");
	//应用
	private ImageIcon menu_appIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/menu_app_icon.png");
	//应用 - 发送短信
	private ImageIcon send_SMSIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/send_sms_icon.png");
	//应用 - 发送邮件
	private ImageIcon send_emailIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/send_email_icon.png");
	//应用 - 手机免费聊qq
	private ImageIcon mobile_chatIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/mobile_chat_icon.png");
	//应用 - search
	private ImageIcon searchIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/search_icon.png");
	//应用 - 腾讯视频
	private ImageIcon tencent_liveIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/tencent_live_icon.png");
	//应用 - 财付通
	private ImageIcon tenpayIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/tenpay_icon.png");
	//应用 - 风尚
	private ImageIcon styleIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/style_icon.png");
	//应用 - 给他推荐好友
	private ImageIcon contact_recommendIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/contact_recommend_icon.png");
	//应用 - 删除好友
	private ImageIcon delete_friendIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/delete_friend_icon.png");
	//应用 - 移至黑名单
	private ImageIcon move_to_black_listIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/move_to_black_list_icon.png");
	//应用 - 举报
	private ImageIcon reportIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/report_icon.png");
	//应用 - 等级PK
	private ImageIcon levelPKIcon = ImageManageUtils.getImageIcon("images/frame/chat/icon/menu/app/level_pk_icon.png");
	//消息面板提示
	private ImageIcon tipInfoIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/tip_info_icon.png");
	//消息面板-字体选择
	private ImageIcon btn_font_chooseIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_font.png");
	//消息面板-字体选择工具栏
	private ImageIcon btn_windows_default_fontIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_sysfont_tab_button.png");
	//字体选择工具栏-加粗
	private ImageIcon btn_font_boldIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/midtoolbarextup_font/bold.png");
	//字体选择工具栏-倾斜
	private ImageIcon btn_font_italicIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/midtoolbarextup_font/italic.png");
	//字体选择工具栏-下划线
	private ImageIcon btn_font_underlineIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/midtoolbarextup_font/underline.png");
	//字体选择工具栏-	颜色
	private ImageIcon btn_font_colorIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/midtoolbarextup_font/color.png");
	//表情
	private ImageIcon btn_faceIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_face.png");
	//魔法表情
	private ImageIcon btn_magic_faceIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_magic_face.png");
	//窗口抖动
	private ImageIcon btn_window_shakeIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_window_shake.png");
	//辅助输入
	private ImageIcon btn_input_assistIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_input_assist.png");
	//分隔符
	private ImageIcon cutlineIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_cutline.png");
	//发送图片
	private ImageIcon btn_send_pictureIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_send_picture.png");
	//截图
	private ImageIcon btn_cut_pictureIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_cut.png");
	//更多应用
	private ImageIcon btn_moreIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_more.png");
	//消息记录
	private ImageIcon btn_message_recordIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/aio_quickbar_message_record.png");
	//消息记录边框
	private ImageIcon btn_msgrecord_broderIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/btn_msgrecord_broder.png");
	//关闭按钮
	private ImageIcon btn_chat_close_normalIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_close_normal.png");
	//关闭按钮高亮
	private ImageIcon btn_chat_close_hoverIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_close_highlight.png");
	//关闭按钮被点击
	private ImageIcon btn_chat_close_pressIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_close_focus.png");
	//发送left按钮
	private ImageIcon btn_send_left_normalIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_left_normal.png");
	//发送left按钮高亮
	private ImageIcon btn_send_left_hoverIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_left_focus_normal.png");
	//发送left按钮被点击
	private ImageIcon btn_send_left_pressIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_left_focus_down.png");
	//发送right按钮
	private ImageIcon btn_send_right_normalIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_right_normal.png");
	//发送right按钮高亮
	private ImageIcon btn_send_right_hoverIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_right_focus_normal.png");
	//发送right按钮被点击
	private ImageIcon btn_send_right_pressIcon = ImageManageUtils.getImageIcon("images/frame/chat/message/toolbar/bottombtn/btn_right_focus_down.png");
	
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
	//设置video边框高亮
	private JLabel btn_video_border = null; 
	//设置video按钮
	private JButton btn_video = null;
	//设置audio边框高亮
	private JLabel btn_audio_border = null; 
	//设置audio按钮
	private JButton btn_audio = null;
	//设置file_transfer边框高亮
	private JLabel btn_file_transfer_border = null; 
	//设置file_transfer按钮
	private JButton btn_file_transfer = null;
	//设置create_group边框高亮
	private JLabel btn_create_group_border = null; 
	//设置create_group按钮
	private JButton btn_create_group = null;
	//设置remote_help边框高亮
	private JLabel btn_remote_help_border = null; 
	//设置remote_help按钮
	private JButton btn_remote_help = null;
	//设置app边框高亮
	private JLabel btn_app_border = null; 
	//设置app按钮
	private JButton btn_app = null;
	//设置video菜单
	private JPopupMenu videoPopupMenu = null;
    //video菜单 - 开始视频会话
    private JMenuItem startVideoItem = null;
    //video - 邀请多人视频会话
    private JMenuItem inviteVideoItem = null;
    //video - 发送视频留言
    private JMenuItem sendVideoMsgItem = null;
    //video - 给对方播放影音文件
    private JMenuItem playVideoFileItem = null;
    //video - 视频设置
    private JMenuItem videoSettingItem = null;
    //video - 语音测试向导
    private JMenuItem videoAudioTestingGuideItem = null;
	//设置audio菜单
    private JPopupMenu audioPopupMenu = null; 
    //audio - 开始语音会话
    private JMenuItem startAudioItem = null;
    //audio - 发起多人语音
    private JMenuItem inviteAudioItem = null;
    //audio - 语音设置
    private JMenuItem audioSettingItem = null;
    //audio - 语音测试向导
    private JMenuItem audioTestingGuideItem = null;
    //audio - 发送语音消息
    private JMenuItem sendAudioMessageItem = null;
	//设置文件传输菜单
    private JPopupMenu fileTransferPopupMenu = null;
    //文件传输 - 发送文件
    private JMenuItem sendFileItem = null;
    //文件传输 - 发送文件夹
    private JMenuItem sendFileDirectoryItem = null;
    //文件传输 - 发送离线文件
    private JMenuItem sendOffLineFileItem = null;
    //文件传输 - 发送文件设置
    private JMenuItem sendFileSettingItem = null;
	//设置应用菜单
    private JPopupMenu appPopupMenu = null;
    //应用 - 发送短信
    private JMenuItem sendSMSItem = null;
    //应用 - 发送邮件
    private JMenuItem sendEmailItem = null;
    //应用 - 手机免费聊QQ
    private JMenuItem mobileChatItem = null;
    //应用 - search
    private JMenuItem searchItem = null;
    //应用 - live
    private JMenuItem tencentLiveItem = null;
    //应用 - 财付通
    private JMenuItem tenpayItem = null;
    //应用 - 风尚
    private JMenuItem styleItem = null;
    //应用 - 给他推荐好友
    private JMenuItem contactRecommendItem = null;
    //应用 - 删除好友
    private JMenuItem deleteFriendItem = null;
    //应用 - 移至黑名单
    private JMenuItem moveToBlackListItem = null;
    //应用 - 举报
    private JMenuItem reportItem = null;
    //应用 - 等级PK
    private JMenuItem levelPKItem = null;
    //聊天界面中心面板
    private JPanel chatPanel = null;
	//聊天界面消息内容面板
    private JPanel msgContentPanel = null;
	//聊天界面输入面板
    private JPanel msgInputPanel = null;
    //聊天界面消息内容面板提示label
	private JLabel msgTip = null;
	//聊天消息
	private JTextArea msgContentTextArea = null;
	//消息多行文本滚动条
	private JScrollPane msgContentScrollPane = null;
	//消息输入顶部工具栏
	private JPanel msgInputTopToolBarPanel = null;
	//消息输入顶部工具栏中心Panel
	private JPanel msgInputTopToolBarCenterPanel = null;
	//消息输入顶部工具栏底部panel
	private JPanel msgInputTopToolBarSouthPanel = null;
	//设置字体选择工具按钮
	private JButton btn_font_choose = null;
	//字体设置是否可见
	private boolean visibleFlag = false;
	//消息输入多行文本
	private JTextArea msgInputTextArea = null;
	//消息输入底部工具栏面板
	private JPanel msgInputBottomToolBarPanel = null;
	//文字按钮是否显示按钮边框
	private boolean borderFlag = false;
	private int buttonClickCount = 0;
	//字体选择工具栏
	private JButton btn_windows_default_font = null;
	//布局管理器
	private FlowLayout flowLayout = null;
	//字体选择工具栏-字体下拉列表
	private JComboBox<String> fontComboBox = null;
	//字体选择工具栏-字体大小下拉列表
	private JComboBox<Integer> fontSizeComboBox = null;
	//设置字体加粗按钮
	private JButton btn_font_bold = null;
	//加粗按钮是否显示按钮边框
	private boolean fontBoldFlag = false;
	private int fontBoldClickCount = 0;
	//设置字体倾斜按钮
	private JButton btn_font_italic = null;
	//倾斜按钮是否显示按钮边框
	private boolean fontItalicFlag = false;
	private int fontItalicClickCount = 0;
	//设置字体下划线按钮
	private JButton btn_font_underline = null;
	//下划线按钮是否显示按钮边框
	private boolean fontUnderlineFlag = false;
	private int fontUnderlineClickCount = 0;
	//设置字体颜色按钮
	private JButton btn_font_color = null;
	//设置字体选择工具边框高亮
	private JLabel btn_font_choose_border = null;
	//设置表情按钮
	private JButton btn_face = null;
	//设置表情边框高亮
	private JLabel btn_face_border = null;
	//设置魔法表情按钮
	private JButton btn_magic_face = null;
	//设置魔法表情边框高亮
	private JLabel btn_magic_face_border = null;
	//设置窗口抖动按钮
	private JButton btn_window_shake = null;
	//设置窗口抖动边框高亮
	private JLabel btn_window_shake_border = null;
	//设置辅助输入按钮
	private JButton btn_input_assist = null;
	//设置辅助输入边框高亮
	private JLabel btn_input_assist_border = null;
	//设置分割
	private JLabel aio_cutline = null;
	//设置发送图片按钮
	private JButton btn_send_picture = null;
	//设置发送图片边框高亮
	private JLabel btn_send_picture_border = null;
	//设置截图按钮
	private JButton btn_cut_picture = null;
	//设置截图按钮边框高亮
	private JLabel btn_cut_picture_border = null;
	//设置分割
	private JLabel aio_cutline2 = null;
	//设置更多边框高亮
	private JLabel btn_more_border = null;
	//设置更多边框高亮
	private JButton btn_more = null;
	//设置消息记录按钮
	private JButton btn_message_record = null;
	//设置消息记录边框高亮
	private JLabel btn_message_record_border = null;
	//设置关闭按钮
	private JButton btn_chat_close = null;
	//设置发送按钮left
	private JButton btn_send_left = null;
	//设置发送按钮right
	private JButton btn_send_right = null;

	//窗体是否完全不透明
	private boolean isWindowOpaque = true;
	
	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	//定义一个所有圆角都使用 double坐标指定的矩形
	private Shape shape = null;
	
	//颜色绿
	private Color GREEN = new Color(120, 186, 0);
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
	
	/**
	 * 
	 */
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
                g.drawImage(main_bg_Icon.getImage(), 
                		(windowWidth-main_bg_Icon.getIconWidth()), 0, Chat.this);
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
				if (Chat.this.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
					//最大化恢复操作
					//窗口的宽度和窗口的高度
					windowWidth = 545;
					windowHeight = 515;
					
					AWTUtilities.setWindowShape(Chat.this,
							new RoundRectangle2D.Double(0, 0, windowWidth, windowHeight, 6.5d, 6.5d));
					Chat.this.setBounds((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2,
							windowWidth, windowHeight);

					chatPanel.setBounds(0, 100, windowWidth, (windowHeight-100));
					btn_close.setBounds((windowWidth-30), 0, 30, 20);
					btn_max.setBounds((windowWidth-30-28), 0, 28, 20);
					btn_mini.setBounds((windowWidth-30-28-30), 0, 30, 20);
					btn_frameset.setBounds((windowWidth-30-28-30-28), 0, 28, 20);
					btn_message_record.setBounds(windowWidth-110, 5, 110, 20);
					btn_message_record_border.setBounds(windowWidth-95, 5, 82, 22);
					btn_chat_close.setBounds((windowWidth-175), 5, 75, 24);
					btn_send_left.setBounds((windowWidth-100), 5, 81, 24);
					btn_send_right.setBounds((windowWidth-29), 5, 20, 24);
					
					Chat.this.setExtendedState(JFrame.NORMAL);
				} else {
					// 最大化操作
					AWTUtilities.setWindowShape(Chat.this,
							new RoundRectangle2D.Double(0, 0, screenWidth, screenHeight, 6.5d, 6.5d));
					
					Chat.this.setBounds(0, 0, screenWidth, screenHeight);
					
					chatPanel.setBounds(0, 100, screenWidth, screenHeight-100);
					btn_close.setBounds((screenWidth-30), 0, 30, 20);
					btn_max.setBounds((screenWidth-30-28), 0, 28, 20);
					btn_mini.setBounds((screenWidth-30-28-30), 0, 30, 20);
					btn_frameset.setBounds((screenWidth-30-28-30-28), 0, 28, 20);
					btn_message_record.setBounds(screenWidth-110, 5, 110, 20);
					btn_message_record_border.setBounds(screenWidth-95, 5, 82, 22);
					btn_chat_close.setBounds((screenWidth-175), 5, 75, 24);
					btn_send_left.setBounds((screenWidth-100), 5, 81, 24);
					btn_send_right.setBounds((screenWidth-29), 5, 20, 24);
					
					windowWidth = screenWidth;
					windowHeight = screenHeight;
					
					Chat.this.revalidate();
					Chat.this.repaint(1);
					Chat.this.setExtendedState(JFrame.MAXIMIZED_BOTH);

				}
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
		
		//设置video边框高亮
		btn_video_border = new JLabel(menu_border_large_icon);
		btn_video_border.setBorder(null);
		btn_video_border.setBounds(5, 57, 52, 40);
		btn_video_border.setVisible(false);
		
		//设置video菜单
		videoPopupMenu = new JPopupMenu("JPopupMenu"); 
	    String[] videoItems = {"开始视频会话", "邀请多人视频会话", "发送视频留言", "给对方播放影音文件", "视频设置", "语音测试向导"};  

	    //video - 开始视频会话
        startVideoItem = new JMenuItem(videoItems[0], start_videoIcon);  
        startVideoItem.setFont(FONT_12_NOBOLD);
        startVideoItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
	    //video - 邀请多人视频会话
        inviteVideoItem = new JMenuItem(videoItems[1]);  
        inviteVideoItem.setFont(FONT_12_NOBOLD);
        inviteVideoItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
	    //video - 发送视频留言
        sendVideoMsgItem = new JMenuItem(videoItems[2], send_video_messageIcon);  
        sendVideoMsgItem.setFont(FONT_12_NOBOLD);
        sendVideoMsgItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
	    //video - 给对方播放影音文件
        playVideoFileItem = new JMenuItem(videoItems[3]);  
        playVideoFileItem.setFont(FONT_12_NOBOLD);
        playVideoFileItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
	    //video - 视频设置
        videoSettingItem = new JMenuItem(videoItems[4]);  
        videoSettingItem.setFont(FONT_12_NOBOLD);
        videoSettingItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
	    //video - 语音测试向导
        videoAudioTestingGuideItem = new JMenuItem(videoItems[5]);  
        videoAudioTestingGuideItem.setFont(FONT_12_NOBOLD);
        videoAudioTestingGuideItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

        //video下拉菜单添加条目
        videoPopupMenu.add(startVideoItem);  
        videoPopupMenu.add(inviteVideoItem); 
        videoPopupMenu.add(sendVideoMsgItem);  
        videoPopupMenu.addSeparator();  
        videoPopupMenu.add(playVideoFileItem);  
        videoPopupMenu.add(videoSettingItem);  
        videoPopupMenu.add(videoAudioTestingGuideItem);  
        
		//设置video按钮
		btn_video = new JButton();
		btn_video.setBounds(8, 60, 46, 34);
		btn_video.setIcon(menu_videoIcon);
		btn_video.setBorderPainted(false);
		btn_video.setContentAreaFilled(false);
		btn_video.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(videoPopupMenu.getSubElements().length != 0) {  
                	//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
                	videoPopupMenu.show(Chat.this, 8, 99);  
                    //请求此 Component 获取输入焦点
                	videoPopupMenu.requestFocus();  
                }  
            }  
        });  
		btn_video.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				btn_video_border.setIcon(menu_border_large_icon);
				btn_video_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				btn_video_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_video_border.setIcon(menu_border_large_press_icon);
			}
		});
		
		//设置audio边框高亮
		btn_audio_border = new JLabel(menu_border_large_icon);
		btn_audio_border.setBorder(null);
		btn_audio_border.setBounds(54, 57, 52, 40);
		btn_audio_border.setVisible(false);
		
		//设置audio菜单
		audioPopupMenu = new JPopupMenu("JPopupMenu"); 
	    String[] audioItems = {"开始语音会话", "发起多人语音", "语音设置", "语音测试向导", "发送语音消息"};  

	    //audio - 开始语音会话
        startAudioItem = new JMenuItem(audioItems[0]);  
        startAudioItem.setFont(FONT_12_NOBOLD);
        startAudioItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
	    //audio - 发起多人语音
        inviteAudioItem = new JMenuItem(audioItems[1]);  
        inviteAudioItem.setFont(FONT_12_NOBOLD);
        inviteAudioItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
	    //audio - 语音设置
        audioSettingItem = new JMenuItem(audioItems[2]);  
        audioSettingItem.setFont(FONT_12_NOBOLD);
        audioSettingItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        });
        
	    //audio - 语音测试向导
        audioTestingGuideItem = new JMenuItem(audioItems[3]);  
        audioTestingGuideItem.setFont(FONT_12_NOBOLD);
        audioTestingGuideItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
	    //audio - 发送语音消息
        sendAudioMessageItem = new JMenuItem(audioItems[4]);  
        sendAudioMessageItem.setFont(FONT_12_NOBOLD);
        sendAudioMessageItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

        //下拉菜单添加条目
        audioPopupMenu.add(startAudioItem);  
        audioPopupMenu.add(inviteAudioItem); 
        audioPopupMenu.add(audioSettingItem); 
        audioPopupMenu.add(audioTestingGuideItem);  
        audioPopupMenu.add(sendAudioMessageItem);  

		//设置audio按钮
		btn_audio = new JButton();
		btn_audio.setBounds(57, 60, 46, 34);
		btn_audio.setIcon(menu_audioIcon);
		btn_audio.setBorderPainted(false);
		btn_audio.setContentAreaFilled(false);
		btn_audio.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(audioPopupMenu.getSubElements().length != 0) {  
                	//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
                	audioPopupMenu.show(Chat.this, 57, 99);  
                    //请求此 Component 获取输入焦点
                	audioPopupMenu.requestFocus();  
                }  
            }  
        }); 
		btn_audio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				btn_audio_border.setIcon(menu_border_large_icon);
				btn_audio_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				btn_audio_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_audio_border.setIcon(menu_border_large_press_icon);
			}
		});
		
		//设置文件传输边框高亮
		btn_file_transfer_border = new JLabel(menu_border_large_icon);
		btn_file_transfer_border.setBorder(null);
		btn_file_transfer_border.setBounds(106, 57, 52, 40);
		btn_file_transfer_border.setVisible(false);
		
		//设置文件传输菜单
		fileTransferPopupMenu = new JPopupMenu("JPopupMenu"); 
	    String[] fileTransferItems = {"发送文件", "发送文件夹", "发送离线文件", "发送文件设置"};  

	    //文件传输 - 发送文件
        sendFileItem = new JMenuItem(fileTransferItems[0]);  
        sendFileItem.setFont(FONT_12_NOBOLD);
        sendFileItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //文件传输 - 发送文件夹
        sendFileDirectoryItem = new JMenuItem(fileTransferItems[1]);  
        sendFileDirectoryItem.setFont(FONT_12_NOBOLD);
        sendFileDirectoryItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //文件传输 - 发送离线文件
        sendOffLineFileItem = new JMenuItem(fileTransferItems[2]);  
        sendOffLineFileItem.setFont(FONT_12_NOBOLD);
        sendOffLineFileItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //文件传输 - 发送文件设置
        sendFileSettingItem = new JMenuItem(fileTransferItems[3]);  
        sendFileSettingItem.setFont(FONT_12_NOBOLD);
        sendFileSettingItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

        //文件传输 下拉菜单添加条目
        fileTransferPopupMenu.add(sendFileItem);  
        fileTransferPopupMenu.add(sendFileDirectoryItem);  
        fileTransferPopupMenu.add(sendOffLineFileItem);  
        fileTransferPopupMenu.add(sendFileSettingItem);  

		//设置文件传输按钮
		btn_file_transfer = new JButton();
		btn_file_transfer.setBounds(109, 60, 46, 34);
		btn_file_transfer.setIcon(menu_file_transferIcon);
		btn_file_transfer.setBorderPainted(false);
		btn_file_transfer.setContentAreaFilled(false);
		btn_file_transfer.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(fileTransferPopupMenu.getSubElements().length != 0) {  
                	//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
                	fileTransferPopupMenu.show(Chat.this, 106, 99);  
                    //请求此 Component 获取输入焦点
                	fileTransferPopupMenu.requestFocus();  
                }  
            }  
        });
		btn_file_transfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				btn_file_transfer_border.setIcon(menu_border_large_icon);
				btn_file_transfer_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				btn_file_transfer_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_file_transfer_border.setIcon(menu_border_large_press_icon);
			}
		});
		
		//设置创建讨论组边框高亮
		btn_create_group_border = new JLabel(menu_border_icon);
		btn_create_group_border.setBorder(null);
		btn_create_group_border.setBounds(158, 57, 40, 40);
		btn_create_group_border.setVisible(false);

		//设置创建讨论组按钮
		btn_create_group = new JButton();
		btn_create_group.setBounds(161, 60, 34, 34);
		btn_create_group.setIcon(menu_create_groupIcon);
		btn_create_group.setBorderPainted(false);
		btn_create_group.setContentAreaFilled(false);
		btn_create_group.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				btn_create_group_border.setIcon(menu_border_icon);
				btn_create_group_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				btn_create_group_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_create_group_border.setIcon(menu_border_press_icon);
			}
		});
		
		//设置远程协助边框高亮
		btn_remote_help_border = new JLabel(menu_border_icon);
		btn_remote_help_border.setBorder(null);
		btn_remote_help_border.setBounds(198, 57, 40, 40);
		btn_remote_help_border.setVisible(false);

		//设置远程协助按钮
		btn_remote_help = new JButton();
		btn_remote_help.setBounds(201, 60, 34, 34);
		btn_remote_help.setIcon(menu_remote_helpIcon);
		btn_remote_help.setBorderPainted(false);
		btn_remote_help.setContentAreaFilled(false);
		btn_remote_help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				btn_remote_help_border.setIcon(menu_border_icon);
				btn_remote_help_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				btn_remote_help_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_remote_help_border.setIcon(menu_border_press_icon);
			}
		});
		
		//设置应用边框高亮
		btn_app_border = new JLabel(menu_border_large_icon);
		btn_app_border.setBorder(null);
		btn_app_border.setBounds(238, 57, 52, 40);
		btn_app_border.setVisible(false);
		
		//设置应用菜单
		appPopupMenu = new JPopupMenu("JPopupMenu"); 
	    String[] appItems = {"发送短信", "发送邮件", "手机免费聊QQ", "搜索", "腾讯视频", 
	    		"财付通", "QQ风尚", "给他推荐好友", "删除好友", "移至黑名单", "举报", "等级加速PK"};  

	    //应用 - 发送短信
        sendSMSItem = new JMenuItem(appItems[0], send_SMSIcon);  
        sendSMSItem.setFont(FONT_12_NOBOLD);
        sendSMSItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //应用 - 发送邮件
        sendEmailItem = new JMenuItem(appItems[1], send_emailIcon);  
        sendEmailItem.setFont(FONT_12_NOBOLD);
        sendEmailItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //应用 - 手机免费聊QQ
        mobileChatItem = new JMenuItem(appItems[2], mobile_chatIcon);  
        mobileChatItem.setFont(FONT_12_NOBOLD);
        mobileChatItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //应用 - 搜索
        searchItem = new JMenuItem(appItems[3], searchIcon);  
        searchItem.setFont(FONT_12_NOBOLD);
        searchItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //应用 - 腾讯视频
        tencentLiveItem = new JMenuItem(appItems[4], tencent_liveIcon);  
        tencentLiveItem.setFont(FONT_12_NOBOLD);
        tencentLiveItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        });

	    //应用 - 财付通
        tenpayItem = new JMenuItem(appItems[5], tenpayIcon);  
        tenpayItem.setFont(FONT_12_NOBOLD);
        tenpayItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        });

	    //应用 - QQ风尚
        styleItem = new JMenuItem(appItems[6], styleIcon);  
        styleItem.setFont(FONT_12_NOBOLD);
        styleItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //应用 - 给他推荐好友
        contactRecommendItem = new JMenuItem(appItems[7], contact_recommendIcon);  
        contactRecommendItem.setFont(FONT_12_NOBOLD);
        contactRecommendItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //应用 - 删除好友
        deleteFriendItem = new JMenuItem(appItems[8], delete_friendIcon);  
        deleteFriendItem.setFont(FONT_12_NOBOLD);
        deleteFriendItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        });

	    //应用 - 移至黑名单
        moveToBlackListItem = new JMenuItem(appItems[9], move_to_black_listIcon);  
        moveToBlackListItem.setFont(FONT_12_NOBOLD);
        moveToBlackListItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //应用 - 举报
        reportItem = new JMenuItem(appItems[10], reportIcon);  
        reportItem.setFont(FONT_12_NOBOLD);
        reportItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 

	    //应用 - 等级加速PK
        levelPKItem = new JMenuItem(appItems[11], levelPKIcon);  
        levelPKItem.setFont(FONT_12_NOBOLD);
        levelPKItem.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            }  
        }); 
        
        //应用下拉菜单添加条目
        appPopupMenu.add(sendSMSItem); 
        appPopupMenu.add(sendEmailItem); 
        appPopupMenu.add(mobileChatItem); 
        appPopupMenu.addSeparator();
        appPopupMenu.add(searchItem); 
        appPopupMenu.add(tencentLiveItem); 
        appPopupMenu.add(tenpayItem);  
        appPopupMenu.add(styleItem); 
        appPopupMenu.addSeparator();
        appPopupMenu.add(contactRecommendItem); 
        appPopupMenu.add(deleteFriendItem); 
        appPopupMenu.add(moveToBlackListItem); 
        appPopupMenu.add(reportItem); 
        appPopupMenu.add(levelPKItem); 

		//设置应用按钮
		btn_app = new JButton();
		btn_app.setBounds(241, 60, 46, 34);
		btn_app.setIcon(menu_appIcon);
		btn_app.setBorderPainted(false);
		btn_app.setContentAreaFilled(false);
		btn_app.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(appPopupMenu.getSubElements().length != 0) {  
                	//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
                	appPopupMenu.show(Chat.this, 241, 99);  
                    //请求此 Component 获取输入焦点
                	appPopupMenu.requestFocus();  
                }  
            }  
        });
		btn_app.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("bbbbbbbbbbbb");
				btn_app_border.setIcon(menu_border_large_icon);
				btn_app_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("aaaaaaaaaaaaaa");
				btn_app_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("cccccccccccccc");
				btn_app_border.setIcon(menu_border_large_press_icon);
			}
		});
		
		//聊天界面中心面板
		chatPanel = new JPanel(new BorderLayout());
		chatPanel.setBounds(0, 100, windowWidth, (windowHeight-100));
		chatPanel.setBackground(new Color(255, 255, 255, 100));
		
		//聊天界面消息内容面板
		msgContentPanel = new JPanel(new BorderLayout());
		//设置半透明有重影
		//msgContentPanel.setBackground(new Color(255, 255, 255, 100));
		msgContentPanel.setBackground(new Color(255, 255, 255));
		
		//提示label
		msgTip = new JLabel("交谈中请勿轻信汇款、中奖信息、陌生电话，勿使用外挂软件。", 
				tipInfoIcon, SwingConstants.LEFT);
		msgTip.setFont(FONT_12_NOBOLD);
		msgContentPanel.add(BorderLayout.NORTH, msgTip);
		
		//聊天消息
		msgContentTextArea = new JTextArea();
		//设置多行文本透明（字体会重影，问题尚未解决！）
		//msgContentTextArea.setOpaque(false);
		//自动换行
		msgContentTextArea.setLineWrap(true);
		//设置不可编辑
		msgContentTextArea.setEditable(false);
		//换行方式-以单词末尾换行
		msgContentTextArea.setWrapStyleWord(false);
		//设置字体
		msgContentTextArea.setFont(FONT_12_NOBOLD);
		//设置内边距
		msgContentTextArea.setMargin(new Insets(10, 10, 5, 5));
		msgContentTextArea.setText("sdkfajsdfasdfasdfasdfsdfs");
		
		//消息多行文本滚动条
		msgContentScrollPane = new JScrollPane(msgContentTextArea);
		//设置成透明
		msgContentScrollPane.setOpaque(false);
		msgContentScrollPane.getViewport().setOpaque(false);
		//设置滚动条样式
		msgContentScrollPane.getVerticalScrollBar().setUI(new NewScrollBarUI());
		msgContentScrollPane.setBorder(BorderFactory.createEmptyBorder());
		//消息内容面板添加组件
		msgContentPanel.add(BorderLayout.CENTER, msgContentScrollPane);
		
		//聊天界面输入面板
		msgInputPanel = new JPanel(new BorderLayout());
		msgInputPanel.setBackground(new Color(255, 255, 255, 200));
		
		//消息输入工具栏面板
		msgInputTopToolBarPanel = new JPanel(new BorderLayout());
		msgInputTopToolBarPanel.setBackground(Color.black);
		//字体选择panel
		//布局管理器
		flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		msgInputTopToolBarCenterPanel = new JPanel(flowLayout);
		msgInputTopToolBarCenterPanel.setBackground(new Color(225, 239, 199));
		//消息输入工具栏
		msgInputTopToolBarSouthPanel = new JPanel(null);
		msgInputTopToolBarSouthPanel.setBackground(new Color(225, 239, 199));
		msgInputTopToolBarSouthPanel.setPreferredSize(new Dimension(windowWidth, 30));

		//系统默认字体列表
		btn_windows_default_font = new JButton();
		btn_windows_default_font.setBounds(5, 5, 20, 20);
		btn_windows_default_font.setPreferredSize(new Dimension(20, 20));
		btn_windows_default_font.setIcon(btn_windows_default_fontIcon);
		btn_windows_default_font.setBorderPainted(true);
		btn_windows_default_font.setContentAreaFilled(false);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontList = ge.getAvailableFontFamilyNames();
		//字体选择工具栏-字体下拉列表
		fontComboBox = new JComboBox<String>(fontList);  
		//字体选择工具栏-字体大小下拉列表
		Integer[] fontSizeList = new Integer[15];
		for(int i = 0; i<=14; i++){
			fontSizeList[i] = i+8;
		}
		fontSizeComboBox = new JComboBox<Integer>(fontSizeList);  
		//设置字体加粗按钮
		btn_font_bold = new JButton();
		btn_font_bold.setPreferredSize(new Dimension(20, 20));
		btn_font_bold.setIcon(btn_font_boldIcon);
		btn_font_bold.setBorderPainted(false);
		btn_font_bold.setContentAreaFilled(false);
		btn_font_bold.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(fontBoldFlag){
					btn_font_bold.setBorderPainted(true);
				}else{
					btn_font_bold.setBorderPainted(false);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_font_bold.setBorderPainted(true);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_font_bold.setBorderPainted(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if((e.getClickCount() + fontBoldClickCount)%2 == 1){
					fontBoldFlag = true;
					fontBoldClickCount = 1;
				}else{
					fontBoldFlag = false;
					fontBoldClickCount= 0;
				}
				btn_font_bold.setBorderPainted(true);
			}
		});
		//设置字体倾斜按钮
		btn_font_italic = new JButton();
		btn_font_italic.setPreferredSize(new Dimension(20, 20));
		btn_font_italic.setIcon(btn_font_italicIcon);
		btn_font_italic.setBorderPainted(false);
		btn_font_italic.setContentAreaFilled(false);
		btn_font_italic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(fontItalicFlag){
					btn_font_italic.setBorderPainted(true);
				}else{
					btn_font_italic.setBorderPainted(false);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_font_italic.setBorderPainted(true);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_font_italic.setBorderPainted(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if((e.getClickCount() + fontItalicClickCount)%2 == 1){
					fontItalicFlag = true;
					fontItalicClickCount = 1;
				}else{
					fontItalicFlag = false;
					fontItalicClickCount= 0;
				}
				btn_font_italic.setBorderPainted(true);
			}
			
		});
		//设置字体下划线按钮
		btn_font_underline = new JButton();
		btn_font_underline.setPreferredSize(new Dimension(20, 20));
		btn_font_underline.setIcon(btn_font_underlineIcon);
		btn_font_underline.setBorderPainted(false);
		btn_font_underline.setContentAreaFilled(false);
		btn_font_underline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(fontUnderlineFlag){
					btn_font_underline.setBorderPainted(true);
				}else{
					btn_font_underline.setBorderPainted(false);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_font_underline.setBorderPainted(true);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_font_underline.setBorderPainted(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if((e.getClickCount() + fontUnderlineClickCount)%2 == 1){
					fontUnderlineFlag = true;
					fontUnderlineClickCount = 1;
				}else{
					fontUnderlineFlag = false;
					fontUnderlineClickCount= 0;
				}
				btn_font_underline.setBorderPainted(true);
			}
		});
		//设置字体颜色按钮
		btn_font_color = new JButton();
		btn_font_color.setPreferredSize(new Dimension(20, 20));
		btn_font_color.setIcon(btn_font_colorIcon);
		btn_font_color.setBorderPainted(false);
		btn_font_color.setContentAreaFilled(false);
		btn_font_color.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
					btn_font_color.setBorderPainted(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_font_color.setBorderPainted(true);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		//添加文字工具
		msgInputTopToolBarCenterPanel.add(btn_windows_default_font);
		msgInputTopToolBarCenterPanel.add(fontComboBox);
		msgInputTopToolBarCenterPanel.add(fontSizeComboBox);
		msgInputTopToolBarCenterPanel.add(btn_font_bold);
		msgInputTopToolBarCenterPanel.add(btn_font_italic);
		msgInputTopToolBarCenterPanel.add(btn_font_underline);
		msgInputTopToolBarCenterPanel.add(btn_font_color);
		
		//设置字体选择工具边框高亮
		btn_font_choose_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_font_choose_border.setBorder(null);
		btn_font_choose_border.setBounds(4, 4, 22, 22);
		btn_font_choose_border.setVisible(false);

		//设置字体选择工具按钮
		btn_font_choose = new JButton();
		btn_font_choose.setBounds(5, 5, 20, 20);
		btn_font_choose.setPreferredSize(new Dimension(20, 20));
		btn_font_choose.setIcon(btn_font_chooseIcon);
		btn_font_choose.setBorderPainted(false);
		btn_font_choose.setContentAreaFilled(false);
		btn_font_choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(!visibleFlag){
            		visibleFlag = true;
            		//添加字体选择工具
            		msgInputTopToolBarPanel.add(BorderLayout.CENTER, msgInputTopToolBarCenterPanel);
            		//重新刷新界面panel
            		msgInputTopToolBarPanel.revalidate();
            		msgInputTopToolBarPanel.repaint(1);
            	}else{
            		visibleFlag = false;
            		//移除组件
            		msgInputTopToolBarPanel.remove(msgInputTopToolBarCenterPanel);
            		//刷新
            		msgInputTopToolBarPanel.revalidate();
            		msgInputTopToolBarPanel.repaint(1);
            	}
            	
            }
        });
		btn_font_choose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if(borderFlag){
					btn_font_choose_border.setVisible(true);
				}else{
					btn_font_choose_border.setVisible(false);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_font_choose_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_font_choose_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if((e.getClickCount() + buttonClickCount)%2 == 1){
					borderFlag = true;
					buttonClickCount = 1;
				}else{
					borderFlag = false;
					buttonClickCount= 0;
				}
				btn_font_choose_border.setVisible(true);
			}
			
		});
		
		//设置表情边框高亮
		btn_face_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_face_border.setBorder(null);
		btn_face_border.setBounds(29, 4, 22, 22);
		btn_face_border.setVisible(false);
		
		//设置表情按钮
		btn_face = new JButton();
		btn_face.setBounds(30, 5, 20, 20);
		btn_face.setPreferredSize(new Dimension(20, 20));
		btn_face.setIcon(btn_faceIcon);
		btn_face.setBorderPainted(false);
		btn_face.setContentAreaFilled(false);
		btn_face.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_face_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_face_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_face_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		//设置魔法表情边框高亮
		btn_magic_face_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_magic_face_border.setBorder(null);
		btn_magic_face_border.setBounds(54, 4, 22, 22);
		btn_magic_face_border.setVisible(false);
		
		//设置魔法表情按钮
		btn_magic_face = new JButton();
		btn_magic_face.setBounds(55, 5, 20, 20);
		btn_magic_face.setPreferredSize(new Dimension(20, 20));
		btn_magic_face.setIcon(btn_magic_faceIcon);
		btn_magic_face.setBorderPainted(false);
		btn_magic_face.setContentAreaFilled(false);
		btn_magic_face.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_magic_face_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_magic_face_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_magic_face_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		//设置窗口抖动边框高亮
		btn_window_shake_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_window_shake_border.setBorder(null);
		btn_window_shake_border.setBounds(79, 4, 22, 22);
		btn_window_shake_border.setVisible(false);
		
		//设置窗口抖动按钮
		btn_window_shake = new JButton();
		btn_window_shake.setBounds(80, 5, 20, 20);
		btn_window_shake.setPreferredSize(new Dimension(20, 20));
		btn_window_shake.setIcon(btn_window_shakeIcon);
		btn_window_shake.setBorderPainted(false);
		btn_window_shake.setContentAreaFilled(false);
		btn_window_shake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_window_shake_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_window_shake_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_window_shake_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		//设置辅助输入边框高亮
		btn_input_assist_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_input_assist_border.setBorder(null);
		btn_input_assist_border.setBounds(104, 4, 22, 22);
		btn_input_assist_border.setVisible(false);
		
		//设置辅助输入按钮
		btn_input_assist = new JButton();
		btn_input_assist.setBounds(105, 5, 20, 20);
		btn_input_assist.setPreferredSize(new Dimension(20, 20));
		btn_input_assist.setIcon(btn_input_assistIcon);
		btn_input_assist.setBorderPainted(false);
		btn_input_assist.setContentAreaFilled(false);
		btn_input_assist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_input_assist_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_input_assist_border.setVisible(true);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_input_assist_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		//设置分割
		aio_cutline = new JLabel(cutlineIcon);
		aio_cutline.setBounds(128, 5, 2, 20);
		
		//设置发送图片边框高亮
		btn_send_picture_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_send_picture_border.setBorder(null);
		btn_send_picture_border.setBounds(134, 4, 22, 22);
		btn_send_picture_border.setVisible(false);
		
		//设置发送图片按钮
		btn_send_picture = new JButton();
		btn_send_picture.setBounds(135, 5, 20, 20);
		btn_send_picture.setPreferredSize(new Dimension(20, 20));
		btn_send_picture.setIcon(btn_send_pictureIcon);
		btn_send_picture.setBorderPainted(false);
		btn_send_picture.setContentAreaFilled(false);
		btn_send_picture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_send_picture_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_send_picture_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_send_picture_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		//设置截图边框高亮
		btn_cut_picture_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_cut_picture_border.setBorder(null);
		btn_cut_picture_border.setBounds(159, 4, 22, 22);
		btn_cut_picture_border.setVisible(false);
		
		//设置截图按钮
		btn_cut_picture = new JButton();
		btn_cut_picture.setBounds(160, 5, 20, 20);
		btn_cut_picture.setPreferredSize(new Dimension(20, 20));
		btn_cut_picture.setIcon(btn_cut_pictureIcon);
		btn_cut_picture.setBorderPainted(false);
		btn_cut_picture.setContentAreaFilled(false);
		btn_cut_picture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_cut_picture_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_cut_picture_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_cut_picture_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		//设置分割
		aio_cutline2 = new JLabel(cutlineIcon);
		aio_cutline2.setBounds(183, 5, 2, 20);
		
		//设置更多边框高亮
		btn_more_border = new JLabel(btn_icon_broder_highlightIcon);
		btn_more_border.setBorder(null);
		btn_more_border.setBounds(186, 4, 22, 22);
		btn_more_border.setVisible(false);
		
		//设置更多按钮
		btn_more = new JButton();
		btn_more.setBounds(187, 5, 20, 20);
		btn_more.setPreferredSize(new Dimension(20, 20));
		btn_more.setIcon(btn_moreIcon);
		btn_more.setBorderPainted(false);
		btn_more.setContentAreaFilled(false);
		btn_more.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_more_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_more_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_more_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		//设置消息记录边框高亮
		btn_message_record_border = new JLabel(btn_msgrecord_broderIcon);
		btn_message_record_border.setBorder(null);
		btn_message_record_border.setBounds(windowWidth-95, 5, 82, 22);
		btn_message_record_border.setVisible(false);
		
		//设置消息记录按钮
		btn_message_record = new JButton("消息记录");
		btn_message_record.setBounds(windowWidth-110, 5, 110, 20);
		btn_message_record.setIcon(btn_message_recordIcon);
		btn_message_record.setFont(FONT_12_NOBOLD);
		btn_message_record.setBorderPainted(false);
		btn_message_record.setContentAreaFilled(false);
		btn_message_record.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_message_record_border.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_message_record_border.setVisible(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_message_record_border.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		msgInputTopToolBarSouthPanel.add(btn_font_choose);
		msgInputTopToolBarSouthPanel.add(btn_font_choose_border);
		msgInputTopToolBarSouthPanel.add(btn_face);
		msgInputTopToolBarSouthPanel.add(btn_face_border);
		msgInputTopToolBarSouthPanel.add(btn_magic_face);
		msgInputTopToolBarSouthPanel.add(btn_magic_face_border);
		msgInputTopToolBarSouthPanel.add(btn_window_shake);
		msgInputTopToolBarSouthPanel.add(btn_window_shake_border);
		msgInputTopToolBarSouthPanel.add(btn_input_assist);
		msgInputTopToolBarSouthPanel.add(btn_input_assist_border);
		msgInputTopToolBarSouthPanel.add(aio_cutline);
		msgInputTopToolBarSouthPanel.add(btn_send_picture);
		msgInputTopToolBarSouthPanel.add(btn_send_picture_border);
		msgInputTopToolBarSouthPanel.add(btn_cut_picture);
		msgInputTopToolBarSouthPanel.add(btn_cut_picture_border);
		msgInputTopToolBarSouthPanel.add(aio_cutline2);
		msgInputTopToolBarSouthPanel.add(btn_more);
		msgInputTopToolBarSouthPanel.add(btn_more_border);
		msgInputTopToolBarSouthPanel.add(btn_message_record);
		msgInputTopToolBarSouthPanel.add(btn_message_record_border);
		
		msgInputTopToolBarPanel.add(BorderLayout.SOUTH, msgInputTopToolBarSouthPanel);
		
		//消息输入多行文本
		msgInputTextArea = new JTextArea();
		msgInputTextArea.setRows(6);
		msgInputTextArea.setMargin(new Insets(10, 10, 5, 5));
		
		//消息输入底部工具栏面板
		msgInputBottomToolBarPanel = new JPanel(null);
		msgInputBottomToolBarPanel.setBackground(new Color(225, 239, 199));
		msgInputBottomToolBarPanel.setPreferredSize(new Dimension(windowWidth, 35));
		
		//设置关闭按钮
		btn_chat_close = new JButton("关闭(C)");
		btn_chat_close.setBounds((windowWidth-175), 5, 75, 24);
		btn_chat_close.setIcon(btn_chat_close_normalIcon);
		btn_chat_close.setRolloverIcon(btn_chat_close_hoverIcon);
		btn_chat_close.setPressedIcon(btn_chat_close_pressIcon);
		btn_chat_close.setBorderPainted(false);
		btn_chat_close.setContentAreaFilled(false);
		btn_chat_close.setFont(FONT_12_NOBOLD);
		//设置文字在按钮水平垂直上的位置
		btn_chat_close.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_chat_close.setVerticalTextPosition(SwingConstants.CENTER);

		//设置发送按钮left
		btn_send_left = new JButton("发送(S)");
		btn_send_left.setBounds((windowWidth-100), 5, 81, 24);
		btn_send_left.setIcon(btn_send_left_normalIcon);
		btn_send_left.setRolloverIcon(btn_send_left_hoverIcon);
		btn_send_left.setPressedIcon(btn_send_left_pressIcon);
		btn_send_left.setBorderPainted(false);
		btn_send_left.setContentAreaFilled(false);
		btn_send_left.setFont(FONT_12_NOBOLD);
		//设置文字在按钮水平垂直上的位置
		btn_send_left.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_send_left.setVerticalTextPosition(SwingConstants.CENTER);
		
		//设置发送按钮right
		btn_send_right = new JButton();
		btn_send_right.setBounds((windowWidth-29), 5, 20, 24);
		btn_send_right.setIcon(btn_send_right_normalIcon);
		btn_send_right.setRolloverIcon(btn_send_right_hoverIcon);
		btn_send_right.setPressedIcon(btn_send_right_pressIcon);
		btn_send_right.setBorderPainted(false);
		btn_send_right.setContentAreaFilled(false);
		btn_send_right.setFont(FONT_12_NOBOLD);
		//设置文字在按钮水平垂直上的位置
		btn_send_right.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_send_right.setVerticalTextPosition(SwingConstants.CENTER);

		msgInputBottomToolBarPanel.add(btn_chat_close);
		msgInputBottomToolBarPanel.add(btn_send_left);
		msgInputBottomToolBarPanel.add(btn_send_right);
		
		//消息输入面板添加组件
		msgInputPanel.add(BorderLayout.NORTH, msgInputTopToolBarPanel);
		msgInputPanel.add(BorderLayout.CENTER, msgInputTextArea);
		msgInputPanel.add(BorderLayout.SOUTH, msgInputBottomToolBarPanel);
		
		//聊天界面中心面板添加组件
		chatPanel.add(BorderLayout.CENTER, msgContentPanel);
		chatPanel.add(BorderLayout.SOUTH, msgInputPanel);
		
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
		this.add(btn_video);
		this.add(btn_video_border);
		this.add(btn_audio);
		this.add(btn_audio_border);
		this.add(btn_file_transfer);
		this.add(btn_file_transfer_border);
		this.add(btn_create_group);
		this.add(btn_create_group_border);
		this.add(btn_remote_help);
		this.add(btn_remote_help_border);
		this.add(btn_app);
		this.add(btn_app_border);
		this.add(chatPanel);

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
            Rectangle bounds = Chat.this.getBounds();
            bounds.x += offsetX;
            bounds.y += offsetY;
            Chat.this.setBounds(bounds);
            lastPoint = point;
        }
	};
	
	public static void main(String[] args) {
		new Chat().setVisible(true);
	}

}
