package cn.com.umessage.mo.domain;

import java.util.List;

public class WeatherDetail {
	//添加时间
		private String addtime;
		//天气大图片
		private List<String> bigimage;
		//中文日期
		private String cdate;
		//城市id
		private String cityid;
		//省+市全名
		private String cname;
		//省id
		private String provid;
		//序号
		private String seqnum;
		//温度
		private String temperature;
		//天气小图片
		private List<String> tinyimage;
		//预报日期
		private String weatdate;
		//天气
		private String weather;
		//风向
		private String weathervane;
		//风力
		private String windpower;
		//天气预报的汉语表示形式。如“阴”，“小雨等等”
		private String weatherKeyword;
		
		public List<String> getBigimage() {
			return bigimage;
		}
		public void setBigimage(List<String> bigimage) {
			this.bigimage = bigimage;
		}
		public List<String> getTinyimage() {
			return tinyimage;
		}
		public void setTinyimage(List<String> tinyimage) {
			this.tinyimage = tinyimage;
		}
		public String getAddtime() {
			return addtime;
		}
		public void setAddtime(String addtime) {
			this.addtime = addtime;
		}
		public String getCdate() {
			return cdate;
		}
		public void setCdate(String cdate) {
			this.cdate = cdate;
		}
		public String getCityid() {
			return cityid;
		}
		public void setCityid(String cityid) {
			this.cityid = cityid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getProvid() {
			return provid;
		}
		public void setProvid(String provid) {
			this.provid = provid;
		}
		public String getSeqnum() {
			return seqnum;
		}
		public void setSeqnum(String seqnum) {
			this.seqnum = seqnum;
		}
		public String getTemperature() {
			return temperature;
		}
		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}
		public String getWeatdate() {
			return weatdate;
		}
		public void setWeatdate(String weatdate) {
			this.weatdate = weatdate;
		}
		public String getWeather() {
			return weather;
		}
		public void setWeather(String weather) {
			this.weather = weather;
		}
		public String getWeathervane() {
			return weathervane;
		}
		public void setWeathervane(String weathervane) {
			this.weathervane = weathervane;
		}
		public String getWindpower() {
			return windpower;
		}
		public void setWindpower(String windpower) {
			this.windpower = windpower;
		}
		public String getWeatherKeyword() {
			return weatherKeyword;
		}
		public void setWeatherKeyword(String weatherKeyword) {
			this.weatherKeyword = weatherKeyword;
		}
		@Override
		public String toString() {
			return "WeatherDetail [addtime=" + addtime + ", bigimage="
					+ bigimage + ", cdate=" + cdate + ", cityid=" + cityid
					+ ", cname=" + cname + ", provid=" + provid + ", seqnum="
					+ seqnum + ", temperature=" + temperature + ", tinyimage="
					+ tinyimage + ", weatdate=" + weatdate + ", weather="
					+ weather + ", weathervane=" + weathervane + ", windpower="
					+ windpower + ", weatherKeyword=" + weatherKeyword + "]";
		}
	
		
}
