package com.msd.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.msd.portal.domain.generic.GenericDomain;
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
public class SubjectsToClassRoom extends GenericDomain{

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "class_room_id", referencedColumnName = "id")
	private ClassRoom classRoom;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="subject_id", referencedColumnName = "id")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name="user_role_id")
	private UserRole userRole;
}
