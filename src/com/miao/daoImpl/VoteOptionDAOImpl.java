package com.miao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miao.bean.VoteOption;
import com.miao.dao.VoteOptionDAO;
import com.miao.util.DBConnection;

public class VoteOptionDAOImpl implements VoteOptionDAO {

	@Override
	public void addVoteOption(VoteOption voteOption) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String addSQL = "insert into tb_voteoption (voteId, voteOptionName, ticketNum)"
				+ " values (?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(addSQL);
			pstmt.setInt(1, voteOption.getVoteId());
			pstmt.setString(2, voteOption.getVoteOptionName());
			pstmt.setInt(3, voteOption.getTicketNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
	}

	@Override
	public void updateVoteOption(VoteOption voteOption) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String updateSQL = "update tb_voteoption set voteId = ?, voteOptionName = ?, ticketNum = ?"
				+ " where voteOptionId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(updateSQL);
			pstmt.setInt(1, voteOption.getVoteId());
			pstmt.setString(2, voteOption.getVoteOptionName());
			pstmt.setInt(3, voteOption.getTicketNum());
			pstmt.setInt(4, voteOption.getVoteOptionId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
	}

	@Override
	public void deleteVoteOption(int voteOptionId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String deleteSQL = "delete from tb_voteoption where voteOptionId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(deleteSQL);
			pstmt.setInt(1, voteOptionId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
	}

	@Override
	public List<VoteOption> findVoteOptionByVoteId(int voteId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select voteOptionId, voteId, voteOptionName, ticketNum "
				+ "from tb_voteoption "
				+ "where voteId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VoteOption> lists = new ArrayList<>();
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setInt(1, voteId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VoteOption voteOption = new VoteOption();
				voteOption.setVoteOptionId(rs.getInt(1));
				voteOption.setVoteId(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
				lists.add(voteOption);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
		return lists;
	}

	@Override
	public VoteOption findVoteOptionById(int voteOptionId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select voteOptionId, voteId, voteOptionName, ticketNum "
				+ "from tb_voteoption "
				+ "where voteOptionId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		VoteOption voteOption = null;
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setInt(1, voteOptionId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				voteOption = new VoteOption();
				voteOption.setVoteOptionId(rs.getInt(1));
				voteOption.setVoteId(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
		return voteOption;
	}

}
