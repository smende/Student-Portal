package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

import com.msd.portal.domain.Course;

/**
 * 
 * @author sudheer mende
 *
 */

public interface CourseService {
	
	public List<Course> getAll();
	public Course addNew(Course course);
	public Optional<Course> getById(long id);
	public void deleteById (long id);
	public Course updateById(long id,Course course);
}
