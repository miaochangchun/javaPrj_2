package com.miao.dao;

import java.util.List;

import com.miao.bean.VoteOption;

public interface VoteOptionDAO {
	/**
	 * 增加投票选项
	 * @param voteOption
	 */
	public void addVoteOption(VoteOption voteOption);
	
	/**
	 * 更新投票选项
	 * @param voteOption
	 */
	public void updateVoteOption(VoteOption voteOption);
	
	/**
	 * 删除投票选项
	 * @param voteOptionId
	 */
	public void deleteVoteOption(int voteOptionId);
	
	/**
	 * 按照投票Id查找所有的投票选项
	 * @param voteId
	 * @return
	 */
	public List<VoteOption> findVoteOptionByVoteId(int voteId);
	
	/**
	 * ͨ按照频道Id查找投票选项
	 * @param voteOptionId
	 * @return
	 */
	public VoteOption findVoteOptionById(int voteOptionId);
}
