<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" import="java.io.*,java.util.*,java.text.*" contentType="text/vnd.wap.wml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%
	System.out.println("12580_download#"+date+"#"+ip+"#"+uid+"#"+jar.substring(jar.indexOf("name=")+5, jar.length()));
%>
<%if(e.equals("1")){response.setContentType("text/vnd.wap.wml;charset=UTF-8");}else{response.setContentType("text/html;charset=UTF-8");}%>
<jsp:include page="<%=head %>" flush="true"/>
<p>
	您选择的Java平台：
</p>
<p>
</p>
<p>
	下载<%=jar_version %>通用版
	<br />
	<a href="<%=jar %>">[JAR]</a>
	<a href="<%=jad %>">[JAD]</a>
	<br />
	软件大小：<%=jar_size %>kb
	<br />
	更新时间：<%=jar_date %>
</p>
<p>
	-----------
</p>
<p>
	如果无法安装通用版，请尝试<br />
	下载<%=jar_mini_version %>精简版
	<br />
	<a href="<%=jar_mini %>">[JAR]</a>
	<a href="<%=jad_mini %>">[JAD]</a>
	<br />
	软件大小：<%=jar_mini_size %>kb
	<br />
	更新时间：<%=jar_mini_date %>
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