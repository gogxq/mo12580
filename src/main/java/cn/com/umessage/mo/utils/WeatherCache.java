package cn.com.umessage.mo.utils;

import java.util.HashMap;
import java.util.Map;

public class WeatherCache {

	private static Map<String,String> weatherInfo = new HashMap<String,String>();
	//读写标志
	private static volatile boolean flag = false;
	
	public static String getWeatherInfo(String key){
		while(flag){}
		return weatherInfo.get(key);
	}
	
	public static void setWeatherInfo(String cityid,String weatherPic){
		while(flag){}
		weatherInfo.put(cityid, weatherPic);
	}
	
	public static void removeWeatherInfo(){
		flag = true;
		weatherInfo.clear();
		flag = false;
	}
}
