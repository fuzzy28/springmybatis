package org.jrue.poc.springmybatis.persistence;

import java.util.List;

import org.jrue.poc.springmybatis.domain.Role;

/**
 * Database Operations specific for Entity {@UserRole}
 * 
 * @author jruelos
 *
 */
public interface UserRoleMapper extends BaseMapper<Role, Long> {
	
	List<Role> findRolesByUserId(int userId);
}