package com.im.client.utils;

import java.util.Calendar;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			3    
* Comments:  			获取当前时间工具类                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.utils                         
* Author：				Ellery                 
* Create Date：			2013-04-29 21:37 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/

public class DateUtils {
	
	Calendar rightNow = Calendar.getInstance();

	//获取当前日期小时
	public String getCurrentHours(){
		
		int hourOfDay = rightNow.get(Calendar.HOUR_OF_DAY);
		
		if(hourOfDay >= 5 && hourOfDay <= 8){
			return "morning";
		}else if(hourOfDay >= 16 && hourOfDay <= 18){
			return "afternoon";
		}else if(hourOfDay >= 19 || hourOfDay <= 4){
			return "night";
		}else{
			return "noon";
		}
		
	}
}
