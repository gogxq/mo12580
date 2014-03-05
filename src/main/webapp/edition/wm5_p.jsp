<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/vnd.wap.wml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%if(e.equals("1")){response.setContentType("text/vnd.wap.wml;charset=UTF-8");}else{response.setContentType("text/html;charset=UTF-8");}%>
<jsp:include page="<%=head %>" flush="true"/>
<p>
	您选择的WindowsMobile平台：
</p>
<p>
	适用于使用微软WindowsMobile5.0及以上操作系统的机型(触摸屏)
</p>
<p>
	<a href="<%=wm5_p %>">下载<%=wm5_p_version %>版</a>
	<br />
	软件大小：<%=wm5_p_size %>kb
	<br />
	更新时间：<%=wm5_p_date %>
</p>
<p>
	<a href="<%=wm5_g %>">下载<%=wm5_g_version %>版(480x640)</a>
	<br />
	软件大小：<%=wm5_g_size %>kb
	<br />
	更新时间：<%=wm5_g_date %>
</p>
<p>
	-----------
</p>
<p>
	<a href="<%=about %>">【软件介绍】</a>
</p>
<p>
	<a href="<%=index %>">返回首页</a>
</p>
<jsp:include page="<%=tail %>" flush="true"/>