package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

import com.msd.portal.domain.User;

/**
 * 
 * @author sudheer mende
 *
 */

public interface UserService {
	
	public List<User> getAllUsers();	
	public User addUser(User user);
	public Optional<User> getUserById(long id);
	public List<User> getUsersByFirstName(String firstName);
	public List<User> getUsersByLastName(String lastName);
	public List<User> getUsersByCreatedByUserName(String userName);
	public void deleteUserById (long id);
	public User updateUser(long id, User user);
	public User getCurrentUser();
}
