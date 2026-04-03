package com.ticketBooking.Service;

import java.util.List;

import com.ticketBooking.Dao.UserDAO;
import com.ticketBooking.Entity.Users;

public class UserServiceImpl implements UserService {

	
	private UserDAO uDao = new UserDAO();
	@Override
	public boolean register(Users user) {
		// TODO Auto-generated method stub
		return uDao.registerUser(user);
	}

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return uDao.login(username, password);
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return uDao.getUserById(id);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return uDao.getAllUsers();
	}

}
