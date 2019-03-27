package com.qaprosoft.navigator.dao;

public interface IDao <T> {
	T getByID(int id);
	void update(T entity);
	void delete(T entity);
	void save (T entity);
}
