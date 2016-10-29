package com.miao.action;

import com.miao.bean.Vote;
import com.miao.bean.VoteOption;
import com.miao.dao.VoteDAO;
import com.miao.dao.VoteOptionDAO;
import com.miao.daoFactory.VoteDAOFactory;
import com.miao.daoFactory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddVoteAction extends ActionSupport{
	private int channel;				//封装channel参数
	private String voteName;			//封装voteName参数
	private String[] voteOption;		//封装voteOption参数
	
	//下面是getter和setter方法
	public int getChannel() {
		return channel;
	}


	public void setChannel(int channel) {
		this.channel = channel;
	}


	public String getVoteName() {
		return voteName;
	}


	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}


	public String[] getVoteOption() {
		return voteOption;
	}


	public void setVoteOption(String[] voteOption) {
		this.voteOption = voteOption;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();	//获得VoteDAO实例
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();	//获得voteOption实例
		//首先保存投票，然后再保存投票选项
		Vote vote = new Vote();
		vote.setChannelId(channel);
		vote.setVoteName(voteName);
		//添加到数据库
		voteDAO.addVote(vote);
		//查找voteId根据投票的名称
		int voteId = voteDAO.findVoteByName(voteName).getVoteId();
		//循环数组
		for(String voteOptionName : voteOption){
			VoteOption voteOption = new VoteOption();
			voteOption.setVoteId(voteId);
			voteOption.setVoteOptionName(voteOptionName);
			//添加到数据库
			voteOptionDAO.addVoteOption(voteOption);
		}
		return SUCCESS;
	}
}
