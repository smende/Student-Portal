package com.msd.portal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.Subject;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{

}
