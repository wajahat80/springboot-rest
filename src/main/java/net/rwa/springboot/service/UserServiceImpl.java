package net.rwa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.rwa.springboot.model.Users;
import net.rwa.springboot.repo.UsersRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepo userRepo;

	@Override
	public Users findUserById(int uid) {
		return userRepo.findOne(uid);
	}

	@Override
	public Users createUser(Users uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUser(Users uid) {
		return userRepo.save(uid);
	}

	@Override
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(int uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
