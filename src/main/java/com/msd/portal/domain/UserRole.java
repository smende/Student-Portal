package com.msd.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.msd.portal.domain.generic.GenericDomain;

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

	
}
