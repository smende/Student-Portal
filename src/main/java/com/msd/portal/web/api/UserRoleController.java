package com.msd.portal.web.api;

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

import com.msd.portal.domain.UserRole;
import com.msd.portal.service.UserRoleService;

/**
 * 
 * @author sudheer mende
 *
 */

@RestController
@RequestMapping("/api/userrole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	@GetMapping("")
	public List<UserRole> getAll(){
		return this.userRoleService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<UserRole> getById(@PathVariable long id){
		return this.userRoleService.getById(id);
	}
	
	@PostMapping("")
	public UserRole addNew(@RequestBody UserRole userRole) {
		return this.userRoleService.addNewUserRole(userRole);
	}
	
	@PutMapping("/{id}")
	public UserRole updateUserRole(@PathVariable long id, @RequestBody UserRole userRole) {
		return this.userRoleService.updateUserRole(id, userRole);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		this.userRoleService.deleteUserRoleById(id);
	}
	
	@GetMapping("/byuserid/{userId}")
	public List<UserRole> getListByUserId(@PathVariable long userId){
		return this.userRoleService.getAllRolesByUserID(userId);
	}
	
}
