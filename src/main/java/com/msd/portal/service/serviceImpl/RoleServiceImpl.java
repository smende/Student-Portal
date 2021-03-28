package com.msd.portal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.Role;
import com.msd.portal.repositories.RoleRepository;
import com.msd.portal.service.RoleService;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getAllRoles() {
		return (List<Role>) this.roleRepository.findAll();
	}

	@Override
	public Role addRole(Role role) {
		return this.roleRepository.save(role);
	}

	@Override
	public Optional<Role> getRoleById(long id) {
		return this.roleRepository.findById(id);
	}

	@Override
	public void deleteRoleById(long id) {		
		this.roleRepository.deleteById(id);
	}

	@Override
	public Role updateRole(long id, Role role) {
		Optional<Role> existingRole = this.getRoleById(id);
		
		if(existingRole.get() == null || id != role.getId()) {
			return null;
		}else {
			return this.roleRepository.save(role);
		}
		
	}

}
