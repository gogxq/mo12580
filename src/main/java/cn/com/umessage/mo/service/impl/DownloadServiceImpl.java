package cn.com.umessage.mo.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import cn.com.umessage.mo.service.DownloadService;

@Service
public class DownloadServiceImpl implements DownloadService {

	private static final String WAP_UPLOAD_PATH = "/usr/local/umclient/Data/upfile_wap";
	
	@Override
	public void download_android(String version,String channel,HttpServletResponse response) {
		String filename = "";
		if(channel == null || channel.equals("")){
			if(version.equals("2_6_5") || version.equals("2_6_4")){
				filename = "12580_android_" + version + "_A001.apk";
			}else if(version.equals("2_6_3") ||version.equals("2_6_2") || version.equals("2_6_1")){
				filename = "12580_android_" + version + ".apk"; 
			}
		}else{
			filename = "12580_android_" + version + "_" + channel + ".apk";
		}
		String mimeType = "application/vnd.android.package-archive";
		
		download(filename,mimeType,response);
	}

	@Override
	public void download_iphone(String version,String channel,HttpServletResponse response) {
		String filename = "";
		if(channel == null || channel.equals("")){
			if(version.equals("2.6.5")){
				filename = "12580_" + version + "_a003.ipa";
			}
		}else{
			filename = "12580_" + version + "_" + channel + ".ipa";
		}
		String mimeType = "application/x-download";
		
		download(filename,mimeType,response);
	}
	
	public void download(String filename,String mimeType,HttpServletResponse response){
		String filePath = WAP_UPLOAD_PATH + "/" + filename;
		try {
			File file = new File(filePath);
			String name = file.getName();
			InputStream fis;
		
			fis = new BufferedInputStream(new FileInputStream(file));
			byte[]  buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename="+new String(name.getBytes("utf-8"),"ISO-8859-1"));
			response.addHeader("COntent-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType(mimeType);
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
