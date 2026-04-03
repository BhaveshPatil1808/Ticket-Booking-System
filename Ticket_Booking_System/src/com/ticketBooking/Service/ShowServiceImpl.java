package com.ticketBooking.Service;

import java.util.List;

import com.ticketBooking.Dao.ShowDAO;
import com.ticketBooking.Entity.Show;

public class ShowServiceImpl implements ShowService {

	private ShowDAO sDao = new ShowDAO();
	
	@Override
	public boolean addShow(Show show) {
		// TODO Auto-generated method stub
		return sDao.addShow(show);
	}

	@Override
	public List<Show> getAllShows() {
		// TODO Auto-generated method stub
		return sDao.getAllShows();
	}

	@Override
	public Show getShowById(int id) {
		// TODO Auto-generated method stub
		return sDao.getShowById(id);
	}

}
