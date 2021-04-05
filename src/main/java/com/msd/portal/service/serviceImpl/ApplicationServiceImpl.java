package com.msd.portal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.Application;
import com.msd.portal.enumtypes.ApplicationStatus;
import com.msd.portal.repositories.ApplicationRepository;
import com.msd.portal.service.ApplicationService;

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

}
