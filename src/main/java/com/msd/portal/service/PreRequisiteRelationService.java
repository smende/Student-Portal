package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

import com.msd.portal.domain.PreRequisiteRelation;

/**
 * 
 * @author sudheer mende
 *
 */

public interface PreRequisiteRelationService {

	public List<PreRequisiteRelation> getAll();
	public PreRequisiteRelation addNew(PreRequisiteRelation preRequisiteRelation);
	public Optional<PreRequisiteRelation> getById(long relationId);
	public List<PreRequisiteRelation> getAllPreRequisiteSubjectsByMainSubjectId(long mainSubjectId);
	public List<PreRequisiteRelation> getAllMainSubjectsByPreRequisiteSubjectId(long preRequisiteSubjectId);
	public PreRequisiteRelation updateRecord(long relationId,PreRequisiteRelation preRequisiteRelation);
	public void deleteRelation(long relationId);
}
