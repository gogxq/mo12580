package cn.com.umessage.mo.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import cn.com.umessage.mo.domain.AreaDetail;
import cn.com.umessage.mo.service.GetCityService;
import cn.com.umessage.mo.utils.HttpUtils;

@Service
public class GetCityServiceImpl implements GetCityService {

	private static final String MISDN_AREA_URL = "http://strategy.intra.umessage.com.cn:8180/WebDataHandler/phoneArea.search?";
	
	@Override
	public String getCityByIP(String ip) {
		StringBuilder uri = publicurl();
		uri.append("theip=" + ip);
		uri.append("&pt=2&at=4");
		String result = HttpUtils.fromRemoteStr(uri.toString(), "utf-8");
		AreaDetail area = this.areaStrToXml(result);
		String city_id = area.getCity_id();
		if(city_id == null || city_id.equals("")){
			city_id = "10000000";
		}
		return city_id;
	}
	
	/**
	 * 头部分url
	 */
	public StringBuilder publicurl(){
		StringBuilder uri = new StringBuilder(MISDN_AREA_URL);
		return uri;
	}

	@Override
	public AreaDetail areaStrToXml(String resultStr) {
		AreaDetail areaDetail = new AreaDetail();
		try {
			InputStream in = new ByteArrayInputStream(resultStr.getBytes());
			InputStreamReader utf8In = new InputStreamReader(in);
		
			Document document = new SAXReader().read(utf8In);
			Element root = document.getRootElement();
			Element searchresults = root.element("searchresults");
			Element phonearea = searchresults.element("phonearea");
			Element resultlist = phonearea.element("resultlist");
			Element result = resultlist.element("result");
			areaDetail.setIp(result.element("theip").getText());
			areaDetail.setProv_id(result.element("prov_id").getText());
			areaDetail.setProv_name(result.element("prov_name").getText());
			areaDetail.setCity_id(result.element("city_id").getText());
			areaDetail.setCity_name(result.element("city_name").getText());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return areaDetail;
	}

	
}
