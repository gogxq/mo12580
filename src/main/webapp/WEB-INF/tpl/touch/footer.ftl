<div id="footer">
<ul>
	<#if action == "index">
		<li class="active"><a href="${contextPath}/index.do?channel=${channel}">首页</a></li>
	<#else>
		<li><a href="${contextPath}/index.do?channel=${channel}">首页</a></li>
	</#if>
	
  	<#if action == "brands">
		<li class="active"><a href="${contextPath}/brands.do?channel=${channel}">按品牌下载</a></li>	
	<#else>
		<li><a href="${contextPath}/brands.do?channel=${channel}">按品牌下载</a></li>
	</#if>
	
  	<#if action == "introduce">
		<li class="active"><a href="${contextPath}/introduce.do?channel=${channel}">升级日志</a></li>
	<#else>
		<li><a href="${contextPath}/introduce.do?channel=${channel}">升级日志</a></li>
	</#if>
  
  	<#if action == "agree">
		<li class="active"><a href="${contextPath}/agree.do?channel=${channel}">用户协议</a></li>
	<#else>
		<li><a href="${contextPath}/agree.do?channel=${channel}">用户协议</a></li>
	</#if>
 </ul>
 <div class="bigButton cf"><span class="touch">触屏版</span><a href="${contextPath}/index.do?v=2&channel=${channel}" class="color">彩版</a></div>
 <p><a href="http://m.12580.com">- 12580首页 -</a><span>&copy;2008-2013 中国移动12580</span></p>
</div>
</body>
</html>