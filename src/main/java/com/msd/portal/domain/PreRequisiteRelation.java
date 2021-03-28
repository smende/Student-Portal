package com.msd.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.msd.portal.domain.generic.GenericDomain;
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
public class PreRequisiteRelation extends GenericDomain{

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "main_subject_id",referencedColumnName = "id")
	private Subject mainSubject;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "pre_requisite_subject_id",referencedColumnName = "id")
	private Subject preRequisiteSubject;

	
}
