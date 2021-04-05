package com.msd.portal.web.api;

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

import com.msd.portal.domain.Subject;
import com.msd.portal.service.SubjectService;

/**
 * 
 * @author sudheer mende
 *
 */

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("")
	public List<Subject> getAll(){
		return this.subjectService.getAll();
	}
	
	@PostMapping("")
	public Subject addNew(@RequestBody Subject subject){
		return this.subjectService.addNew(subject);
	}
	
	@GetMapping("/{id}")
	public Optional<Subject> getById(@PathVariable int id){
		return this.subjectService.getById(id);
	}
	
	@PutMapping("/{id}")
	public Subject updateById(@PathVariable int id, @RequestBody Subject subject){
		return this.subjectService.updateById(id, subject);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBgId(@PathVariable int id){
		this.subjectService.deleteById(id);
	}
	
	
}
