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
	//天气-多云转大雨
	private ImageIcon weather_cloudyToHeavyRainIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/cloudyToHeavyRain.png");
	//天气-多云转中雨
	private ImageIcon weather_cloudyToModerateRainIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/cloudyToModerateRain.png");
	//天气-多云转小雨
	private ImageIcon weather_cloudyToLightRainIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/cloudyToLightRain.png");
	//天气-晴有时小雨
	private ImageIcon weather_sunnyToRainIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunnyToRain.png");
	//天气-大雪
	private ImageIcon weather_heavySnowIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/heavySnow.png");
	//天气-中雪
	private ImageIcon weather_moderateSnowIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/moderateSnow.png");
	//天气-小雪
	private ImageIcon weather_snowIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/snow.png");
	//天气-雨夹雪
	private ImageIcon weather_sleetIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sleet.png");
	//天气-晴
	private ImageIcon weather_sunnyIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunny.png");
	//天气-晴转多云
	private ImageIcon weather_sunnyToCloudyIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunnyToCloudy.png");
	//天气-晴有雾
	private ImageIcon weather_sunnyToFogIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunnyToFog.png");
	//天气-晴转大学
	private ImageIcon weather_sunnyToHeavySnowIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunnyToHeavySnow.png");
	//天气-晴转小雪
	private ImageIcon weather_sunnyToLightSnowIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunnyToLightSnow.png");
	//天气-晴转中雪
	private ImageIcon weather_sunnyToModerateSnowIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/sunnyToModerateSnow.png");
	//天气-雷阵雨
	private ImageIcon weather_thunderstormsIcon = ImageManageUtils.getImageIcon("images/frame/main/weather/thunderstorms.png");
	
	public WeatherUtils(String currentWeatherStatus){
		this.currentWeatherStatus = currentWeatherStatus;
	}
	
	public Weather getCurrentWeatherInfo(){
		
		weather = new Weather();
		
		if("cloudy".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_cloudyIcon);
			weather.setWeatherName("多云");
		}else if("cloudyToHeavyRain".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_cloudyToHeavyRainIcon);
			weather.setWeatherName("多云转大雨");
		}else if("cloudyToModerateRain".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_cloudyToModerateRainIcon);
			weather.setWeatherName("多云转中雨");
		}else if("cloudyToLightRain".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_cloudyToLightRainIcon);
			weather.setWeatherName("多云转小雨");
		}else if("sunnyToRain".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyToRainIcon);
			weather.setWeatherName("晴有小雨");
		}else if("heavySnow".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_heavySnowIcon);
			weather.setWeatherName("大雪");
		}else if("moderateSnow".equals(currentWeatherStatus)){

			weather.setWeatherImageIcon(weather_moderateSnowIcon);
			weather.setWeatherName("中雪");
		}else if("snow".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_snowIcon);
			weather.setWeatherName("小雪");
			
		}else if("sleet".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sleetIcon);
			weather.setWeatherName("雨夹雪");
		}else if("sunny".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyIcon);
			weather.setWeatherName("晴");
		}else if("sunnyToCloudy".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyToCloudyIcon);
			weather.setWeatherName("晴有时多云");
		}else if("sunnyToFog".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyToFogIcon);
			weather.setWeatherName("晴有雾");
		}else if("sunnyToHeavySnow".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyToHeavySnowIcon);
			weather.setWeatherName("晴转大雪");
		}else if("sunnyToModerateSnow".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyToModerateSnowIcon);
			weather.setWeatherName("晴转中雪");
		}else if("sunnyToLightSnow".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_sunnyToLightSnowIcon);
			weather.setWeatherName("晴有小雪");
		}else if("thunderstorms".equals(currentWeatherStatus)){
			
			weather.setWeatherImageIcon(weather_thunderstormsIcon);
			weather.setWeatherName("雷阵雨");
		}
		
		return weather;
	}

}
