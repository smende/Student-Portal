package com.msd.portal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.ClassRoom;
import com.msd.portal.repositories.ClassRoomRepository;
import com.msd.portal.service.ClassRoomService;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class ClassRoomServiceImpl implements ClassRoomService{

	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	@Override
	public List<ClassRoom> getAll() {
		return (List<ClassRoom>) this.classRoomRepository.findAll();
	}

	@Override
	public ClassRoom addNew(ClassRoom classRoom) {
		return this.classRoomRepository.save(classRoom);
	}

	@Override
	public Optional<ClassRoom> getById(long id) {
		return this.classRoomRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		this.classRoomRepository.deleteById(id);
		
	}

	@Override
	public ClassRoom updateById(long id, ClassRoom classRoom) {
		Optional<ClassRoom> existingClassRoom = this.getById(id);
		
		if(existingClassRoom.get() == null || id != classRoom.getId()) {
			return null;
		}else {
			return this.classRoomRepository.save(classRoom);
		}
	}

	@Override
	public List<ClassRoom> getAllBySubjectId(long subjectId) {
		return this.classRoomRepository.findClassRoomsBySubjectId(subjectId);
	}

	@Override
	public List<ClassRoom> getAllBySubjectName(String subjectName) {
		return this.classRoomRepository.findClassRoomsBySubjectName(subjectName);
	}


}
