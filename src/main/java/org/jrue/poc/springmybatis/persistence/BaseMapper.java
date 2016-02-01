package org.jrue.poc.springmybatis.persistence;

import java.util.List;

public interface BaseMapper<T, ID> {
	
	List<T> findAll();
	
	T findOne(ID id);
	
	int count();
	
	boolean save(T persisted);
	
	boolean update(T persisted);
	
	void delete(T deleted);

}
