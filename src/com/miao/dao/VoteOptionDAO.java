package com.miao.dao;

import java.util.List;

import com.miao.bean.VoteOption;

public interface VoteOptionDAO {
	/**
	 * ���ͶƱѡ��
	 * @param voteOption
	 */
	public void addVoteOption(VoteOption voteOption);
	/**
	 * ����ͶƱѡ��
	 * @param voteOption
	 */
	public void updateVoteOption(VoteOption voteOption);
	/**
	 * ɾ��ͶƱѡ��
	 * @param voteOptionId
	 */
	public void deleteVoteOption(int voteOptionId);
	/**
	 * ��ѯ����ͶƱѡ��
	 * @param voteId
	 * @return
	 */
	public List<VoteOption> findVoteOptionByVoteId(int voteId);
	/**
	 * ͨ��ID��ѯͶƱѡ��
	 * @param voteOptionId
	 * @return
	 */
	public VoteOption findVoteOptionById(int voteOptionId);
}
