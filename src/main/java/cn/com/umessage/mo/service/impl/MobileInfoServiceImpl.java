package cn.com.umessage.mo.service.impl;

import org.springframework.stereotype.Service;

import cn.com.umessage.mo.service.MobileInfoService;

@Service("mobileInfoService")
public class MobileInfoServiceImpl implements MobileInfoService {

	private static final String MISDN_GET_URL = "http://wap.12580.com/service/interface/m2.php?url=";
	
	@Override
	public Object getMobileInfo(String url) {
		
		return null;
	}

}
