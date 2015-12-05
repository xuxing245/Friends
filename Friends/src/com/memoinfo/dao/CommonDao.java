package com.memoinfo.dao;

public interface CommonDao<T> {
	public int add(T t);
	
	public int update(T t);
	
	public T find(T t);
}
