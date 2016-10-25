package com.miao.daoFactory;

import java.util.Iterator;
import java.util.List;

import com.miao.bean.Vote;
import com.miao.bean.VoteOption;
import com.miao.dao.VoteDAO;
import com.miao.dao.VoteOptionDAO;
import com.miao.util.Page;
import com.miao.util.PageUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		Vote vote = voteDAO.findVoteByName("请选择您最喜欢的CBA球员");
		System.out.println(vote);
	}

}
