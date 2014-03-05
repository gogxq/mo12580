package cn.com.umessage.mo.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.umessage.mo.action.IndexAction;

/**
 * mobile站二维码跳转处理
 * @author guoxq
 *
 */

public class Download extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(Download.class);
	
	private static final long serialVersionUID = 3043397727513969094L;
	String regex = "(iPhone|Andriod)";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
			doPost(req, resp);
			}

			protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
			String ua = req.getHeader("User-Agent");
			Pattern p = Pattern.compile(this.regex, 2);
			Matcher m = p.matcher(ua);

			int plat = 0;
			if (m.find()) {
			String name = m.group(1);
			if ("iPhone".equalsIgnoreCase(name)) {
			plat = 1;
			}
			}
			logger.info(ua);
			if (plat == 0)
			resp.sendRedirect("http://mo.12580.com/download.jsp?name=12580_android_2_6_9_A001.apk&uid=&channel=3007");
			else
			resp.sendRedirect("http://itunes.apple.com/cn/app/id427742159?mt=8");
			} 
}