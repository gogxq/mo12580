<%@ page language="java" import="java.io.*,java.util.*,java.text.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
    request.setAttribute("name","12580_android_2_6_0.apk"); 
    System.out.println("邀请好友");
    request.setAttribute("uid",""); 
    request.getRequestDispatcher("/download.jsp").forward(request, response);
%>