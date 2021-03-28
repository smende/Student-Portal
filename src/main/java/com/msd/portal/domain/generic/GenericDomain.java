package com.msd.portal.domain.generic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author sudheer mende
 *
 */

@Setter
@Getter
@MappedSuperclass
public abstract class GenericDomain {
	
	private boolean active = true;
	
	@Size(max = 25)
	@Column(updatable = false)
	private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd, yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	@Column(updatable = false)
	private Date createdDate = new Date();
	
	@Size(max = 25)
	private String updatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd, yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date updatedDate;
	
}
