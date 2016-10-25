package com.miao.action;

import java.util.ArrayList;
import java.util.Iterator;
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
public class ShowVoteAction extends ActionSupport{
	private int currentPage;		//当前页
	
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
		//查找所有的投票数
		int totalCount = voteDAO.findAllCount();
		//分页信息，每页显示10条
		Page page = PageUtil.createPage(10, totalCount, currentPage);
		List<Vote> votes = voteDAO.findAllVote(page);
		List<VoteResult> voteResultList = new ArrayList<>();
		Iterator<Vote> iterator = votes.iterator();
		//队投票信息进行遍历
		while(iterator.hasNext()){
			Vote vote = iterator.next();
			List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteId(vote.getVoteId());
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);
			voteResult.setVoteOptions(voteOptions);
			voteResultList.add(voteResult);
		}
//		for(Vote vote : votes){
//			List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteId(vote.getVoteId());
//			VoteResult voteResult = new VoteResult();
//			voteResult.setVote(vote);
//			voteResult.setVoteOptions(voteOptions);
//			voteResultList.add(voteResult);
//		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResultList", voteResultList);
		request.setAttribute("page", page);
		return this.SUCCESS;
	}
}
