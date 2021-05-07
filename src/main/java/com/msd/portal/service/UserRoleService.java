package com.msd.portal.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.msd.portal.domain.UserRole;

/**
 * 
 * @author sudheer mende
 *
 */

public interface UserRoleService {

	public List<UserRole> getAll();
	public Optional<UserRole> getById(long id);
	public List<UserRole> getAllRolesByUserID(long userId);
	public UserRole addNewUserRole(UserRole userRole);
	public UserRole updateUserRole(long id,UserRole userRole);
	public void deleteUserRoleById(long id);
	public UserRole getCurrentUserRole(Principal principal);
}
