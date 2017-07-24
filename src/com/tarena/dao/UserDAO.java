package com.tarena.dao;

import com.tarena.entity.User;

public interface UserDAO {
	public User getUserByEmail(String email);
	public void saveUser(String email,String nickname,String password);
	public boolean isRegisterUser(User u);
	public User isRegisterUser(String email, String password);
	
	
}
