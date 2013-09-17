package cn.com.umessage.mo.domain;

import java.util.List;


public class WeatherResult {
	
	private String status;//状态码:返回状态0正常放回 1输入参数错误 2没有查询结果 3其它未知错误 4敏感词过滤返回
	private List<WeatherDetail> weatherList;//天气详情
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<WeatherDetail> getWeatherList() {
		return weatherList;
	}
	public void setWeatherList(List<WeatherDetail> weatherList) {
		this.weatherList = weatherList;
	}
	@Override
	public String toString() {
		return "WeatherResult [status=" + status + ", weatherList="
				+ weatherList + "]";
	}
	
}