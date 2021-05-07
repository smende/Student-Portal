package com.msd.portal.web.api;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msd.portal.domain.Application;
import com.msd.portal.domain.User;
import com.msd.portal.enumtypes.ApplicationStatus;
import com.msd.portal.service.ApplicationService;
import com.msd.portal.service.UserService;

import io.swagger.annotations.ApiOperation;

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
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<Application> getAll(){
		return this.applicationService.getAll();
	}
	
	@GetMapping("/byuserid/{userId}")
	public List<Application> getAllByUserId(@PathVariable long userId){
		return this.applicationService.getAllByUserId(userId);
	}
	
	@GetMapping("/{id}")
	public Optional<Application> getById(@PathVariable long id){
		return this.applicationService.getById(id);
	}
	
	@GetMapping("/bystatus/{status}")
	public List<Application> getAllByStatus(@PathVariable ApplicationStatus status){
		return this.applicationService.getAllByStatus(status);
	}
	
	@GetMapping("/by_userid_and_status")
	public List<Application> getAllByUserIdAndStatus(@RequestParam long userid,@RequestParam(defaultValue = "SUBMITTED") String status){
		
		if(status.trim().length() == 0)
			status = ApplicationStatus.SUBMITTED.toString();
		
		return this.applicationService.getAllByUserIdAndStatus(userid, status.trim());
	}
	
	
	@ApiOperation(
			value = "Get All Applications which are not alllowed to re apply by userId",
			notes = "Get All applications with status only either SUBMITTED or UNDER_VERIFICATION or DECISION_PENDING or APPROVED",
			response = Application.class,
			responseContainer = "List")
	@GetMapping("/can_not_reapply_by_userid/{userid}")
	public List<Application> getApplicationsByUserIdWhichAreNotAllowedToReApply(@PathVariable long userid){
		return applicationService.getApplicationsByUserIdWhichAreNotAllowedToReApply(userid);
	}
	
	@GetMapping("/by_userid_and_coursebyintakeid")
	public List<Application> getByUserIdAndCourseByInTakeId(@RequestParam long userid,@RequestParam long coursebyintakeid){
		return this.applicationService.getApplicationsByUserIdAndCourseByInTakeId(userid,coursebyintakeid);
	}
	
	@GetMapping("/can_user_apply_courseintake")
	public boolean canUserApplyToCourseByInTakeRecord(@RequestParam long userid,@RequestParam long coursebyintakeid){
		return this.applicationService.canUserApplyToCourseByInTakeRecord(userid,coursebyintakeid);
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
	
	@PutMapping("/withdraw")
	public ResponseEntity<Object> withdrawApplication(@RequestBody Application application,Principal principal){
		return this.applicationService.withdrawOwnApplication(application,userService.getCurrentUser(principal));
	}
}
