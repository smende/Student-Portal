package com.msd.portal.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msd.portal.domain.CourseByInTake;
import com.msd.portal.service.CourseByInTakeService;


@RestController
@RequestMapping(value = "/api/coursesbyintake")
public class CourseByIntakeController {

	@Autowired
	private CourseByInTakeService courseByInTakeService;
	
	@GetMapping("")
	public List<CourseByInTake> getAll(){
		return courseByInTakeService.getAll();
	}
	
	@PostMapping("")
	public CourseByInTake addNew(@RequestBody CourseByInTake coursesByInTake) throws Exception{
		 return courseByInTakeService.addNew(coursesByInTake);
	}
	
	@PostMapping("/bulksave")
	public List<CourseByInTake> bulkSave(@RequestBody List<CourseByInTake> coursesByInTake) throws Exception{
		return courseByInTakeService.bulkSave(coursesByInTake);
	}
	
}
