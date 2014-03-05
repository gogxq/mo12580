package cn.com.umessage.mo.domain;

import java.util.List;

public class WeatherResponse {

	private String cityid;
	private String city_name;
	private String max_temperature;
	private String min_temperature;
	private List<String> weatherPicList;
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getMax_temperature() {
		return max_temperature;
	}
	public void setMax_temperature(String max_temperature) {
		this.max_temperature = max_temperature;
	}
	public String getMin_temperature() {
		return min_temperature;
	}
	public void setMin_temperature(String min_temperature) {
		this.min_temperature = min_temperature;
	}
	public List<String> getWeatherPicList() {
		return weatherPicList;
	}
	public void setWeatherPicList(List<String> weatherPicList) {
		this.weatherPicList = weatherPicList;
	}
	@Override
	public String toString() {
		return "WeatherResponse [cityid=" + cityid + ", city_name=" + city_name
				+ ", max_temperature=" + max_temperature + ", min_temperature="
				+ min_temperature + ", weatherPicList=" + weatherPicList + "]";
	}
	
}
