package org.jrue.poc.springmybatis.service;

import org.jrue.poc.springmybatis.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * This service provides CRUD operations for {@link User} entity
 * @author jruelos
 *
 */
public interface UserService extends BaseService<User, Long>, UserDetailsService {

	User findByName(String name);
}