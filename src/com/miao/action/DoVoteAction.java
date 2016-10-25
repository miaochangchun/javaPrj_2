package com.miao.action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.miao.bean.VoteOption;
import com.miao.dao.VoteOptionDAO;
import com.miao.daoFactory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DoVoteAction extends ActionSupport{
	private int voteOptionId;		//投票选项Id
	private String otherOption;		//其他投票信息
	private int voteId;				//投票Id
	private int channelId;			//频道Id
	
	//以下为setter和getter方法
	public int getVoteOptionId() {
		return voteOptionId;
	}
	public void setVoteOptionId(int voteOptionId) {
		this.voteOptionId = voteOptionId;
	}
	public String getOtherOption() {
		return otherOption;
	}
	public void setOtherOption(String otherOption) {
		this.otherOption = otherOption;
	}
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
		//防止多次投票，根据cookie缓存来进行过滤
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for(Cookie cookie : cookies){
			if (cookie.getValue().equals(Integer.toString(voteId))) {
				this.addActionError("您今天已经投过票了，请明天再来！");
				return this.INPUT;
			}
		}
		
		if (voteOptionId == 0) {	//第一次投票
			VoteOption voteOption = new VoteOption();
			voteOption.setVoteId(voteId);
			voteOption.setVoteOptionName(otherOption);
			voteOption.setTicketNum(1);
			voteOptionDAO.addVoteOption(voteOption);
		}else {	//票数增加
			VoteOption voteOption = voteOptionDAO.findVoteOptionById(voteOptionId);
			int ticketNum = voteOption.getTicketNum();
			voteOption.setTicketNum(ticketNum + 1);
			voteOptionDAO.updateVoteOption(voteOption);
			Cookie cookie = new Cookie("hasVote" + voteId, Integer.toString(voteId));
			ServletActionContext.getResponse().addCookie(cookie);
		}
		return this.SUCCESS;
	}
}
