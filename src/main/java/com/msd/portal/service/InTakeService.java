package com.msd.portal.service;

import java.util.List;
import java.util.Optional;

import com.msd.portal.domain.InTake;

/**
 * 
 * @author sudheer mende
 *
 */

public interface InTakeService {

	public List<InTake> getAll();
	public List<InTake> getAllActiveInTakes();
	public List<InTake> getAllInActiveInTakes();
	public Optional<InTake> getById(long id);
	public InTake addNew(InTake inTake);
	public InTake updateById(long id,InTake inTake);
	public void deleteById(long id);
	
}
