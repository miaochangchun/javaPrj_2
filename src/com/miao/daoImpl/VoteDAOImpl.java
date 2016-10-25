package com.miao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miao.bean.Vote;
import com.miao.dao.VoteDAO;
import com.miao.util.DBConnection;
import com.miao.util.Page;

public class VoteDAOImpl implements VoteDAO {

	@Override
	public void addVote(Vote vote) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String addSQL = "insert into tb_vote(voteName,channelId) values (?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(addSQL);
			pstmt.setString(1, vote.getVoteName());
			pstmt.setInt(2, vote.getChannelId());
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
	public void updateVote(Vote vote) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String updateSQL = "update tb_vote set voteName = ?, channelId = ? where voteId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(updateSQL);
			pstmt.setString(1, vote.getVoteName());
			pstmt.setInt(2, vote.getChannelId());
			pstmt.setInt(3, vote.getVoteId());
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
	public void deleteVote(int voteId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String deleteSQL = "delete from tb_vote where voteId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(deleteSQL);
			pstmt.setInt(1, voteId);
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
	public List<Vote> findAllVote(Page page) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select voteId, voteName, channelId from tb_vote limit ?, ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Vote> lists = new ArrayList<>();
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vote vote = new Vote();
				vote.setVoteId(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelId(rs.getInt(3));
				lists.add(vote);
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
	public List<Vote> findVoteByChannel(Page page, int channelId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select voteId, voteName, channelId from tb_vote where channelId = ? limit ?, ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Vote> lists = new ArrayList<>();
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setInt(1, channelId);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vote vote = new Vote();
				vote.setVoteId(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelId(rs.getInt(3));
				lists.add(vote);
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
	public Vote findVoteById(int voteId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select voteId, voteName, channelId from tb_vote where voteId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vote vote = null;
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setInt(1, voteId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vote = new Vote();
				vote.setVoteId(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelId(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
		return vote;
	}

	@Override
	public Vote findVoteByName(String voteName) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select voteId, voteName, channelId from tb_vote where voteName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vote vote = null;
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setString(1, voteName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vote = new Vote();
				vote.setVoteId(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelId(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
		return vote;
	}

	@Override
	public int findAllCount() {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select count(*) from tb_vote";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = connection.prepareStatement(findSQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
		return count;
	}

	@Override
	public int findCountByChannel(int channelId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select count(*) from tb_vote where channelId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setInt(1, channelId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
		return count;
	}

}
