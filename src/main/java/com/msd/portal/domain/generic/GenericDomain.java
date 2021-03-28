package com.msd.portal.domain.generic;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author sudheer mende
 *
 */

@Setter
@Getter
public class GenericDomain {
	
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

}
