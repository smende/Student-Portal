package com.msd.portal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.SubjectsToClassRoom;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface SubjectToClassRoomRepository extends CrudRepository<SubjectsToClassRoom, Long>{

}
