package com.memoinfo.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao<T> {
	public int add(T t);
	
	public int update(T t);
	
	public T find(T t);
	
	public T find(String id);
	
	public List<T> find(Map<String, String> params);
}
