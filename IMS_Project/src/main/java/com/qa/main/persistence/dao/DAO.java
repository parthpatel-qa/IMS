package com.qa.main.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	
	List<T> readAll();

	T create(T t);

	T update(T t);

	int delete(Long id);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;

}
