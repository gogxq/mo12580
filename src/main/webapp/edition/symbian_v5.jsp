<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/vnd.wap.wml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%if(e.equals("1")){response.setContentType("text/vnd.wap.wml;charset=UTF-8");}else{response.setContentType("text/html;charset=UTF-8");}%>
<jsp:include page="<%=head %>" flush="true"/>
<p>
	您选择的SymbianS60平台V5版：
</p>
<p>
	适用于诺基亚、三星等品牌的SymbianS60平台V5版的机型
</p>
<p>
	<a href="<%=symbian_v5 %>">下载<%=symbian_v5_version %>版</a>
	<br />
	软件大小：<%=symbian_v5_size %>kb
	<br />
	更新时间：<%=symbian_v5_date %>
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