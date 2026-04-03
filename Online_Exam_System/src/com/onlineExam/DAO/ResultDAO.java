package com.onlineExam.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineExam.DBConnection.DBConnection;
import com.onlineExam.Entity.Result;

public class ResultDAO {

	/*
	 * public boolean saveResult(Result result);

public List<Result> getAllResults();

public List<Result> getResultsByUserId(int userId);
	 */
	public List<Result> getResultsByUserId(int userId){
		List<Result> list = new ArrayList<Result>();
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM results WHERE user_id = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(mapRs(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Result> getAllResults(){
		List<Result> list = new ArrayList<Result>();
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM results;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(mapRs(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean saveResult(Result result) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO results VALUES (?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setInt(2, result.getUserId());
			ps.setInt(3, result.getScore());
			ps.setInt(4, result.getTotalQuestions());
			ps.setDate(5, result.getExamDate());
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private Result mapRs(ResultSet rs) throws SQLException {
		return new Result(rs.getInt("id"),
				rs.getInt("user_id"),
				rs.getInt("score"),
				rs.getInt(4), 
				rs.getDate(5));
	}
}
