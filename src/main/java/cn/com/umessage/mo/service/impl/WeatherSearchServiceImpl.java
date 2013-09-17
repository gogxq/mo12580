package cn.com.umessage.mo.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import cn.com.umessage.mo.domain.WeatherDetail;
import cn.com.umessage.mo.domain.WeatherResult;
import cn.com.umessage.mo.service.WeatherSearchService;
import cn.com.umessage.mo.utils.HttpUtils;
import cn.com.umessage.mo.utils.WeatherCache;

@Service("weatherSearch")
public class WeatherSearchServiceImpl implements WeatherSearchService {

	private String WEATHER_SEARCH_URL = "http://strategy.intra.umessage.com.cn:8180/WebDataHandler/weather.search?vt=2&pid=u05";
	private Integer days = 1;
	
	@Override
	public String getWeather(String city_id) {
		
		String weatherPic = WeatherCache.getWeatherInfo(city_id);
		
		if(weatherPic == null || weatherPic.equals("")){
			String weatherInfoXml = getWeatherByCityId(city_id);
			WeatherResult result = weatherStrToXML(weatherInfoXml);
			weatherPic = result.getWeatherList().get(0).getBigimage().get(0);
			WeatherCache.setWeatherInfo(city_id, weatherPic);
			System.out.println("=========== no weather cache ======");
		}
		return weatherPic;
	}
	
	@Override
	public String getWeatherByCityId(String city_id) {
		StringBuilder uri = getUri();
		uri.append("&lci=" + city_id);
		String result = HttpUtils.fromRemoteStr(uri.toString(), "utf-8");
		return result;
	}

	private StringBuilder getUri(){
		return new StringBuilder(WEATHER_SEARCH_URL);
	}
	
	public WeatherResult weatherStrToXML(String resultXML) {
		WeatherResult weather_res = new WeatherResult();
		try {
			List<WeatherDetail> list = new ArrayList<WeatherDetail>();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
			int hh = Integer.parseInt(simpleDateFormat.format(new Date()));

			InputStream in = new ByteArrayInputStream(resultXML.getBytes());
			InputStreamReader utf8In = new InputStreamReader(in);

			Document document = new SAXReader().read(utf8In);
			Element root = document.getRootElement();
			Element searchresults = root.element("searchresults");
			Element weatherinfo = searchresults.element("weatherinfo");
			Element resultlist = weatherinfo.element("resultlist");
			Iterator resultIt = resultlist.elementIterator("result");
			int index = 0;
			while (resultIt.hasNext() && index < days) {
				WeatherDetail wDetail = new WeatherDetail();
				Element result = (Element) resultIt.next();
				// 省id
				wDetail.setProvid(result.element("provid").getText());
				// 城市id
				wDetail.setCityid(result.element("cityid").getText());
				// 省+市全名
				wDetail.setCname(result.element("cname").getText());
				// 预报日期
				wDetail.setWeatdate(result.element("weatdate").getText());
				// 中文日期
				wDetail.setCdate(result.element("cdate").getText());
				// 天气
				String weather = result.element("weather").getText();
				// 风向
				String weathervane = result.element("weathervane").getText();
				weathervane = weathervane.replaceAll("旋转风", "旋x风");
				// 风力
				String windpower = result.element("windpower").getText();

				// 分割天气
				String[] weathers = cutWeather(weather);
				String[] weathervanes = weathervane.split("转");
				String[] windpowers = windpower.split("转");
				// String weatherImage = weather;
				// if (weathers.length >= 2) {
				// if (hh >= 6 && hh < 18) {
				// weatherImage = weathers[0];
				// } else {
				// weatherImage = weathers[1];
				// }
				// }
				// wDetail.setWeatherKeyword(weatherImage);

				if (weathervanes.length == 2) {
					if (hh >= 6 && hh < 18) {
						weathervane = weathervanes[0];
					} else {
						weathervane = weathervanes[1];
					}
				}
				if (windpowers.length == 2) {
					if (hh >= 6 && hh < 18) {
						windpower = windpowers[0];
					} else {
						windpower = windpowers[1];
					}
				}
				weathervane = weathervane.replaceAll("旋x风", "旋转风");
				weathervane = weathervane.replaceAll("无持续风向", "");
				if (weathers.length >= 2) {
					wDetail.setWeather(weathers[0] + "转" + weathers[1]);
				} else {
					wDetail.setWeather(weather);
				}
				wDetail.setWeathervane(weathervane);
				wDetail.setWindpower(windpower);
				// 温度
				String temperature = result.element("temperature").getText();
				temperature = temperature.replaceAll("度", "");
				temperature = temperature.replaceAll("零下", "-");
				temperature = temperature.replaceAll("最低气温", "");
				temperature = temperature.replaceAll("最高气温", "");
				String[] temperatures = temperature.split(",");
				if (temperatures.length == 2) {
					wDetail.setTemperature(temperatures[1] + "/" + temperatures[0]);
				} else {
					wDetail.setTemperature(temperature.replaceAll(",", "/"));
				}
				// 添加时间
				wDetail.setAddtime(result.element("addtime").getText());
				// 处理图片名称
				List<String> bigimage = new ArrayList<String>();
				List<String> tinyimage = new ArrayList<String>();
				for (int ii = 0; ii < weathers.length; ii++) {
					String image = Base64.encodeBase64String(weathers[ii].getBytes("UTF-8")).replaceAll("/", "#") + ".png";
					image = URLEncoder.encode(image, "UTF-8").replaceAll("%2B", "");
					// 转化小写
					char[] zimu = image.toCharArray();
					for (int i = 0; i < zimu.length; i++) {
						if (zimu[i] >= 'A' && zimu[i] <= 'Z')
							zimu[i] = (char) (zimu[i] + 32);
					}
					image = String.valueOf(zimu);
					// if (hh > 5 && hh < 18) {
					image = "day_" + image; // 暂时只返回白天的天气图标
					// } else {
					// if (index == 0) {
					// image = "night_" + image;
					// } else {
					// image = "day_" + image;
					// }
					// }
					bigimage.add("big_" + image);
					tinyimage.add("tiny_" + image);
				}
				//logger.info("current weather=" + Arrays.toString(weathers) + "++++++++++++bigimage={}++++++++++++++++++++tinyimage={}", bigimage.toString(), tinyimage.toString());
				wDetail.setBigimage(bigimage);
				wDetail.setTinyimage(tinyimage);
				list.add(wDetail);
				++index;
			}
			weather_res.setWeatherList(list);
			weather_res.setStatus(weatherinfo.element("status").getText());
		} catch (Exception ex) {
			//LogUtil.logerror(ex, logger);
		}
		return weather_res;
	}
	
	private String[] cutWeather(String weather) {
		// logger.info("............the weather2Cut is:{}",weather);
		String[] data = weather.split("转");
		for (int i = 0; i < data.length; i++) {
			String[] str = data[i].split("-");
			if (str.length >= 2) {
				data[i] = str[0].substring(0, str[0].length() - 1) + "到" + str[1];// "中雨-大雨"---->"中到大雨"
			}
		}
		return data;
	}
}
