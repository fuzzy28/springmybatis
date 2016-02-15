package org.jrue.poc.springmybatis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jrue.poc.springmybatis.domain.Role;
import org.jrue.poc.springmybatis.domain.User;
import org.jrue.poc.springmybatis.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provide implementation of UserService interface which delegates the
 * implemented methods to User Repository.
 * 
 * @author jruelos
 * 
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean save(User persisted) {
		return userMapper.save(persisted);
	}

	@Override
	public boolean update(User persisted) {
		return userMapper.update(persisted);
	}

	@Override
	public void delete(User deleted) {
		userMapper.delete(deleted);
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userMapper.findOne(id);
	}

	@Override
	public int count() {
		return userMapper.count();
	}

	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = findByName(username);
		org.springframework.security.core.userdetails.User userDetails = null;
		if (user != null && user.getName() != null) {
			userDetails = new org.springframework.security.core.userdetails.User(
					username, user.getPassword(), authorities(user.getRoles()));
		}
		return userDetails;
	}
	
	private List<GrantedAuthority> authorities(List<Role> roles) {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>(roles.size());
		
		for (Role role : roles) {
			auths.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return Collections.unmodifiableList(auths);
	}
}