package cn.com.umessage.mo.service;

import java.util.List;

import cn.com.umessage.mo.domain.WeatherResponse;


public interface WeatherSearchService {
	
	//获取天气
	public WeatherResponse getWeather(String city_id);
	
	//通过城市id获取天气
	public String getWeatherByCityId(String city_id);
}
