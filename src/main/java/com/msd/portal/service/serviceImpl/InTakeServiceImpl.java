package com.msd.portal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.msd.portal.domain.InTake;
import com.msd.portal.repositories.InTakeRepository;
import com.msd.portal.service.InTakeService;

/**
 * 
 * @author sudheer mende
 *
 */

@Service
public class InTakeServiceImpl implements InTakeService{

	@Autowired
	private InTakeRepository inTakeRepository;
	
	@Override
	public List<InTake> getAll() {
		return (List<InTake>) this.inTakeRepository.findAll(Sort.by("startDate").descending());
	}

	@Override
	public List<InTake> getAllActiveInTakes() {
		return (List<InTake>) this.inTakeRepository.findAllByActiveTrue();
	}

	@Override
	public List<InTake> getAllInActiveInTakes() {
		return (List<InTake>) this.inTakeRepository.findAllByActiveFalse();
	}
	
	@Override
	public Optional<InTake> getById(long id) {
		return this.inTakeRepository.findById(id);
	}

	@Override
	public InTake addNew(InTake inTake) {
		return this.inTakeRepository.save(inTake);
	}

	@Override
	public InTake updateById(long id, InTake inTake) {
		Optional<InTake> existingInTake = this.getById(id);
		
		if(existingInTake.get() == null || id != inTake.getId()) {
			return null;
		}else {
			return this.inTakeRepository.save(inTake);
		}
	}

	@Override
	public void deleteById(long id) {
		this.inTakeRepository.deleteById(id);		
	}

}
