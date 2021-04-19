package com.msd.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.msd.portal.domain.generic.GenericDomain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 
 * @author sudheer mende
 *
 */

@Entity
@Setter
@Getter
public class User extends GenericDomain{
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min = 3)
	@Column(nullable = false)
	@NotEmpty
	private String firstName;
	
	@Size(min = 3)
	@Column(nullable = false)
	@NotEmpty
	private String lastName;
	
	//Should be auto generated based on few set of rules 
	@NonNull
	@Column(updatable = false)
	private String userName;
	
	private String email;
	private String cell;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", userName='" + userName + '\'' +
				", email='" + email + '\'' +
				", cell='" + cell + '\'' +
				'}';
	}
}
