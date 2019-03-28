package com.qaprosoft.navigator.dao;

public interface IDao <T> {
	void insert (T entity);
	T getById(int id);
	void update (T entity);
	void delete (T entity);
}
