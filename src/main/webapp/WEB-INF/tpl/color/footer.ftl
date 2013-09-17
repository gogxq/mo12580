<div id="footer">
	<div id="nav">
		<#if action == "index">
			<a href="${contextPath}/index.do?channel=${channel}" class="active">首页</a>
		<#else>
			<a href="${contextPath}/index.do?channel=${channel}">首页</a>
		</#if>
		
		<#if action == "brands">
			<span>&nbsp;|&nbsp;</span><a href="${contextPath}/brands.do?channel=${channel}" class="active">按品牌下载</a>
		<#else>
			<span>&nbsp;|&nbsp;</span><a href="${contextPath}/brands.do?channel=${channel}">按品牌下载</a>
		</#if>
		
		<#if action == "introduce">
			<span>&nbsp;|&nbsp;</span><a href="${contextPath}/introduce.do?channel=${channel}" class="active">升级日志</a>
		<#else>
			<span>&nbsp;|&nbsp;</span><a href="${contextPath}/introduce.do?channel=${channel}">升级日志</a>
		</#if>
		
		<#if action == "agree">
			<span>&nbsp;|&nbsp;</span><a href="${contextPath}/agree.do?channel=${channel}" class="active">用户协议</a>
		<#else>
			<span>&nbsp;|&nbsp;</span><a href="${contextPath}/agree.do?channel=${channel}">用户协议</a>
		</#if>
	</div>
 	<p>
 		<a href="${contextPath}/index.do?v=3&channel=${channel}">触屏版</a>
 		<span>&nbsp;|&nbsp;</span><span>彩版</span><br />
 		<a href="http://m.12580.com">- 12580首页 -</a><br />
 		<span>&copy;2008-2013 中国移动12580</span></p>
</div>
</body>
</html>