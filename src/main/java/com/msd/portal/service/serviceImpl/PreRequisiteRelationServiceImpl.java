package com.msd.portal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.PreRequisiteRelation;
import com.msd.portal.repositories.PreRequisiteRelationRepository;
import com.msd.portal.service.PreRequisiteRelationService;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class PreRequisiteRelationServiceImpl implements PreRequisiteRelationService{

	@Autowired
	private PreRequisiteRelationRepository preRequisiteRelationRepository;
	
	@Override
	public List<PreRequisiteRelation> getAll() {
		return (List<PreRequisiteRelation>) this.preRequisiteRelationRepository.findAll();
		
	}

	@Override
	public Optional<PreRequisiteRelation> getById(long relationId) {
		return this.preRequisiteRelationRepository.findById(relationId);
	}

	@Override
	public List<PreRequisiteRelation> getAllPreRequisiteSubjectsByMainSubjectId(long mainSubjectId) {
		return this.preRequisiteRelationRepository.findListByMainSubjectId(mainSubjectId);
	}

	@Override
	public List<PreRequisiteRelation> getAllMainSubjectsByPreRequisiteSubjectId(long preRequisiteSubjectId) {
		return this.preRequisiteRelationRepository.findListByPreRequisiteSubjectId(preRequisiteSubjectId);
	}

	@Override
	public PreRequisiteRelation addNew(PreRequisiteRelation preRequisiteRelation) {
		return this.preRequisiteRelationRepository.save(preRequisiteRelation);
	}

	@Override
	public PreRequisiteRelation updateRecord(long relationId, PreRequisiteRelation preRequisiteRelation) {
		Optional<PreRequisiteRelation> existingRelation = this.getById(relationId);
		
		if(existingRelation.get() == null || relationId != preRequisiteRelation.getId()) {
			return null;
		}else {
			return this.preRequisiteRelationRepository.save(preRequisiteRelation);
		}
	}

	@Override
	public void deleteRelation(long relationId) {
		this.preRequisiteRelationRepository.deleteById(relationId);
	}

}
