package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

import com.msd.portal.domain.ClassRoom;;

/**
 * 
 * @author sudheer mende
 *
 */

public interface ClassRoomService {
	
	public List<ClassRoom> getAll();
	public ClassRoom addNew(ClassRoom classRoom);
	public Optional<ClassRoom> getById(long id);
	public void deleteById (long id);
	public ClassRoom updateById(long id,ClassRoom classRoom);
	public List<ClassRoom> getAllBySubjectId(long subjectId);
	public List<ClassRoom> getAllBySubjectName(String subjectName);
}
