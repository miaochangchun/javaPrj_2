package com.miao.daoFactory;

import com.miao.dao.VoteDAO;
import com.miao.daoImpl.VoteDAOImpl;

public class VoteDAOFactory {
	public static VoteDAO getVoteDAOInstance(){
		return new VoteDAOImpl();
	}
}
