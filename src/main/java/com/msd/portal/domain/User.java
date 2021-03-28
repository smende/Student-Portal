package com.msd.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class User extends GenericDomain{
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String email;
	private String cell;
	
}
