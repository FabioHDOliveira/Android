package net.androidbootcamp.mycruiseapp;

public class RowItem {

	private String port_name;
	private int profile_pic_id;
	private String status;
	private String departsType;

	public RowItem(String port_name, int profile_pic_id, String status,
			String departsType) {

		this.port_name = port_name;
		this.profile_pic_id = profile_pic_id;
		this.status = status;
		this.departsType = departsType;
	}

	public String getPort_name() {
		return port_name;
	}

	public void setPort_name(String port_name) {
		this.port_name = port_name;
	}

	public int getProfile_pic_id() {
		return profile_pic_id;
	}

	public void setProfile_pic_id(int profile_pic_id) {
		this.profile_pic_id = profile_pic_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDepartsType() {
		return departsType;
	}

	public void setDepartsType(String departsType) {
		this.departsType = departsType;
	}

}