package cn.com.umessage.mo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {
	public static Gson newInstance(){
		Gson gson = (new GsonBuilder()).disableHtmlEscaping().create();
		return gson;
	}
}
