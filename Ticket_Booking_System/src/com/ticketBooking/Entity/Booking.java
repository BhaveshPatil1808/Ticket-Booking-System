package com.ticketBooking.Entity;

import java.sql.Date;

public class Booking {

	private int id;
    private int userId;
    private int showId;
    private int seatsBooked;
    private double totalAmount;
    private Date bookingDate;
    private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Booking(int id, int userId, int showId, int seatsBooked, double totalAmount, Date bookingDate,
			String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.showId = showId;
		this.seatsBooked = seatsBooked;
		this.totalAmount = totalAmount;
		this.bookingDate = bookingDate;
		this.status = status;
	}
    
	public void display() {
        System.out.println("Booking ID: " + id +
                " User: " + userId +
                " Show: " + showId +
                " Seats: " + seatsBooked +
                " Amount: " + totalAmount +
                " Date: " + bookingDate +
                " Status: " + status);
    }
}
