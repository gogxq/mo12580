package cn.com.umessage.mo.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.umessage.mo.service.DownloadService;
import cn.com.umessage.mo.service.GetCityService;
import cn.com.umessage.mo.service.VersionAdapterService;
import cn.com.umessage.mo.service.WeatherSearchService;
import cn.com.umessage.mo.utils.ContextPathUtils;
import cn.com.umessage.mo.utils.RemoteIpUtils;

@Controller
public class DownloadAction {
	
	private static final String ANDROID_NEWEST_VERSION = "2_6_5";
	private static final String IPHONE_NEWEST_VERSION = "2.6.5";
	
	@Autowired
	private VersionAdapterService versionService;
	
	@Autowired
	private DownloadService downloadService;
	
	@Autowired
	private WeatherSearchService weatherService;
	
	@Autowired
	private GetCityService cityService;
	
	@RequestMapping("download.do")
	public Object downloadByPlat(HttpServletRequest request){
		String version = versionService.autoSelectVersion(request);
		String channel = request.getParameter("channel");
		if(channel == null){
			channel = "";
		}
		String contextPath = ContextPathUtils.getContextPath(request);
		String view = version + "/down";
		String ip = RemoteIpUtils.getIp(request);
		String cityId = cityService.getCityByIP(ip);
		String weatherPic = weatherService.getWeather(cityId);
		ModelMap model = new ModelMap();
		model.addAttribute("weatherPic", weatherPic);
		model.addAttribute("channel",channel);
		model.addAttribute("contextPath", contextPath);
		model.addAttribute("action","");
		return new ModelAndView(view,model);
	}
	
	@RequestMapping("newest.do")
	public void download_newest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String platform = request.getParameter("platform");
		//渠道
		String channel = "";
		channel = request.getParameter("channel");
		if(platform.equals("andriod")){
			downloadService.download_android(ANDROID_NEWEST_VERSION,channel,response);
		}else if(platform.equals("iphone")){
			downloadService.download_iphone(IPHONE_NEWEST_VERSION,channel,response);
		}else{
			//增加日志
		}
	}
	
	@RequestMapping("downloadbyversion.do")
	public void downloadByVersion(HttpServletRequest request,HttpServletResponse response){
		String version = request.getParameter("version");
		String channel = "";
		channel = request.getParameter("channel");
		downloadService.download_android(version, channel, response);
	}
}
