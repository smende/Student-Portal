package com.msd.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class UserRole extends GenericDomain{

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name="role_id",referencedColumnName = "id")
	private Role role;

	private boolean isCurrentRole;
}
