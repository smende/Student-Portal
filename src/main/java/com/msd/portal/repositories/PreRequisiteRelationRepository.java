package com.msd.portal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.PreRequisiteRelation;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface PreRequisiteRelationRepository extends CrudRepository<PreRequisiteRelation, Long>{
	
	public List<PreRequisiteRelation> findListByMainSubjectId(long mainSubjectId);
	public List<PreRequisiteRelation> findListByPreRequisiteSubjectId(long preRequisiteSubjectId);
 }
