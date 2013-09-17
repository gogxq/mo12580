package cn.com.umessage.mo.utils;

import javax.servlet.http.HttpServletRequest;

public class RemoteIpUtils {
	
	private static String ip;
	
	public static String getIp(HttpServletRequest request){
		if(ip == null || ip.equals("")){
			putIp(request);
		}
		
		return ip;
	}
	
	public static void putIp(HttpServletRequest request){
		if(request.getHeader("x-forwarded-for") == null){
			ip = request.getRemoteAddr();
		}else{
			ip = request.getHeader("x-forwarder-for");
		}
	}
}
