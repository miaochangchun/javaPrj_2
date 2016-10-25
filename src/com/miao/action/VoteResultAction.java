package com.miao.action;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.miao.bean.Vote;
import com.miao.bean.VoteOption;
import com.miao.dao.VoteDAO;
import com.miao.dao.VoteOptionDAO;
import com.miao.daoFactory.VoteDAOFactory;
import com.miao.daoFactory.VoteOptionDAOFactory;
import com.opensymphony.xwork2.ActionSupport;

public class VoteResultAction extends ActionSupport{
	private JFreeChart chart;
	private int voteId;
	
	public int getVoteId() {
		return voteId;
	}
	
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	
	public JFreeChart getChart() {
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
		Vote vote = voteDAO.findVoteById(voteId);
		String voteName = vote.getVoteName();
		List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteId(voteId);
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		for(VoteOption voteOption : voteOptions){
			dcd.setValue(voteOption.getTicketNum(), "", voteOption.getVoteOptionName());
		}
		JFreeChart chart = ChartFactory.createBarChart3D(voteName,
				"投票选项",
				"投票数",
				dcd,
				PlotOrientation.VERTICAL, 
				false,
				true,
				false);
		return chart;
	}
	
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}
}
