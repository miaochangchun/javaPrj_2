package com.miao.bean;

public class VoteOption {
	private int voteOptionId;		//选项Id
	private int voteId;				//频道Id
	private String voteOptionName;	//选项名称
	private int ticketNum;			//得票数
	public int getVoteOptionId() {
		return voteOptionId;
	}
	public void setVoteOptionId(int voteOptionId) {
		this.voteOptionId = voteOptionId;
	}
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public String getVoteOptionName() {
		return voteOptionName;
	}
	public void setVoteOptionName(String voteOptionName) {
		this.voteOptionName = voteOptionName;
	}
	public int getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "voteOptionId = " + this.getVoteOptionId() + "\t"
				+ "voteOptionName = " + this.getVoteOptionName() + "\t"
				+ "voteId = " + this.getVoteId() + "\t"
				+ "ticketNum = " + this.getTicketNum();
	}
}
