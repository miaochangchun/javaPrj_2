package com.miao.bean;

import java.util.List;

public class VoteResult {
	private Vote vote;						//投票信息
	private List<VoteOption> voteOptions;	//所有选项合集
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
