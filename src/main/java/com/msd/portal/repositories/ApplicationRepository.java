package com.msd.portal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.Application;
import com.msd.portal.enumtypes.ApplicationStatus;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long>{
	
	public List<Application> findAllByStatus(ApplicationStatus status);
	
	public List<Application> findAllByUserId(long userId);
	
	public Application findByUserIdAndCourseByInTakeId(long userId, long courseByInTakeId); 
}
