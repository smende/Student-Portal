package com.msd.portal.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.Application;
import com.msd.portal.domain.User;
import com.msd.portal.enumtypes.ApplicationStatus;
import com.msd.portal.repositories.ApplicationRepository;
import com.msd.portal.service.ApplicationService;
import com.msd.portal.util.CommonUtil;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepo;


	@Override
	public List<Application> getAll() {
		return (List<Application>) this.applicationRepo.findAll();
	}

	@Override
	public List<Application> getAllByUserId(long userId) {
		return applicationRepo.findAllByUserId(userId);
	}
	
	@Override
	public List<Application> getAllByStatus(ApplicationStatus status) {
		return this.applicationRepo.findAllByStatus(status);
	}
	
	@Override
	public List<Application> getAllByUserIdAndStatus(long userId, String status) {
		ApplicationStatus appStatus = null;
		try {
			appStatus = ApplicationStatus.valueOf(status.toUpperCase());			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		return applicationRepo.findAllByUserIdAndStatus(userId, appStatus);
	}
	
	@Override
	public List<Application> getApplicationsByUserIdWhichAreNotAllowedToReApply(long userId) {
		List<ApplicationStatus> listOfStatus = CommonUtil.getAdmissionApplicationPositiveStatusList();

		return applicationRepo.findAllByUserIdAndStatusIn(userId, listOfStatus);
	}
	
	@Override
	public List<Application> getApplicationsByUserIdAndCourseByInTakeId(long userId, long courseByInTakeId) {		
		return applicationRepo.findByUserIdAndCourseByInTakeId(userId, courseByInTakeId);
	}
	
	
	@Override
	public boolean canUserApplyToCourseByInTakeRecord(long userId, long courseByInTakeId) {
		
		List<ApplicationStatus> listOfStatus = CommonUtil.getAdmissionApplicationPositiveStatusList();
					
		try {
			List<Application> admissionApplications = applicationRepo.findByUserIdAndCourseByInTakeIdAndStatusIn(userId, courseByInTakeId,listOfStatus);
			
			if(admissionApplications == null || admissionApplications.size() == 0)
				return true;
			else
				return false;
		}catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public Optional<Application> getById(long id) {
		return this.applicationRepo.findById(id);
	}

	@Override
	public Application addNew(Application application) {
		return this.applicationRepo.save(application);
	}

	@Override
	public Application updateById(long id, Application application) {
		Optional<Application> existingApplication = this.getById(id);
		
		if(existingApplication.get() == null || id != application.getId()) {
			return null;
		}else {
			return this.applicationRepo.save(application);
		}
	}

	@Override
	public void deleteById(long id) {
		this.applicationRepo.deleteById(id);
	}
	
	@Override
	public ResponseEntity<Object> withdrawOwnApplication(Application application, User currentUser) {

		Optional<Application> optApplication;
		
		try {
			if(application == null)
			{
				throw(new Exception());
			}
			
			optApplication = getById(application.getId());			
			optApplication.get();
		}catch (Exception e) {
			String str= "{\"message\" : \"Application not exist with id :"+application.getId()+" \" }";
			return new ResponseEntity<Object>(str,HttpStatus.NOT_FOUND);
		}
		
		if(optApplication.get().getStatus().equals(ApplicationStatus.WITHDREW)) {
			String str= "{\"message\" : \"Application :"+application.getId()+" is already withdrawn\" }";
			return new ResponseEntity<Object>(str,HttpStatus.NOT_IMPLEMENTED);
		}		
		else if(optApplication.get().getUser().getId() != currentUser.getId()) {
			String str= "{\"message\": \"Current user can not modify this Application record :" +application.getId()+"\"}";
			return new ResponseEntity<Object>(str,HttpStatus.FORBIDDEN);
		}
		
		optApplication.get().setStatus(ApplicationStatus.WITHDREW);
		optApplication.get().setUpdatedDate(new Date());
		
		updateById(application.getId(),optApplication.get());
		
		ResponseEntity<Object> response= new ResponseEntity<>(HttpStatus.OK);
		return response;
	}

}
