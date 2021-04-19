package com.msd.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.msd.portal.domain.generic.GenericDomain;
import com.msd.portal.enumtypes.ApplicationStatus;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author sudheer mende
 *
 */

@Entity
@Setter
@Getter
public class Application extends GenericDomain{

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name ="user_id", referencedColumnName = "id")
	private User user;

//	@ManyToOne
//	@NotNull
//	@JoinColumn(name ="intake_id", referencedColumnName = "id")
//	private InTake inTake;
//	
//	@ManyToOne
//	@NotNull
//	@JoinColumn(name ="course_id", referencedColumnName = "id")
//	private Course course;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name ="courseByInTake_id", referencedColumnName = "id")
	private CourseByInTake courseByInTake;
	
	private String notes;
	
	private ApplicationStatus status = ApplicationStatus.SUBMITTED;

	@Override
	public String toString() {
		return "Application{" +
				"id=" + id +
				", user=" + user +
				", courseByInTake=" + courseByInTake +
				", notes='" + notes + '\'' +
				", status=" + status +
				'}';
	}
}
