package org.jrue.poc.springmybatis.service;

import org.jrue.poc.springmybatis.domain.User;

/**
 * This service provides CRUD operations for {@link User} entity
 * @author jruelos
 *
 */
public interface UserService extends BaseService<User, Long> {

	User findByName(String name);
}