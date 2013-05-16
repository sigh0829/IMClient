package com.im.client.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.plaf.basic.BasicPasswordFieldUI;

import com.im.client.utils.ImageManageUtils;
import com.im.client.utils.KeyboardUtils;
import com.im.client.utils.ScreenSizeUtils;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			重写JPasswordField                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.component                    
* Author：				Ellery                 
* Create Date：			2013-03-17 23:01 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 

@SuppressWarnings("serial")
public class NewPasswordField extends JPasswordField {
	
	//密码框背景图片
	private Image backgroundLeftImage = ImageManageUtils.getImage("passwordfield_bg_left.png", "frame/login/passwordfield");
	private Image backgroundRightImage = ImageManageUtils.getImage("passwordfield_bg_right.png", "frame/login/passwordfield");
	private Image passwordfield_backgroundImage = ImageManageUtils.getImage("passwordfield_bg.png", "frame/login/passwordfield");
	
	//字体
	private Font FONT_12_BOLD = new Font("宋体", 0, 13);
	
	//颜色
	Color BLACK = new Color(0,0,0);
	//软键盘
	private KeyboardUtils keyboardUtils = null;
	//窗口的宽度和窗口的高度
	private int windowWidth = 380;
	private int windowHeight = 292;
	
	//屏幕的宽度和屏幕的高度
	private int screenWidth = 0;
	private int screenHeight = 0;
	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	

	public NewPasswordField(ImageIcon keyboard_Icon) {
		super();
		//获取屏幕高度宽度
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
		init(keyboard_Icon);
		this.getInsets();
		this.setFont(FONT_12_BOLD);
		this.setForeground(BLACK);
	}

	public Insets getInsets() {
        return new Insets(0, 5, 0, 5);
    }

    private void init(final ImageIcon keyboard_Icon) {
		this.setUI(new BasicPasswordFieldUI() {
			@Override
			protected void paintBackground(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.fillRect(0, 0, getWidth(), getHeight());
				//每一副图像的位置坐标
				int x = 1;
				//平铺背景图片
				while (true) {
					//绘制图片
					g2d.drawImage(passwordfield_backgroundImage, x, 0, null);
					//如果绘制完毕，退出循环
					if (x > getSize().width){
						break;
					}else{
						//如果在当前行，得到下一个图片的坐标位置
						x += passwordfield_backgroundImage.getWidth(null);
					}
				}
				g2d.drawImage(backgroundLeftImage, 0, 0, null);
				g2d.drawImage(backgroundRightImage, getWidth()
						- backgroundRightImage.getWidth(null), 0, null);
				//设置输入框按钮
				JLabel label_keyboard_Icon = new JLabel(keyboard_Icon);
				label_keyboard_Icon.setCursor(new Cursor(Cursor.HAND_CURSOR));
				label_keyboard_Icon.setBounds(getWidth()-23, 2, 20, 20);
				label_keyboard_Icon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						keyboardUtils = new KeyboardUtils(null, 111 + (screenWidth - windowWidth)/2, 200 + (screenHeight - windowHeight)/2);
						keyboardUtils.setVisible(true);
					}
				});
				
				NewPasswordField.this.add(label_keyboard_Icon);
			}
		});
	}
}