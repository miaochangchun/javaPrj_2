package com.miao.action;

import java.util.List;

import com.miao.bean.VoteOption;
import com.miao.dao.VoteDAO;
import com.miao.dao.VoteOptionDAO;
import com.miao.daoFactory.VoteDAOFactory;
import com.miao.daoFactory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteVoteAction extends ActionSupport{
	private int voteId;		//投票Id
	
	public int getVoteId() {
		return voteId;
	}
	
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();	//获得VoteDAO实例
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
		//查找到voteId的所有投票选项
		List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteId(voteId);
		//循环遍历删除投票选项
		for(VoteOption voteOption : voteOptions){
			voteOptionDAO.deleteVoteOption(voteOption.getVoteOptionId());
		}
		//删除投票信息
		voteDAO.deleteVote(voteId);
		return SUCCESS;
	}
}
