package org.jrue.poc.springmybatis.persistence;

import org.jrue.poc.springmybatis.domain.User;

/**
 * Database Operations specific for Entity {@User}
 * 
 * @author jruelos
 *
 */
public interface UserMapper extends BaseMapper<User, Long> {
	
	User findByName(String name);
}