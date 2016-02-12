package org.jrue.poc.springmybatis.service;

import java.util.List;

import org.jrue.poc.springmybatis.domain.Role;

public interface RoleService {

	List<Role> findAllRoles();
	
}
