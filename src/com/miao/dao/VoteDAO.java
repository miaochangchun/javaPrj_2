package com.miao.dao;

import java.util.List;

import com.miao.bean.Vote;
import com.miao.util.Page;

public interface VoteDAO {
	/**
	 * ���ͶƱ
	 * @param vote	
	 */
	public void addVote(Vote vote);
	/**
	 * ����ͶƱ
	 * @param vote
	 */
	public void updateVote(Vote vote);
	/**
	 * ɾ��ͶƱ
	 * @param voteId
	 */
	public void deleteVote(int voteId);
	/**
	 * ��ҳ��ѯ����ͶƱ
	 * @param page
	 * @return
	 */
	public List<Vote> findAllVote(Page page);
	/**
	 * ��ҳ��ѯÿƵ����ͶƱ
	 * @param page
	 * @param channelId
	 * @return
	 */
	public List<Vote> findVoteByChannel(Page page, int channelId);
	/**
	 * ͨ��Id��ѯͶƱ
	 * @param voteId
	 * @return
	 */
	public Vote findVoteById(int voteId);
	/**
	 * ͨ��ͶƱ���Ʋ�ѯͶƱ
	 * @param voteName
	 * @return
	 */
	public Vote findVoteByName(String voteName);
	/**
	 * ��ѯ���еļ�¼��
	 * @return
	 */
	public int findAllCount();
	/**
	 * ��ѯÿƵ���µļ�¼��
	 * @param channelId
	 * @return
	 */
	public int findCountByChannel(int channelId);
}
