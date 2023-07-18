package com.lcwd.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.service.entities.Rating;

@Service
@FeignClient(name = "RATING-SERVICE", path = "ratings")
public interface RatingService {

	// get
	@GetMapping("users/{userId}")
	List<Rating> getRatingsByUserId(@PathVariable String userId);

	// POST

	@PostMapping
	ResponseEntity<Rating> createRating(Rating values);

	// PUT
	@PutMapping("/{ratingId}")
	ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

	@DeleteMapping("/{ratingId}")
	void deleteRating(@PathVariable String ratingId);

}
