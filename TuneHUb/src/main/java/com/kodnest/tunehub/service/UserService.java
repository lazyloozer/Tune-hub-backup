package com.kodnest.tunehub.service;

import com.kodnest.tunehub.entity.User;

public interface UserService {
	//add user to database using registration form

	 public String addUser( User user);
	 //checking duplicate emails in db

	public boolean emailExists(String email);

	public boolean validateUser(String email, String password);

	public String getRole(String email);

	//public String addsong(Song song);
	public User getUser(String email);
	public void updateUser(User user);

}
