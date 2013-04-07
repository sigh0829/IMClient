package com.im.client.utils;

import javax.swing.ImageIcon;

import com.im.client.dto.Weather;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			天气处理类                                           
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.utils                        
* Author：				Ellery                 
* Create Date：			2011-04-03 23:31 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 
public class WeatherUtils {
	
	private String currentWeatherStatus = null;
	private Weather weather = null;
	//天气-多云
	private ImageIcon weather_cloudyIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/cloudy.png");
	//天气-晴有时小雨
	private ImageIcon weather_sunnyToRainIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunny_to_rain.png");
	//天气-小雪
	private ImageIcon weather_snowIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/snow.png");
	//天气-晴
	private ImageIcon weather_sunnyIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunny.png");
	//天气-雨
	private ImageIcon weather_rainIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/rain.png");
	//天气-晴转多云
	private ImageIcon weather_sunnyToCloudyIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunny_to_cloudy.png");
	//天气-雷阵雨
	private ImageIcon weather_thunderstormsIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/thunderstorms.png");
	//天气-台风
	private ImageIcon weather_typhoonIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/typhoon.png");
	//天气-沙尘暴
	private ImageIcon weather_sandstormsIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sandstorms.png");
	
	public WeatherUtils(String currentWeatherStatus){
		this.currentWeatherStatus = currentWeatherStatus;
	}
	
	public Weather getCurrentWeatherInfo(){
		
		weather = new Weather();
		
		if("cloudy".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_cloudyIcon);
			weather.setWeatherName("多云");
		}else if("sunnyToRain".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyToRainIcon);
			weather.setWeatherName("晴有小雨");
		}else if("snow".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_snowIcon);
			weather.setWeatherName("小雪");
			
		}else if("sunny".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyIcon);
			weather.setWeatherName("晴");
		}else if("sunnyToCloudy".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyToCloudyIcon);
			weather.setWeatherName("晴有时多云");
		}else if("thunderstorms".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_thunderstormsIcon);
			weather.setWeatherName("雷阵雨");
		}else if("typhoon".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_typhoonIcon);
			weather.setWeatherName("台风");
		}else if("sandstorms".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sandstormsIcon);
			weather.setWeatherName("沙尘暴");
		}else if("rain".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_rainIcon);
			weather.setWeatherName("小雨");
		}
		
		return weather;
	}

}
