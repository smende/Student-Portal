package com.msd.portal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface CourseRepository extends CrudRepository<com.msd.portal.domain.Course, Long>{

}
