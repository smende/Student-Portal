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

import com.msd.portal.domain.InTake;
import com.msd.portal.service.InTakeService;

/**
 * 
 * @author sudheer mende
 *
 */

@RestController
@RequestMapping("/api/intake")
public class InTakeController {

	@Autowired
	private InTakeService inTakeService;
	
	@GetMapping("")
	public List<InTake> getAll(){
		return this.inTakeService.getAll();
	}
	
	@GetMapping("/activeintakes")
	public List<InTake> getAllActiveInTakes(){
		return this.inTakeService.getAllActiveInTakes();
	}
	
	@GetMapping("/inactiveintakes")
	public List<InTake> getAllInActiveInTakes(){
		return this.inTakeService.getAllInActiveInTakes();
	}
	
	@GetMapping("/{id}")
	public Optional<InTake> getById(@PathVariable long id){
		return this.inTakeService.getById(id);
	}
	
	@PostMapping("")
	public InTake addNew(@RequestBody InTake inTake) {
		return this.inTakeService.addNew(inTake);
	}
	
	@PutMapping("/{id}")
	public InTake updateById(@PathVariable long id, @RequestBody InTake inTake) {
		return this.inTakeService.updateById(id, inTake);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		this.inTakeService.deleteById(id);
	}
}
