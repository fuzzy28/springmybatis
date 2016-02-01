package org.jrue.poc.springmybatis.service;

import java.util.List;

public interface BaseService<T, ID> {
	
	boolean save(T persisted);
	
	boolean update(T persisted);
	
	void delete(T deleted);
	
	List<T> findAll();
	
	T findOne(ID id);
	
	int count();
}
