package com.msd.portal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.InTake;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface InTakeRepository extends PagingAndSortingRepository<InTake, Long>{
	List<InTake> findAllByActiveTrue();
	List<InTake> findAllByActiveFalse();
}
