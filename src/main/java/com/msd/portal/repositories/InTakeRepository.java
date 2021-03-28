package com.msd.portal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.InTake;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface InTakeRepository extends CrudRepository<InTake, Long>{

	public List<InTake> findAllByActiveTrue();
}
