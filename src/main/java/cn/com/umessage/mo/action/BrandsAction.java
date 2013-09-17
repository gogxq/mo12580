package cn.com.umessage.mo.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.umessage.mo.service.GetCityService;
import cn.com.umessage.mo.service.VersionAdapterService;
import cn.com.umessage.mo.service.WeatherSearchService;
import cn.com.umessage.mo.utils.ContextPathUtils;
import cn.com.umessage.mo.utils.RemoteIpUtils;

@Controller
public class BrandsAction {

	@Autowired
	private VersionAdapterService versionService;
	@Autowired
	private WeatherSearchService weatherService;
	@Autowired
	private GetCityService cityService;
	
	@RequestMapping("brands.do")
	public Object brands(HttpServletRequest request){
		//TODO:改成从session读取
		String version = versionService.autoSelectVersion(request);
		String channel = request.getParameter("channel");
		if(channel == null){
			channel = "";
		}
		channel = request.getParameter("channel");
		String contextPath = ContextPathUtils.getContextPath(request);
		String view = version + "/brands";
		String ip = RemoteIpUtils.getIp(request);
		String cityId = cityService.getCityByIP(ip);
		String weatherPic = weatherService.getWeather(cityId);
		ModelMap model = new ModelMap();
		model.addAttribute("weatherPic", weatherPic);
		model.addAttribute("channel",channel);
		model.addAttribute("contextPath", contextPath);
		model.addAttribute("action","brands");
		return new ModelAndView(view,model);
	}
}