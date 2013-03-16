package com.im.client.utils;

import java.awt.Image;

import javax.swing.ImageIcon;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessage                                          
* Module ID:			3    
* Comments:  			��ȡͼƬ�����Ϣ������                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.utils                         
* Author��				Ellery                 
* Create Date��			2013-03-16 16:03 
* Modified By��			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 
public class GetImageUtils {

	//ͼƬ·��ǰ׺
	private static final String IMAGE_URL_PREFIX = "images/";
	
	/**
	 * Description: 	Icon�ӿڵ�ʵ�֣����� Image���� Icon��Ԥ�ظ��� URL��
	 * 					�ļ������ֽ����鴴����ͼ���Լ��Ӹ�ͼ��ļ���״̬��
	 * @param imgPath:	ͼƬʵ�ʴ��·��
	 * @return Icon��	icon
	 */
	public static ImageIcon getImageIcon(String imgPath){
		ImageIcon icon = null;
		try{
			icon = new ImageIcon(imgPath);
			return icon;
		}catch (Exception e){
			System.out.println("�Ҳ���ͼƬ�� " +imgPath );
		}
		return icon;
	}
	
	/**
	 * Description:			��ȡImage����ͼƬ
	 * @param imageName:	ͼƬ����
	 * @return Image��		
	 */
    public static Image getImage(String imageName) {
    	return new ImageIcon(getImageURL(imageName)).getImage();
    }
    
    /**
     * Description:			��ȡͼƬURL
     * @param imageName:	ͼƬ����
     * @return String:		����String����URL��ַ
     */
    public static String getImageURL(String imageName) {
        return IMAGE_URL_PREFIX + imageName;
    }
}