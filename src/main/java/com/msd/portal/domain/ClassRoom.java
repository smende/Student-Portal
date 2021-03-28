package com.msd.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.msd.portal.domain.generic.GenericDomain;

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
public class ClassRoom extends GenericDomain{
	
	@Id
	@GeneratedValue
	private long id; 
	@Column(nullable = false)
	private String name;
	
	@OneToOne
	private Subject subject;
	
	private String section;
	private String details;
	
}
