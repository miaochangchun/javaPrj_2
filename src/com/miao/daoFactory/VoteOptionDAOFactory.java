package com.miao.daoFactory;

import com.miao.dao.VoteOptionDAO;
import com.miao.daoImpl.VoteOptionDAOImpl;
/**
 * 工厂类
 * @author 10048
 *
 */
public class VoteOptionDAOFactory {
	public static VoteOptionDAO getVoteOptionDAOInstance(){
		return new VoteOptionDAOImpl();
	}
}
