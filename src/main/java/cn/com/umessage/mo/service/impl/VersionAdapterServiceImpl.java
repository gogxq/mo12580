package cn.com.umessage.mo.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.com.umessage.mo.service.VersionAdapterService;

@Service
public class VersionAdapterServiceImpl implements VersionAdapterService {

	@Override
	public String autoSelectVersion(HttpServletRequest request) {
		String agent = request.getHeader("user-agent");
		String v = request.getParameter("v");
		String version = "";
		if(v == null){
			if(request.getSession().getAttribute("version") == null){
				if(agent.equals("") && agent != null){
					if(agent.indexOf("iphone") == -1){
						version = "color";
					}else{
						version = "touch";
					}
				}else{
					version = "touch";
				}
			}else{
				version = (String) request.getSession().getAttribute("version");
			}
		}else if(v.equals("3")){
			version = "touch";
		}else{
			version = "color";
		}
		setVersion(request,version);
		return version;
	}
	
	private void setVersion(HttpServletRequest request,String version){
		request.getSession().setAttribute("version", version);
	}
}
