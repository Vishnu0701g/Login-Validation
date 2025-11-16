package com.page.dao;

import java.util.List;

import com.page.models.User;

public interface UserDao {
	public List<User> getAllUsers();
	public User getUser(String emailEntered);
	public int addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userId);
	public String getUserPassword(String email);
	boolean isEmailRegistered(String email);

}
