package org.jrue.poc.springmybatis.persistence;

import java.util.List;

import org.jrue.poc.springmybatis.domain.Role;

public interface RoleMapper {

	List<Role> findAllRoles();
		
}
