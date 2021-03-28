package com.msd.portal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.Course;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

}
