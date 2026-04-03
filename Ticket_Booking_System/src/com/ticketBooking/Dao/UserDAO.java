package com.ticketBooking.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ticketBooking.DBConnection.DBConnection;
import com.ticketBooking.Entity.Users;

public class UserDAO {
	/*
	 * public boolean registerUser(User user);

public User login(String username, String password);

public Users getUserById(int id);

public List<Users> getAllUsers();
	 */

	public List<Users> getAllUsers(){
		List<Users> list = new ArrayList<Users>();
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(mapUser(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Users getUserById(int id) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users WHERE id =?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return mapUser(rs);
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Users login(String username, String password) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users WHERE username =? AND password = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return mapUser(rs);
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean registerUser(Users user) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO users VALUES(?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,0);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			int i = ps.executeUpdate();
			if(i>0) return true;
			else return false;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Users mapUser(ResultSet rs) throws SQLException {
		return new Users(rs.getInt("id"),
				rs.getString("username"), 
				rs.getString("password"), 
				rs.getString("role"));
	}
}
