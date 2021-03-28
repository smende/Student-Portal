package com.msd.portal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.Course;
import com.msd.portal.repositories.CourseRepository;
import com.msd.portal.service.CourseService;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> getAll() {
		return (List<Course>) this.courseRepository.findAll();
	}

	@Override
	public Course addNew(Course course) {
		return this.courseRepository.save(course);
	}

	@Override
	public Optional<Course> getById(long id) {
		return this.courseRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		this.courseRepository.deleteById(id);	
	}

	@Override
	public Course updateById(long id, Course course) {
		Optional<Course> existingCourse = this.getById(id);
		
		if(existingCourse.get() == null || id != course.getId()) {
			return null;
		}else {
			return this.courseRepository.save(course);
		}
	}

}
