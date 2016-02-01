package org.jrue.poc.springmybatis.service;

import java.util.List;

import org.jrue.poc.springmybatis.domain.User;
import org.jrue.poc.springmybatis.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provide implementation of UserService interface which delegates
 * the implemented methods to User Repository.
 * 
 * @author jruelos
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userRepository) {
		this.userMapper = userRepository;
	}
	
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
	
}