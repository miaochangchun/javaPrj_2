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
/**
 * JFreeChart是JAVA平台上的一个开放的图表绘制类库。它完全使用JAVA语言编写，
 * 是为applications, applets, servlets 以及JSP等使用所设计。
 * JFreeChart可生成饼图（pie charts）、柱状图（bar charts）、散点图（scatter plots）、
 * 时序图（time series）、甘特图（Gantt charts）等等多种图表，
 * 并且可以产生PNG和JPEG格式的输出，还可以与PDF和EXCEL关联。
 * @author 10048
 *
 */
@SuppressWarnings("serial")
public class VoteResultAction extends ActionSupport{
	@SuppressWarnings("unused")
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
		//绘制柱状图
		JFreeChart chart = ChartFactory.createBarChart3D(
				voteName,			//设置图表的标题
				"投票选项",			//设置分类轴的标示
				"投票数",			//设置值轴的标示
				dcd,				//设置数据
				PlotOrientation.VERTICAL, 	//设置图表的方向
				false,				//设置是否显示图例
				true,				//设置是否生成热点工具
				false				//设置是否显示url
				);	
		return chart;
	}
	
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}
