package com.msd.portal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.ClassRoom;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom, Long>{

	public List<ClassRoom> findClassRoomsBySubjectId(long subjectId);
	public List<ClassRoom> findClassRoomsBySubjectName(String subjectName);
}
