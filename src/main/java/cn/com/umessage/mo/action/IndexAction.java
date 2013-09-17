package cn.com.umessage.mo.action;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import cn.com.umessage.mo.domain.WeatherResult;
import cn.com.umessage.mo.service.GetCityService;
import cn.com.umessage.mo.service.VersionAdapterService;
import cn.com.umessage.mo.service.WeatherSearchService;
import cn.com.umessage.mo.utils.ContextPathUtils;
import cn.com.umessage.mo.utils.RemoteIpUtils;
import cn.com.umessage.mo.utils.WeatherCache;

@Controller
public class IndexAction {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);
	
	@Autowired
	private VersionAdapterService versionService;
	
	@Autowired
	private WeatherSearchService weatherService;
	
	@Autowired
	private GetCityService cityService;
	
	@RequestMapping("index.do")
	public Object index(HttpServletRequest request){
		String version = versionService.autoSelectVersion(request);
		String channel = request.getParameter("channel");
		if(channel == null){
			channel = "";
		}
		String view = version + "/index";
		String contextPath = ContextPathUtils.getContextPath(request);
		//城市
		String ip = RemoteIpUtils.getIp(request);
		String cityId = cityService.getCityByIP(ip);
		logger.info("cityId:"+cityId);
		
		//天气图片
		String weatherPic = weatherService.getWeather(cityId);
		
		ModelMap model = new ModelMap();
		model.addAttribute("weatherPic", weatherPic);
		model.addAttribute("contextPath", contextPath);
		model.addAttribute("channel",channel);
		
		model.addAttribute("action","index");
		return new ModelAndView(view,model);
	}
}
