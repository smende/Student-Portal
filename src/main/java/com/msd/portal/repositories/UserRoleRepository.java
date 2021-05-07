package com.msd.portal.repositories;

import java.util.List;
import java.util.Optional;

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
	
	public List<UserRole> findByUserIdAndIsCurrentRoleTrue(long userId);
	
	public List<UserRole> findByUserUserNameAndIsCurrentRoleTrue(String userName);
	
}
