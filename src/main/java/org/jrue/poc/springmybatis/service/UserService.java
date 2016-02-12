package org.jrue.poc.springmybatis.service;

import java.util.List;

import org.jrue.poc.springmybatis.domain.User;
import org.jrue.poc.springmybatis.domain.UserRole;

/**
 * This service provides CRUD operations for {@link User} entity
 * @author jruelos
 *
 */
public interface UserService extends BaseService<User, Long> {

	User findByName(String name);
	
	List<UserRole> findRolesByUserId(int userId);
}
