package com.miao.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.miao.bean.Vote;
import com.miao.bean.VoteOption;
import com.miao.bean.VoteResult;
import com.miao.dao.VoteDAO;
import com.miao.dao.VoteOptionDAO;
import com.miao.daoFactory.VoteDAOFactory;
import com.miao.daoFactory.VoteOptionDAOFactory;
import com.miao.util.Page;
import com.miao.util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowVoteByChannelAction extends ActionSupport{
	private int channelId;		//频道id
	private int currentPage;	//当前页
	
	//setter和getter方法
	public int getChannelId() {
		return channelId;
	}
	
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
		//此频道下总的投票数
		int totalCount = voteDAO.findCountByChannel(channelId);
		Page page = PageUtil.createPage(3, totalCount, currentPage);
		List<Vote> votes = voteDAO.findVoteByChannel(page, channelId);
		List<VoteResult> voteResults = new ArrayList<>();
		for(Vote vote : votes){
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);;
			List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteId(vote.getVoteId());
			voteResult.setVoteOptions(voteOptions);
			voteResults.add(voteResult);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResultList", voteResults);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
