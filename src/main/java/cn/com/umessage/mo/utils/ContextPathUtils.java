package cn.com.umessage.mo.utils;

import javax.servlet.http.HttpServletRequest;

public class ContextPathUtils {
	/**
	 * 获取请求路径
	 */
	public static String getContextPath(HttpServletRequest request){
		String contextPath = request.getContextPath();
		StringBuffer requrl = request.getRequestURL();
		String requri = request.getRequestURI();
		int index = requrl.indexOf(requri);
		String path = requrl.substring(0,index) + contextPath;
		return path;
	}
}
