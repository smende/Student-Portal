package com.msd.portal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msd.portal.domain.Role;

/**
 * 
 * @author sudheer mende
 *
 */

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
