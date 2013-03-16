package com.im.client.utils;

import java.awt.Image;

import javax.swing.ImageIcon;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			3    
* Comments:  			获取图片相关信息工具类                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.utils                         
* Author：				Ellery                 
* Create Date：			2011-03-16 16:03 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 
public class GetImageUtils {

	//图片路径前缀
	private static final String IMAGE_URL_PREFIX = "images/";
	
	/**
	 * Description: 	Icon接口的实现，根据 Image绘制 Icon，预载根据 URL、
	 * 					文件名或字节数组创建的图像，以监视该图像的加载状态。
	 * @param imgPath:	图片实际存放路径
	 * @return Icon：	icon
	 */
	public static ImageIcon getImageIcon(String imgPath){
		ImageIcon icon = null;
		try{
			icon = new ImageIcon(imgPath);
			return icon;
		}catch (Exception e){
			System.out.println("找不到图片： " +imgPath );
		}
		return icon;
	}
	
	/**
	 * Description:			获取Image类型图片
	 * @param imageName:	图片名称
	 * @return Image：		
	 */
    public static Image getImage(String imageName) {
    	return new ImageIcon(getImageURL(imageName)).getImage();
    }
    
    /**
     * Description:			获取图片URL
     * @param imageName:	图片名称
     * @return String:		返回String类型URL地址
     */
    public static String getImageURL(String imageName) {
        return IMAGE_URL_PREFIX + imageName;
    }
}