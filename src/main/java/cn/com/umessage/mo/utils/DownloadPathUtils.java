package cn.com.umessage.mo.utils;

public class DownloadPathUtils {
	public static String getPathByName(String name){
		String channel = "";
		try{
			channel = name.substring(name.lastIndexOf("_") + 1,name.lastIndexOf("."));
			if(channel.length() == 5){
				channel = channel + "/";
			}else{
				channel = "";
			}
		}catch(Exception exception){
			System.out.println("getPathByName Error,name="+name+",e="+exception);
			channel = "";
		}
		return "/usr/local/umclient/Data/upfile_wap/" + channel + name;
	}
}
