package com.msd.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.msd.portal.domain.generic.GenericDomain;
import com.msd.portal.enumtypes.ApplicationStatus;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author sudheer mende
 *
 */

@Entity
@Setter
@Getter
@ConstructorBinding
@NoArgsConstructor
public class Application extends GenericDomain{

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name ="user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@NotNull
	@JoinColumn(name ="intake_id", referencedColumnName = "id")
	private InTake inTake;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name ="course_id", referencedColumnName = "id")
	private Course course;
	
	private String notes;
	
	private ApplicationStatus status = ApplicationStatus.SUBMITTED;

}	
