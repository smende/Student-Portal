package com.msd.portal.service;

import java.util.List;

import com.msd.portal.domain.CourseByInTake;

public interface CourseByInTakeService {

	public List<CourseByInTake> getAll();
	public CourseByInTake addNew(CourseByInTake courseByInTake) throws Exception ;
	public List<CourseByInTake> bulkSave(List<CourseByInTake> coursesByInTake) throws Exception ;
}
