package com.miao.daoFactory;

import com.miao.dao.VoteOptionDAO;
import com.miao.daoImpl.VoteOptionDAOImpl;

public class VoteOptionDAOFactory {
	public static VoteOptionDAO getVoteOptionDAOInstance(){
		return new VoteOptionDAOImpl();
	}
}
