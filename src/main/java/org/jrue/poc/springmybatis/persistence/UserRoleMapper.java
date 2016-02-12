package org.jrue.poc.springmybatis.persistence;

import java.util.List;

import org.jrue.poc.springmybatis.domain.UserRole;

/**
 * Database Operations specific for Entity {@UserRole}
 * 
 * @author jruelos
 *
 */
public interface UserRoleMapper extends BaseMapper<UserRole, Long> {
	
	List<UserRole> findRolesByUserId(int userId);
}