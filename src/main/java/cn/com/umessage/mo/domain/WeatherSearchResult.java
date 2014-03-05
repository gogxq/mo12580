package cn.com.umessage.mo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester3.annotations.rules.BeanPropertySetter;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;


/**
 * 天气预报结果抽象
 * 
 * @author wm
 * 
 */
@ObjectCreate(pattern = "allresult/searchresults/weatherinfo")
public class WeatherSearchResult extends ServiceResponse implements
		Serializable {
	private static final long serialVersionUID = -657851223436802705L;

	private List<Weather> items;

	@SetNext(value = Weather.class)
	public void addItesm(Weather weather) {
		if (items == null) {
			items = new ArrayList<Weather>();
		}
		items.add(weather);
	}

	public List<Weather> getItems() {
		return items;
	}

	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/status")
	private String status;
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/total")
	private String total;
	@BeanPropertySetter(pattern = "allresult/searchresults/weatherinfo/count")
	private int count;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setItems(List<Weather> items) {
		this.items = items;
	}

}
