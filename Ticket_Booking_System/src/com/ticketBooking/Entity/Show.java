package com.ticketBooking.Entity;

import java.sql.Date;
import java.sql.Time;

public class Show {

	private int id;
    private String name;
    private String source;
    private String destination;
    private Date showDate;
    private Time showTime;
    private int totalSeats;
    private int availableSeats;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public Time getShowTime() {
		return showTime;
	}
	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Show(int id, String name, String source, String destination, Date showDate, Time showTime, int totalSeats,
			int availableSeats) {
		super();
		this.id = id;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.showDate = showDate;
		this.showTime = showTime;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
	}
    
    
	public void display() {
        System.out.println("ID: " + id +
                " Name: " + name +
                " From: " + source +
                " To: " + destination +
                " Date: " + showDate +
                " Time: " + showTime +
                " Available Seats: " + availableSeats);
    }
}
