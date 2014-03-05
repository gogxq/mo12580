<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/vnd.wap.wml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%if(e.equals("1")){response.setContentType("text/vnd.wap.wml;charset=UTF-8");}else{response.setContentType("text/html;charset=UTF-8");}%>
<jsp:include page="<%=head %>" flush="true"/>
<p>
	“惠生活”系统软件为用户提供优惠券、搜索、以及用户所在地理位置周边所有关于生活的吃、喝、玩、乐信息和折扣优惠。
</p>
<p>
	<a href="<%=android_live %>">下载<%=android_live_version %></a>
	<br />
	软件大小：<%=android_live_size %>kb
	<br />
	更新时间：<%=android_live_date %>
</p>
<p>
	-----------
</p>
<p>
	【惠生活软件免责声明】
</p>
<p>
	"12580惠生活软件的相关信息是最初发布的信息，如有更改，恕不另行通知。使用本软件涉及到互联网服务和移动通信服务，可能会受到各个环节不稳定因素的影响，存在因不可抗力、计算机病毒、黑客攻击、系统不稳定、用户所在位置、用户关机以及其他任何网络、技术、通信线路等原因造成的服务中断或不能满足用户要求的风险，用户须明白并自行承担以上风险，用户因此不能发送或接受阅读信息，或接、发错信息，我们不承担任何责任。软件可能与最终版本的软件的运行方式不同。软件中的特征和功能可能不会在最终版本的软件中出现。如下载本软件，则视为下载者认同《免责声明》
</p>
<p>
	<a href="<%=index %>">返回首页</a>
</p>
<jsp:include page="<%=tail %>" flush="true"/>