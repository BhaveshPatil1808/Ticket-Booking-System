package com.ticketBooking.Service;

import java.util.List;

import com.ticketBooking.Entity.Users;

public interface UserService {

	boolean register(Users user);

	Users login(String username, String password);

	Users getUserById(int id);
	List<Users> getAllUsers();
}
