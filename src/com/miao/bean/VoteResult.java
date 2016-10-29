package com.miao.bean;

import java.util.List;

public class VoteResult {
	private Vote vote;						//投票类
	private List<VoteOption> voteOptions;	//投票选项数组
	
	public Vote getVote() {
		return vote;
	}
	
	public void setVote(Vote vote) {
		this.vote = vote;
	}
	
	public List<VoteOption> getVoteOptions() {
		return voteOptions;
	}
	
	public void setVoteOptions(List<VoteOption> voteOptions) {
		this.voteOptions = voteOptions;
	}
	
}
