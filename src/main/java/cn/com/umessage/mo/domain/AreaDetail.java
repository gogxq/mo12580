package cn.com.umessage.mo.domain;

public class AreaDetail {
	
	private String ip;
	
	private String prov_id;
	
	private String prov_name;
	
	private String city_id;
	
	private String city_name;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getProv_id() {
		return prov_id;
	}

	public void setProv_id(String prov_id) {
		this.prov_id = prov_id;
	}

	public String getProv_name() {
		return prov_name;
	}

	public void setProv_name(String prov_name) {
		this.prov_name = prov_name;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	@Override
	public String toString() {
		return "AreaDetail [ip=" + ip + ", prov_id=" + prov_id + ", prov_name="
				+ prov_name + ", city_id=" + city_id + ", city_name="
				+ city_name + "]";
	}
	
}
