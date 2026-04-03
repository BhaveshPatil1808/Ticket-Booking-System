package com.ticketBooking.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ticketBooking.DBConnection.DBConnection;
import com.ticketBooking.Entity.Show;

public class ShowDAO {

	/*
	 * public boolean addShow(Show show);

public List<Show> getAllShows();

public Show getShowById(int id);

public boolean updateAvailableSeats(int showId, int seats);
	 */
	
	public boolean increaseSeats(int showId, int seats) {
        try (Connection con = DBConnection.getConnection()) {

            String query = "UPDATE shows SET available_seats = available_seats + ? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, seats);
            ps.setInt(2, showId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean reduceSeats(int showId, int seats) {
        try (Connection con = DBConnection.getConnection()) {

            String query = "UPDATE shows SET available_seats = available_seats - ? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, seats);
            ps.setInt(2, showId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	public boolean updateAvailableSeats(int showId, int seats) {
		try (Connection con = DBConnection.getConnection()) {

            String query = "UPDATE shows SET available_seats = available_seats - ? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, seats);
            ps.setInt(2, showId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	public Show getShowById(int id) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM shows WHERE id = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return mapShow(rs);
			else return null;
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	
	public List<Show> getAllShows(){
		List<Show> list = new ArrayList<Show>();
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM shows;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(mapShow(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean addShow(Show show) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO shows VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setString(2, show.getName());
			ps.setString(3, show.getSource());
			ps.setString(4, show.getDestination());
			ps.setDate(5,show.getShowDate());
			ps.setTime(6, show.getShowTime());
			ps.setInt(7,show.getTotalSeats());
			ps.setInt(8, show.getAvailableSeats());
			
			return ps.executeUpdate()>0;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Show mapShow(ResultSet rs) throws SQLException {
        return new Show(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("source"),
                rs.getString("destination"),
                rs.getDate("show_date"),
                rs.getTime("show_time"),
                rs.getInt("total_seats"),
                rs.getInt("available_seats")
        );
    }
}
