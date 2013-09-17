<%@page language="java" import="java.io.*,java.util.*,java.text.*,cn.com.umessage.mo.utils.DownloadPathUtils" contentType="text/vnd.wap.wml;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name")==null?"":request.getParameter("name");
	name = name.replaceAll("/", "");
	if(name.startsWith("12580_")||name.startsWith("wap_")) {
		String uid = request.getParameter("uid")==null?"":request.getParameter("uid");
		String ip = request.getRemoteAddr();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		System.out.println("12580_download#"+date+"#"+ip+"#"+uid+"#"+name);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file = new File(cn.com.umessage.mo.utils.DownloadPathUtils.getPathByName(name));
			response.reset();
			response.setContentLength((int)file.length());
			if(name.endsWith("sis")) {
				response.setContentType("application/vnd.symbian.install");
			} else if(name.endsWith("apk")) {
				response.setContentType("application/vnd.android.package-archive");
			} else if(name.endsWith("jad")) {
				response.setContentType("text/vnd.sun.j2me.app-descriptor");
			} else if(name.endsWith("jar")) {
				response.setContentType("application/java-archive");
			} else {
				response.setContentType("application/x-download");
			}
			response.setHeader("Content-disposition","attachment;filename="+name);
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			response.flushBuffer();
			out.clear();
			out = pageContext.pushBody();
		} catch(Exception exception) {
			System.out.println("wap下载异常:"+exception);
		} finally {
			try {
				if(bis != null) {
					bis.close();
				}
				if(bos != null) {
					bos.close();
				}
			} catch(Exception exception) {
				System.out.println("wap下载,关闭流异常:"+exception);
			}
		}
	} else {
		String url = "http://mo.12580.com";
		response.sendRedirect(url);
	}
%>