package com.lcwd.rating.service;

import java.util.List;

import com.lcwd.rating.entities.Rating;

public interface CRUDservice {
	// create
	Rating create(Rating rating);
	
	//delete
	void deleteById(String ratingId);

	// get all ratings
	List<Rating> getAllRatings();

	// get all by userId
	List<Rating> getRatingByUserId(String userId);

	// get all by hotelId
	List<Rating> getRatingByHotelId(String hotelId);
}
