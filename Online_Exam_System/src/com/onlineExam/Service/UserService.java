package com.onlineExam.Service;

import com.onlineExam.Entity.Users;

public interface UserService {

	boolean register(Users user);

    Users login(String username, String password);

    Users getUserById(String email);
}
