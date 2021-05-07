package com.msd.portal.service.serviceImpl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.User;
import com.msd.portal.repositories.UserRepository;
import com.msd.portal.service.UserService;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private Environment env;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers(){
		return (List<User>) this.userRepository.findAll();
	}
	
	@Override
	public User addUser(User user) {
		return this.userRepository.save(user);	 
	}
	
	@Override
	public Optional<User> getUserById(long id) {
		return this.userRepository.findById(id);
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {		
		return this.userRepository.findAllUsersByFirstName(firstName);
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		return this.userRepository.findAllUsersByLastName(lastName);
	}

	@Override
	public void deleteUserById(long id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public User updateUser(long id, User user) {	
		Optional<User> existingUser = this.getUserById(id);
		
		if(existingUser.get() == null || id != user.getId()) {
			return null;
		}else {
			return this.userRepository.save(user);
		}
	}
	
	@Override
	public User getCurrentUser(Principal principal) {			
		return getUserByUserName(principal.getName()).get();
	}
	
	@Override
	public List<User> getUsersByCreatedByUserName(String userName) {
		return userRepository.findAllUsersByCreatedBy(userName);
	}
	
	@Override
	public Optional<User> getUserByUserName(String userName) {
		return userRepository.findByUserNameAndActiveTrue(userName);
	}
	
	private String createUniqueUserName(User user) throws Exception {
		
//		if(user == null || user.getFirstName() == null || user.getLastName() == null)
//		{
//			throw(new Exception());
//		}
//		
//		String userName = user.getLastName()+
//		
//		if() {
//			
//		}
		
		return null;
	}
	
}
