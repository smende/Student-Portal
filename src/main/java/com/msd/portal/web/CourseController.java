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

import com.msd.portal.domain.Course;
import com.msd.portal.service.CourseService;

/**
 * 
 * @author sudheer mende
 *
 */

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public List<Course> getAllCourses(){
		return this.courseService.getAll();
	}
	
	@PostMapping("")
	public Course addNew(@RequestBody Course course){
		return this.courseService.addNew(course);
	}
	
	@GetMapping("/{id}")
	public Optional<Course> getById(@PathVariable int id){
		return this.courseService.getById(id);
	}
	
	@PutMapping("/{id}")
	public Course updateById(@PathVariable int id, @RequestBody Course course){
		return this.courseService.updateById(id, course);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id){
		this.courseService.deleteById(id);
	}

}
