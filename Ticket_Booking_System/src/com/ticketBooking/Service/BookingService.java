package com.ticketBooking.Service;

import java.util.List;

import com.ticketBooking.Entity.Booking;

public interface BookingService {

	boolean bookTicket(int userId, int showId, int seats);

    boolean cancelTicket(int bookingId);

    List<Booking> getUserBookings(int userId);

    List<Booking> getAllBookings();
}
