package org.jrue.poc.springmybatis.service;

import java.util.List;

import org.jrue.poc.springmybatis.domain.Role;
import org.jrue.poc.springmybatis.persistence.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	private RoleMapper roleMapper;
	
	@Autowired
	public RoleServiceImpl(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
	@Override
	public List<Role> findAllRoles() {
		return roleMapper.findAllRoles();
	}
}