package com.msd.portal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.User;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public List<User> findAllUsersByFirstName(String firstName);

	public List<User> findAllUsersByLastName(String lastName);
}
