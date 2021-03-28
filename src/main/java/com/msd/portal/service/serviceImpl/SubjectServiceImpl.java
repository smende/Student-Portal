package com.msd.portal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.Subject;
import com.msd.portal.repositories.SubjectRepository;
import com.msd.portal.service.SubjectService;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public List<Subject> getAll() {
		return (List<Subject>) this.subjectRepository.findAll();
	}

	@Override
	public Subject addNew(Subject subject) {
		return this.subjectRepository.save(subject);
	}

	@Override
	public Optional<Subject> getById(long id) {
		return this.subjectRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {		
		this.subjectRepository.deleteById(id);
	}

	@Override
	public Subject updateById(long id, Subject subject) {
		Optional<Subject> existingSubject = this.getById(id);
		
		if(existingSubject.get() == null || id != subject.getId()) {
			return null;
		}else {
			return this.subjectRepository.save(subject);
		}
	}

}
