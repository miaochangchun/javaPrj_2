package com.miao.bean;

public class Channel {
	private int channelId;		//频道名称
	private String channelName;	//频道名称
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "channelId = " + this.getChannelId() + "\t"
				+ "channelName = " + this.getChannelName();
	}
}
