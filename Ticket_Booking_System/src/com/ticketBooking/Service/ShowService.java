package com.ticketBooking.Service;

import java.util.List;

import com.ticketBooking.Entity.Show;

public interface ShowService {

	boolean addShow(Show show);

    List<Show> getAllShows();

    Show getShowById(int id);
}
