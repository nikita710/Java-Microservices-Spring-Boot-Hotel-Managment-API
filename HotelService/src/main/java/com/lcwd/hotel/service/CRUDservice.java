package com.lcwd.hotel.service;

import java.util.List;

public interface CRUDservice<T> {
	// save
	T create(T t);

	// getAll
	List<T> getAll();

	// get single
	T getSingleHotel(String id);

	// delete
	void delete(String id);
}
