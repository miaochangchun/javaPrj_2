package com.miao.dao;

import java.util.List;

import com.miao.bean.Vote;
import com.miao.util.Page;

public interface VoteDAO {
	/**
	 * 增加投票
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
	 * 分页查找所有投票
	 * @param page
	 * @return
	 */
	public List<Vote> findAllVote(Page page);
	
	/**
	 * 按照投票频道分页查找所有投票
	 * @param page
	 * @param channelId
	 * @return
	 */
	public List<Vote> findVoteByChannel(Page page, int channelId);
	
	/**
	 * ͨ按照投票Id查找投票
	 * @param voteId
	 * @return
	 */
	public Vote findVoteById(int voteId);
	
	/**
	 * ͨ按照投票名称查找投票
	 * @param voteName
	 * @return
	 */
	public Vote findVoteByName(String voteName);
	
	/**
	 * 查找所有投票总数
	 * @return
	 */
	public int findAllCount();
	
	/**
	 * 按照频道查找所有投票总数
	 * @param channelId
	 * @return
	 */
	public int findCountByChannel(int channelId);
}
