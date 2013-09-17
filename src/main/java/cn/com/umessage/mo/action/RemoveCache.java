package cn.com.umessage.mo.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.umessage.mo.utils.WeatherCache;

@Controller
public class RemoveCache {
	
	/**
	 * 每日凌晨更新天气缓存
	 */
	@RequestMapping("removeWeatherCache.do")
	public Object removeWeatherCache(){
		WeatherCache.removeWeatherInfo();
		String view = "removeWeatherCache";
		ModelMap model = new ModelMap();
		model.addAttribute("status", "天气缓存清除成功");
		return new ModelAndView(view,model);
	}
}
