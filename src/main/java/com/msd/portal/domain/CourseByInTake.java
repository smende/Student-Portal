package com.msd.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

import com.msd.portal.domain.generic.GenericDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "course_by_intake")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseByInTake extends GenericDomain{
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "intake_id", referencedColumnName = "id")
	private InTake inTake;

	@Override
	public String toString() {
		return "CourseByInTake [id=" + id + ", course=" + course.getId() + ", inTake=" + inTake.getId() + "]";
	}
	
	
	
}
