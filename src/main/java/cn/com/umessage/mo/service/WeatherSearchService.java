package cn.com.umessage.mo.service;

import cn.com.umessage.mo.domain.WeatherResult;


public interface WeatherSearchService {
	
	//获取天气
	public String getWeather(String city_id);
	
	//通过城市id获取天气
	public String getWeatherByCityId(String city_id);

	public WeatherResult weatherStrToXML(String weatherInfoXml);

}