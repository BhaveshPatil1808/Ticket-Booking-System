package com.ticketBooking.Service;



import java.sql.Date;
import java.util.List;

import com.ticketBooking.Dao.BookingDAO;
import com.ticketBooking.Dao.ShowDAO;
import com.ticketBooking.Entity.Booking;
import com.ticketBooking.Entity.Show;



public class BookingServiceImpl implements BookingService {

    private BookingDAO bookingDAO = new BookingDAO();
    private ShowDAO showDAO = new ShowDAO();

    private final double PRICE_PER_SEAT = 200;

    // 🎟️ BOOK TICKET
    @Override
    public boolean bookTicket(int userId, int showId, int seats) {

        Show show = showDAO.getShowById(showId);

        if (show == null) {
            System.out.println("❌ Show not found!");
            return false;
        }

        if (seats > show.getAvailableSeats()) {
            System.out.println("❌ Not enough seats!");
            return false;
        }

        double totalAmount = seats * PRICE_PER_SEAT;

        Booking booking = new Booking(
                0,
                userId,
                showId,
                seats,
                totalAmount,
                new Date(System.currentTimeMillis()),
                "BOOKED"
        );

        boolean booked = bookingDAO.createBooking(booking);

        if (booked) {
            showDAO.reduceSeats(showId, seats);
            System.out.println("✅ Ticket Booked!");
        }

        return booked;
    }

    // ❌ CANCEL TICKET
    @Override
    public boolean cancelTicket(int bookingId) {

        Booking booking = bookingDAO.getBookingById(bookingId);

        if (booking == null) {
            System.out.println("❌ Booking not found!");
            return false;
        }

        if (booking.getStatus().equals("CANCELLED")) {
            System.out.println("⚠️ Already cancelled!");
            return false;
        }

        boolean cancelled = bookingDAO.cancelBooking(bookingId);

        if (cancelled) {
            showDAO.increaseSeats(booking.getShowId(), booking.getSeatsBooked());
            System.out.println("✅ Ticket Cancelled!");
        }

        return cancelled;
    }

    @Override
    public List<Booking> getUserBookings(int userId) {
        return bookingDAO.getBookingsByUserId(userId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }
}
