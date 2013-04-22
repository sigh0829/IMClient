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
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

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
	private ImageIcon main_bg_Icon = ImageManageUtils.getImageIcon("images/background/chat/main_bg_snail.jpg");
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
	}
	
	public static void main(String[] args) {
		new Chat().setVisible(true);
	}

}
