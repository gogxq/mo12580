package cn.com.umessage.mo.utils;

import java.util.HashMap;
import java.util.Map;

import cn.com.umessage.mo.domain.WeatherResponse;


public class WeatherCache {
	
	private static Map<String,WeatherResponse> weatherInfoMap = new HashMap<String,WeatherResponse>();
	//读写标志
	private static volatile boolean flag = false;
	
	public static WeatherResponse getWeatherInfo(String key){
		while(flag){}
		return weatherInfoMap.get(key);
	}
	
	public static void setWeatherInfo(String cityid,WeatherResponse weatherInfo){
		while(flag){}
		weatherInfoMap.put(cityid, weatherInfo);
	}
	
	public static void removeWeatherInfo(){
		flag = true;
		weatherInfoMap.clear();
		flag = false;
	}
}