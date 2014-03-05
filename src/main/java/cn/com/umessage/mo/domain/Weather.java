package cn.com.umessage.mo.domain;

import java.io.Serializable;

import org.apache.commons.digester3.annotations.rules.BeanPropertySetter;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;


/**
 * 天气详情抽象
 * 
 * @author wm
 * 
 */
@ObjectCreate(pattern = "allresult/searchresults/weatherinfo/resultlist/result")
public class Weather extends ServiceResponse implements Serializable {
	private static final long serialVersionUID = -6599465596467203977L;

	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/seqnum")
	private String seqNum;
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/provid")
	private String provId;// 省ID
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/cityid")
	private String cityId;// 城市ID
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/cname")
	private String cname; // 省市名称
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/weatdate")
	private String weatdate;// 天气预报时间
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/cdate")
	private String cdate; // 中文日期
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/weather")
	private String weather;// 天气
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/weathervane")
	private String weatherVane;// 风向
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/windpower")
	private String windpower;// 风力
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/temperature")
	private String temperature;// 温度
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/resultlist/result/addtime")
	private String addTime;// 更新日期

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public String getProvId() {
		return provId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getWeatdate() {
		return weatdate;
	}

	public void setWeatdate(String weatdate) {
		this.weatdate = weatdate;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getWeatherVane() {
		return weatherVane;
	}

	public void setWeatherVane(String weatherVane) {
		this.weatherVane = weatherVane;
	}

	public String getWindpower() {
		return windpower;
	}

	public void setWindpower(String windpower) {
		this.windpower = windpower;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

}
