package com.im.client.ui;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.im.client.utils.GetImageUtils;
import com.im.client.utils.ScreenSizeUtils;
import com.sun.awt.AWTUtilities;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessage                                          
* Module ID:			1    
* Comments:  			Mini���û���½����                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.ui                         
* Author��				Ellery                 
* Create Date��			2013-03-16 14:23 
* Modified By��			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 
@SuppressWarnings("serial")
public class MiniLogin extends JFrame{

	//���ڵĿ�Ⱥʹ��ڵĸ߶�
	private int windowWidth = 380;
	private int windowHeight = 292;
	
	//��Ļ�Ŀ�Ⱥ���Ļ�ĸ߶�
	private int screenWidth = 0;
	private int screenHeight = 0;
	
	//�����Ƿ���ȫ��͸��
	private boolean isWindowOpaque = false;
	
	//��¼���汳��ͼƬ
	private ImageIcon loginbgIcon = GetImageUtils.getImageIcon("images/background/login/login_bg_noon.jpg");
	
	public MiniLogin(){
		//��ȡ��Ļ�߶ȿ��
		ScreenSizeUtils screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
		
		//��ʼ������
		initUI();
	}
	
	public void initUI(){
		this.setTitle("IM2013");
		this.setLayout(null);
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		
		//����һ������Բ�Ƕ�ʹ�� double����ָ���ľ���
		Shape shape = new RoundRectangle2D.Double(0, 0, 
				windowWidth, windowHeight, 6.5D, 6.5D);  
		AWTUtilities.setWindowShape(this, shape); 
		
		//�жϴ����Ƿ�͸��
		if(isWindowOpaque){
			//���ô�����ȫ��͸��
			AWTUtilities.setWindowOpaque(this, true);
		}else {
			//���ô���͸���ȣ�ȡֵ��Χ��0��1��͸�����𽥼�С
			AWTUtilities.setWindowOpacity(this, 0.8f);
		}
		
		//���ñ���ͼƬ
		JLabel loginbg = new JLabel(loginbgIcon);  
		loginbg.setBounds(0, 0, windowWidth, windowHeight);
		
		//��ӽ������
		this.add(loginbg);
		
		//��ӽ�����ק�ƶ�������
		this.addMouseListener(moveWindowListener);
		this.addMouseMotionListener(moveWindowListener); 
	}
	
	//������ק�ƶ��������ڲ���
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
