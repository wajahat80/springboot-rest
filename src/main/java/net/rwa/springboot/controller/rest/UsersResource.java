package net.rwa.springboot.controller.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.rwa.springboot.api.response.RecordNotFoundException;
import net.rwa.springboot.model.Users;
import net.rwa.springboot.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UsersResource {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public List<Users> getUsers() {
		return userService.findAllUsers();
	}

	@RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
	public ResponseEntity getUserById(@PathVariable int uid, @RequestParam(value = "param1") String fname,
			@RequestParam(value = "param2", required = false) String mname,
			@RequestParam(value = "param3", required = true) String lname) {
		System.out.println("id:..........." + uid);
		System.out.println("param1 is required as not define the required :..........." + fname);
		System.out.println("param2 is not required as define required=false :..........." + mname);
		System.out.println("param3 is required as not define the required=true :..........." + lname);

		Users users = userService.findUserById(uid);
		if (users == null)
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public Users getUserById(@RequestParam Users user, @RequestBody Users user2) {
		Users users = userService.createUser(user);
		return users;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateUser(@RequestBody Users user) {

		System.out.println("................" + user.getUid());
		System.out.println("................" + user.getFirstname());
		Users users = userService.updateUser(user);

		return new ResponseEntity(users, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestParam int userid) {
		boolean userDeleted = userService.deleteUser(userid);

		ResponseEntity.status(HttpStatus.OK);
		return null;
	}

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public Users deleteAllUser(@RequestParam int userid) {
		boolean userDeleted = userService.deleteAllUser();
		return null;
	}

}
