package com.msd.portal.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msd.portal.domain.User;
import com.msd.portal.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<User>getAllUsers() {
		return this.userService.getAllUsers();		
	}
	
	@PostMapping("")
	public User addNewUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}

	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return userService.getUserById(id);	
	}
	
	@PutMapping("/{id}")
	public void deleteUserById(@PathVariable int id,@RequestBody User user) {
		this.userService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable int id) {
		this.userService.deleteUserById(id);
	}
	
	@GetMapping("/firstname/{firstName}")
	public List<User> getUserByFirstName(@PathVariable String firstName) {
		return userService.getUsersByFirstName(firstName);	
	}
	
	@GetMapping("/lastname/{lastName}")
	public List<User> getUserByLastName(@PathVariable String lastName) {
		return userService.getUsersByLastName(lastName);	
	}
	
	@GetMapping("/current")
	public User getCurrentUser() {
		return userService.getCurrentUser();
	}
	
}
