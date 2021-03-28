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

import com.msd.portal.domain.Role;
import com.msd.portal.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	public List<Role> getAllRoles(){
		return this.roleService.getAllRoles();
	}
	
	@PostMapping("")
	public Role addRole(@RequestBody Role role){
		return this.roleService.addRole(role);
	}
	
	@GetMapping("/{id}")
	public Optional<Role> getById(@PathVariable int id){
		return this.roleService.getRoleById(id);
	}
	
	@PutMapping("/{id}")
	public Role updateRole(@PathVariable int id, @RequestBody Role role){
		return this.roleService.updateRole(id, role);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable int id){
		this.roleService.deleteRoleById(id);
	}
	
}