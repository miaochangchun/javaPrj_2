package com.miao.daoFactory;

import com.miao.dao.VoteDAO;
import com.miao.daoImpl.VoteDAOImpl;
/**
 * 工厂类
 * @author 10048
 *
 */
public class VoteDAOFactory {
	public static VoteDAO getVoteDAOInstance(){
		return new VoteDAOImpl();
	}
}
