package com.msd.portal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msd.portal.domain.Course;
import com.msd.portal.domain.CourseByInTake;
import com.msd.portal.domain.InTake;
import com.msd.portal.repositories.CourseByInTakeRepository;
import com.msd.portal.service.CourseByInTakeService;
import com.msd.portal.service.CourseService;
import com.msd.portal.service.InTakeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CourseByInTakeServiceImpl implements CourseByInTakeService{

	@Autowired
	private CourseByInTakeRepository courseByInTakeRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private InTakeService inTakeService;
	
	@Override
	public List<CourseByInTake> getAll() {
		return (List<CourseByInTake>) courseByInTakeRepository.findAll(Sort.by("inTake.startDate").descending().and(Sort.by("course.name").descending()));
	}
	
	@Override
	public CourseByInTake addNew(CourseByInTake courseByInTake) throws Exception  {
		

		if(courseByInTake.getCourse() == null ||
		  courseByInTake.getInTake() == null
		  ) {
			throw(new Exception());
		}

		Optional<Course> optionalCourse = courseService.getById(courseByInTake.getCourse().getId());
		Optional<InTake> optionalInTake = inTakeService.getById(courseByInTake.getInTake().getId());
		
		if(optionalCourse.get() == null ||
		   optionalInTake.get() == null) {
					throw(new Exception());
		}
		
		courseByInTake.setCourse(optionalCourse.get());
		courseByInTake.setInTake(optionalInTake.get());
		
		courseByInTakeRepository.save(courseByInTake);
		return courseByInTake;
	}
	
	@Override
	public List<CourseByInTake> bulkSave(List<CourseByInTake> coursesByInTake) throws Exception {
		if(coursesByInTake.size()>0) {
					
					for(CourseByInTake courseByInTake:coursesByInTake) {
						
							if(courseByInTake.getCourse() == null ||
							  courseByInTake.getInTake() == null
							  ) {
								throw(new Exception());
							}

							Optional<Course> optionalCourse = courseService.getById(courseByInTake.getCourse().getId());
							Optional<InTake> optionalInTake = inTakeService.getById(courseByInTake.getInTake().getId());
							
							if(optionalCourse.get() == null ||
							   optionalInTake.get() == null) {
										throw(new Exception());
							}
							
							courseByInTake.setCourse(optionalCourse.get());
							courseByInTake.setInTake(optionalInTake.get());
							
						this.addNew(courseByInTake);
					}			
					return coursesByInTake;
		}
		return null;
	}

}
