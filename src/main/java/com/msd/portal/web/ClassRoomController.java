package com.msd.portal.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msd.portal.domain.ClassRoom;
import com.msd.portal.service.ClassRoomService;

@RestController
@RequestMapping("/api/classroom")
public class ClassRoomController {

	@Autowired
	private ClassRoomService classRoomService;
	
	@GetMapping("")
	public List<ClassRoom> getAllCourses(){
		return this.classRoomService.getAll();
	}
	
	@PostMapping("")
	public ClassRoom addNew(@RequestBody ClassRoom classRoom){
		return this.classRoomService.addNew(classRoom);
	}
	
	@GetMapping("/{id}")
	public Optional<ClassRoom> getById(@PathVariable int id){
		return this.classRoomService.getById(id);
	}
	
	@PutMapping("/{id}")
	public ClassRoom updateById(@PathVariable int id, @RequestBody ClassRoom classRoom){
		return this.classRoomService.updateById(id, classRoom);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id){
		this.classRoomService.deleteById(id);
	}
	
	@GetMapping("/subjectid/{subjectId}")
	public List<ClassRoom> getClassRoomListBySubjectId(@PathVariable long subjectId){
		return this.classRoomService.getAllBySubjectId(subjectId);
	}
	
	@GetMapping("/subjectname/{subjectName}")
	public List<ClassRoom> getClassRoomListBySubjectName(@PathVariable String subjectName){
		return this.classRoomService.getAllBySubjectName(subjectName);
	}
}
