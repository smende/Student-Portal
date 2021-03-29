package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

import com.msd.portal.domain.Role;

/**
 * 
 * @author sudheer mende
 *
 */

public interface RoleService {

	public List<Role> getAllRoles();
	public Role addRole(Role role);
	public List<Role> bulkSaveRoles(List<Role> roles) throws Exception ;
	public Optional<Role> getRoleById(long id);
	public void deleteRoleById (long id);
	public Role updateRole(long id,Role role);
}
