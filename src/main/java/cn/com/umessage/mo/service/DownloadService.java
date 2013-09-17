package cn.com.umessage.mo.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

public interface DownloadService {

	//android版下载
	public void download_android(String version,String channel,HttpServletResponse response);
	
	//iphone最新版下载
	public void download_iphone(String version,String channel,HttpServletResponse response);

}
