package cn.com.umessage.mo.service;

import cn.com.umessage.mo.domain.AreaDetail;

public interface GetCityService {
	
	//通过IP地址获取城市
	public String getCityByIP(String ip);
	
	public AreaDetail areaStrToXml(String resultStr); 
}
