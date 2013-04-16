package com.im.client.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.plaf.metal.MetalTextFieldUI;

import com.im.client.utils.ImageManageUtils;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			重写JPasswordField                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.component                    
* Author：				Ellery                 
* Create Date：			2011-03-17 23:01 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 

@SuppressWarnings("serial")
public class NewPasswordField extends JPasswordField{
	private Image backgroundLeftImage = ImageManageUtils.getImage("passwordfield_bg_left.png", "frame/login");
	private Image backgroundRightImage = ImageManageUtils.getImage("passwordfield_bg_right.png", "frame/login");
	private Image textfield_backgroundImage = ImageManageUtils.getImage("passwordfield_bg.png", "frame/login");
	private Font FONT_12_BOLD = new Font("宋体", 0, 13);
	Color BLACK = new Color(0,0,0);

	public NewPasswordField(ImageIcon keyboard_Icon) {
		super();
		init(keyboard_Icon);
		this.setEchoChar('*');
		this.getInsets();
		this.setFont(FONT_12_BOLD);
		this.setForeground(BLACK);
	}
	
    public Insets getInsets() {
        return new Insets(0, 25, 0, 10);
    }

    private void init(final ImageIcon keyboard_Icon) {
		this.setUI(new MetalTextFieldUI() {
			@Override
			protected void paintBackground(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.fillRect(0, 0, getWidth(), getHeight());
				//每一副图像的位置坐标
				int x = 1;
				//平铺背景图片
				while (true) {
					//绘制图片
					g2d.drawImage(textfield_backgroundImage, x, 0, null);
					//如果绘制完毕，退出循环
					if (x > getSize().width){
						break;
					}else{
						//如果在当前行，得到下一个图片的坐标位置
						x += textfield_backgroundImage.getWidth(null);
					}
				}
				g2d.drawImage(backgroundLeftImage, 0, 0, null);
				g2d.drawImage(backgroundRightImage, getWidth()
						- backgroundRightImage.getWidth(null), 0, null);
				//设置输入框按钮
				JLabel label_keyboard_Icon = new JLabel(keyboard_Icon);
				label_keyboard_Icon.setBounds(2, 2, 20, 20);
				NewPasswordField.this.add(label_keyboard_Icon);
			}
		});
	}
}