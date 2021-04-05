package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<Application> getById(long id);
	public Application addNew(Application application);
	public Application updateById(long id, Application application);
	public void deleteById(long id);
}
