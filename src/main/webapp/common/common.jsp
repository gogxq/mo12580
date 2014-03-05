<%@ page language="java" import="com.Util,java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%
	String e = request.getParameter("e");
	String uid = request.getParameter("uid")==null?"":request.getParameter("uid");
	String white = request.getParameter("white");
	String channel = request.getParameter("channel")==null?"":request.getParameter("channel");
	if(white!=null && white.length()>0 && channel.length()==0) {
		channel = white;
	}
	String ua = request.getHeader("user-agent");
	String ip = request.getRemoteAddr();
	String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	if(e==null) {
		if(ua==null) {
			e = "2";
		} else {
			if(ua.toLowerCase().indexOf("opera")!=-1) {
				e = "2";
			} else if(ua.toLowerCase().indexOf("ucweb")!=-1) {
				e = "2";
			} else if(ua.toLowerCase().indexOf("mozilla")!=-1) {
				e = "2";
			} else if(ua.toLowerCase().indexOf("msie")!=-1) {
				e = "2";
			} else {
				e = "2";
			}
		}
	}
	String param = "&amp;uid="+uid+"&amp;channel="+channel;
	if(white!=null) {
		param = param+"&amp;white="+white;
	}
	String parameter = "?e="+e+param;
	String head = "/common/head.jsp"+parameter;
	String tail = "/common/tail.jsp"+parameter;
	String about = "/about.jsp"+parameter;
	String index = "/index.jsp"+parameter;
	String easy = "/index.jsp?e=1"+param;
	String color = "/index.jsp?e=2"+param;
	String bag = "";
	if(!channel.equals("")) {
		bag = "_"+channel;
	}
	if(uid.equals("p1") || uid.equals("p2") || uid.equals("p3") || uid.equals("p4")) {
		bag = "_msg";
	}
	//软件下载地址
	String android = "/download.jsp?name=12580_android_2_4_0"+bag+".apk"+param;
	String android_live = "/download.jsp?name=12580_android_live_1_1_0"+bag+".apk"+param;
	String jad = "/download.jsp?name=12580_java_2_1_0"+bag+".jad"+param;
	String jar = "/download.jsp?name=12580_java_2_1_0"+bag+".jar"+param;
	String jad_mini = "/download.jsp?name=12580_java_mini_2_1_0"+bag+".jad"+param;
	String jar_mini = "/download.jsp?name=12580_java_mini_2_1_0"+bag+".jar"+param;
	String ophone = "/download.jsp?name=12580_ophone_2_1_0"+bag+".apk"+param;
	String symbian_v2 = "/download.jsp?name=12580_s60_v2_2_1_0"+bag+".sis"+param;
	String symbian_v3 = "/download.jsp?name=12580_s60_v3_2_3_1"+bag+".sis"+param;
	String symbian_v5 = "/download.jsp?name=12580_s60_v5_2_3_0"+bag+".sis"+param;
	String wm5_p = "/download.jsp?name=12580_wm_v5_2_2_0_p"+bag+".cab"+param;
	String wm5_g = "/download.jsp?name=12580_wm_v5_2_2_0_g"+bag+".cab"+param;
	String wm5_s = "/download.jsp?name=12580_wm_v5_2_2_0_s"+bag+".cab"+param;
	//软件大小
	long android_size = Util.getSizeByUrl(android);
	long android_live_size = Util.getSizeByUrl(android_live);
	long jad_size = Util.getSizeByUrl(jad);
	long jar_size = Util.getSizeByUrl(jar);
	long jad_mini_size = Util.getSizeByUrl(jad_mini);
	long jar_mini_size = Util.getSizeByUrl(jar_mini);
	long ophone_size = Util.getSizeByUrl(ophone);
	long symbian_v2_size = Util.getSizeByUrl(symbian_v2);
	long symbian_v3_size = Util.getSizeByUrl(symbian_v3);
	long symbian_v5_size = Util.getSizeByUrl(symbian_v5);
	long wm5_p_size = Util.getSizeByUrl(wm5_p);
	long wm5_g_size = Util.getSizeByUrl(wm5_g);
	long wm5_s_size = Util.getSizeByUrl(wm5_s);
	//软件更新日期
	String android_date = Util.getDateByUrl(android);
	String android_live_date = Util.getDateByUrl(android_live);
	String jad_date = Util.getDateByUrl(jad);
	String jar_date = Util.getDateByUrl(jar);
	String jad_mini_date = Util.getDateByUrl(jad_mini);
	String jar_mini_date = Util.getDateByUrl(jar_mini);
	String ophone_date = Util.getDateByUrl(ophone);
	String symbian_v2_date = Util.getDateByUrl(symbian_v2);
	String symbian_v3_date = Util.getDateByUrl(symbian_v3);
	String symbian_v5_date = Util.getDateByUrl(symbian_v5);
	String wm5_p_date = Util.getDateByUrl(wm5_p);
	String wm5_g_date = Util.getDateByUrl(wm5_g);
	String wm5_s_date = Util.getDateByUrl(wm5_s);
	//软件版本
	String android_version = Util.getVersionByUrl(android, bag);
	String android_live_version = Util.getVersionByUrl(android_live, bag);
	String jad_version = Util.getVersionByUrl(jad, bag);
	String jar_version = Util.getVersionByUrl(jar, bag);
	String jad_mini_version = Util.getVersionByUrl(jad_mini, bag);
	String jar_mini_version = Util.getVersionByUrl(jar_mini, bag);
	String ophone_version = Util.getVersionByUrl(ophone, bag);
	String symbian_v2_version = Util.getVersionByUrl(symbian_v2, bag);
	String symbian_v3_version = Util.getVersionByUrl(symbian_v3, bag);
	String symbian_v5_version = Util.getVersionByUrl(symbian_v5, bag);
	String wm5_p_version = Util.getVersionByUrl(wm5_p, bag);
	String wm5_g_version = Util.getVersionByUrl(wm5_g, bag);
	String wm5_s_version = Util.getVersionByUrl(wm5_s, bag);
%>