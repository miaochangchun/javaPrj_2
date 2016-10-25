package com.miao.dao;

import java.util.List;

import com.miao.bean.Vote;
import com.miao.util.Page;

public interface VoteDAO {
	/**
	 * 添加投票
	 * @param vote	
	 */
	public void addVote(Vote vote);
	/**
	 * 更新投票
	 * @param vote
	 */
	public void updateVote(Vote vote);
	/**
	 * 删除投票
	 * @param voteId
	 */
	public void deleteVote(int voteId);
	/**
	 * 分页查询所有投票
	 * @param page
	 * @return
	 */
	public List<Vote> findAllVote(Page page);
	/**
	 * 分页查询每频道的投票
	 * @param page
	 * @param channelId
	 * @return
	 */
	public List<Vote> findVoteByChannel(Page page, int channelId);
	/**
	 * 通过Id查询投票
	 * @param voteId
	 * @return
	 */
	public Vote findVoteById(int voteId);
	/**
	 * 通过投票名称查询投票
	 * @param voteName
	 * @return
	 */
	public Vote findVoteByName(String voteName);
	/**
	 * 查询所有的记录数
	 * @return
	 */
	public int findAllCount();
	/**
	 * 查询每频道下的记录数
	 * @param channelId
	 * @return
	 */
	public int findCountByChannel(int channelId);
}
