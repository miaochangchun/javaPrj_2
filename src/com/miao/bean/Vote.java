package com.miao.bean;

public class Vote {
	private int voteId;			//ͶƱId
	private String voteName;	//ͶƱ����
	private int channelId;		//Ƶ��Id
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public String getVoteName() {
		return voteName;
	}
	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "voteId = " + this.getVoteId() + "\t"
				+ "voteName = " + this.getVoteName() + "\t"
				+ "channelId = " + this.getChannelId();
	}
}
