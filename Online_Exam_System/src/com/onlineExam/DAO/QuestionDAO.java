package com.onlineExam.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineExam.DBConnection.DBConnection;
import com.onlineExam.Entity.Questions;

public class QuestionDAO {
	
	/*
	 * public boolean addQuestion(Question question);

public List<Question> getAllQuestions();

public Question getQuestionById(int id);

public boolean deleteQuestion(int id); // optional

public boolean updateQuestion(Question question); // optional
	 */
	
	public Questions getQuestionById(int id) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM questions WHERE id = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return mapQue(rs);
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Questions> getAllQuestions(){
		List<Questions> list = new ArrayList<Questions>();
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM questions;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(mapQue(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean addQuestion(Questions question) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO questions VALUES(?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setString(2, question.getQuestion());
			ps.setString(3, question.getOption1());
			ps.setString(4, question.getOption2());
			ps.setString(5, question.getOption3());
			ps.setString(6, question.getOption4());
			ps.setInt(7, question.getCorrectAns());
			int i = ps.executeUpdate();
			if(i>0) return true;
			else return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Questions mapQue(ResultSet rs) throws SQLException {
		return new Questions(rs.getInt("id"), 
				rs.getString(2), 
				rs.getString(3),
				rs.getString(4), 
				rs.getString(5), 
				rs.getString(6), 
				rs.getInt(7));
	}

}
