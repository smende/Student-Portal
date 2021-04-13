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
	
	public List<Application> findByUserIdAndCourseByInTakeId(long userId, long courseByInTakeId); 
	
	public List<Application> findByUserIdAndCourseByInTakeIdAndStatusIn(long userId, long courseByInTakeId, List<ApplicationStatus> statusList); 
	
	public List<Application> findAllByUserIdAndStatus(long userId, ApplicationStatus status);
	
	public List<Application> findAllByUserIdAndStatusIn(long userId, List<ApplicationStatus> statusList);

}
