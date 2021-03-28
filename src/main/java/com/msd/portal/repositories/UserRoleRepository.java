package com.msd.portal.repositories;

import java.util.List;

/**
 * 
 * @author sudheer mende
 *
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long>{
	
	public List<UserRole> findAllUserRolesByUserId(long userId);
	
}
