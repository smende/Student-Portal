package com.msd.portal.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msd.portal.domain.PreRequisiteRelation;
import com.msd.portal.service.PreRequisiteRelationService;

/**
 * 
 * @author sudheer mende
 *
 */

@RestController
@RequestMapping("/api/prerequisites")
public class PreRequisiteRelationController {

	@Autowired
	private PreRequisiteRelationService preRequisiteRelationService;
	
	@GetMapping("")
	public List<PreRequisiteRelation> getAll(){
		return this.preRequisiteRelationService.getAll();
	}
	
	@PostMapping("")
	public PreRequisiteRelation addNew(@RequestBody PreRequisiteRelation preRequisiteRelation) {
		return this.preRequisiteRelationService.addNew(preRequisiteRelation);
	}
	
	@GetMapping("/{relationId}")
	public Optional<PreRequisiteRelation> getById(@PathVariable long relationId) {
		return this.preRequisiteRelationService.getById(relationId);
	}
	
	@GetMapping("/bymainsubjectid/{mainSubjectId}")
	public List<PreRequisiteRelation> getAllPreRequisiteSubjectsByMainSubjectId(@PathVariable long mainSubjectId) {
		return this.preRequisiteRelationService.getAllPreRequisiteSubjectsByMainSubjectId(mainSubjectId);
	}
	
	@GetMapping("/byprerequisitesubjectid/{preRequisiteSubjectId}")
	public List<PreRequisiteRelation> getAllMainSubjectsByPreRequisiteSubjectId(@PathVariable long preRequisiteSubjectId) {
		return this.preRequisiteRelationService.getAllMainSubjectsByPreRequisiteSubjectId(preRequisiteSubjectId);
	}
	
	@PutMapping("/{relationId}")
	public PreRequisiteRelation updateRecord(@PathVariable long relationId, @RequestBody PreRequisiteRelation preRequisiteRelation) {
		return this.preRequisiteRelationService.updateRecord(relationId, preRequisiteRelation);
	}
	
	@DeleteMapping("/{relationId}")
	public void deleteRelation(@PathVariable long relationId) {
		this.preRequisiteRelationService.deleteRelation(relationId);
	}
}
