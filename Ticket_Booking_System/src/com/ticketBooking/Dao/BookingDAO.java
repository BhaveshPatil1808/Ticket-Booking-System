

package com.ticketBooking.Dao;

import java.sql.*;
import java.util.*;

import com.ticketBooking.DBConnection.*;
import com.ticketBooking.Entity.*;

public class BookingDAO {

    public boolean createBooking(Booking booking) {
        try (Connection con = DBConnection.getConnection()) {

            String query = "INSERT INTO bookings(user_id, show_id, seats_booked, total_amount, booking_date, status) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getShowId());
            ps.setInt(3, booking.getSeatsBooked());
            ps.setDouble(4, booking.getTotalAmount());
            ps.setDate(5, booking.getBookingDate());
            ps.setString(6, booking.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Booking> getBookingsByUserId(int userId) {
        List<Booking> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM bookings WHERE user_id=?");
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) list.add(mapBooking(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Booking> getAllBookings() {
        List<Booking> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM bookings");

            while (rs.next()) list.add(mapBooking(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Booking getBookingById(int id) {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM bookings WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return mapBooking(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean cancelBooking(int id) {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement("UPDATE bookings SET status='CANCELLED' WHERE id=?");
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Booking mapBooking(ResultSet rs) throws SQLException {
        return new Booking(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getInt("show_id"),
                rs.getInt("seats_booked"),
                rs.getDouble("total_amount"),
                rs.getDate("booking_date"),
                rs.getString("status")
        );
    }
}
