package com.miao.bean;

public class VoteOption {
	private int voteOptionId;		//ѡ��Id
	private int voteId;				//Ƶ��Id
	private String voteOptionName;	//ѡ������
	private int ticketNum;			//��Ʊ��
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
