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

import com.msd.portal.domain.Application;
import com.msd.portal.enumtypes.ApplicationStatus;
import com.msd.portal.service.ApplicationService;

/**
 * 
 * @author sudheer mende
 *
 */

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	@GetMapping("")
	public List<Application> getAll(){
		return this.applicationService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Application> getById(@PathVariable long id){
		return this.applicationService.getById(id);
	}
	
	@GetMapping("/bystatus/{status}")
	public List<Application> getById(@PathVariable ApplicationStatus status){
		return this.applicationService.getAllByStatus(status);
	}
	
	@PostMapping("")
	public Application addNew(@RequestBody Application application) {
		return this.applicationService.addNew(application);
	}
	
	@PutMapping("/{id}")
	public Application updateById(@PathVariable long id, @RequestBody Application application) {
		return this.applicationService.updateById(id, application);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		this.applicationService.deleteById(id);
	}
}
