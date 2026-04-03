package com.onlineExam.Service;

import com.onlineExam.DAO.UserDAO;
import com.onlineExam.Entity.Users;

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
	public Users getUserById(String email) {
		// TODO Auto-generated method stub
		return uDao.getUserByUsername(email);
	}

}
