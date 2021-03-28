package com.msd.portal.service.serviceImpl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.UserRole;
import com.msd.portal.repositories.UserRoleRepository;
import com.msd.portal.service.UserRoleService;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public List<UserRole> getAll() {
		return (List<UserRole>) this.userRoleRepository.findAll();
	}

	@Override
	public Optional<UserRole> getById(long id) {
		return this.userRoleRepository.findById(id);
	}

	@Override
	public List<UserRole> getAllRolesByUserID(long userId) {
		return this.userRoleRepository.findAllUserRolesByUserId(userId);
	}

	@Override
	public UserRole addNewUserRole(UserRole userRole) {
		return this.userRoleRepository.save(userRole);
	}

	@Override
	public UserRole updateUserRole(long id, UserRole userRole) {
		Optional<UserRole> existingUserRole = this.getById(id);
		
		if(existingUserRole.get() == null || id != userRole.getId()) {
			return null;
		}else {
			return this.userRoleRepository.save(userRole);
		}
	}

	@Override
	public void deleteUserRoleById(long id) {
		this.userRoleRepository.deleteById(id);
	}
	
	

	
	
}
