package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.msd.portal.domain.Application;
import com.msd.portal.enumtypes.ApplicationStatus;

/**
 * 
 * @author sudheer mende
 *
 */

public interface ApplicationService {	
	public List<Application> getAll();
	public List<Application> getAllByUserId(long userId);
	public List<Application> getAllByStatus(ApplicationStatus status);
	public Application getApplicationsByUserIdAndCourseByInTakeId(long userId,long courseByInTakeId);
	public boolean canUserApplyToCourseByInTakeRecord(long userId,long courseByInTakeId);
	public Optional<Application> getById(long id);
	public Application addNew(Application application);
	public Application updateById(long id, Application application);
	public void deleteById(long id);
	public ResponseEntity<Object> withdrawOwnApplication(Application application);
}
