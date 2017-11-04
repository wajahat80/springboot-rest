package net.rwa.springboot.service;

import java.util.List;

import net.rwa.springboot.model.Users;

public interface UserService {

	public Users findUserById(int uid);
	public Users createUser(Users uid);
	public Users updateUser(Users uid);
	public List<Users> findAllUsers();
	public boolean deleteUser(int uid);
	public boolean deleteAllUser();
	
	
	
}
