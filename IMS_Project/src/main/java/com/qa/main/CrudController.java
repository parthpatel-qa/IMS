package com.qa.main;

import java.util.List;

public interface CrudController<T> {

	List<T> readAll();
	
	T read();
	
	T create();
	
	T update();
	
	int delete();
	
	
}
