package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

import com.msd.portal.domain.Subject;

/**
 * 
 * @author sudheer mende
 *
 */

public interface SubjectService {
	public List<Subject> getAll();
	public Subject addNew(Subject subject);
	public Optional<Subject> getById(long id);
	public void deleteById (long id);
	public Subject updateById(long id,Subject subject);
}
