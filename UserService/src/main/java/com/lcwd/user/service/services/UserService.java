package com.lcwd.user.service.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.external.services.RatingService;
import com.lcwd.user.service.repository.UserRepository;

@Service
public class UserService implements CRUDservice {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private RatingService ratingService;

//	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public User saveUser(User user) {
		// generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id s not found on server !! :" + userId));

		// Rest Template
//		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
//				Rating[].class);
//		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

		// Feign client
		List<Rating> ratings = ratingService.getRatingsByUserId(userId);

		List<Rating> ratingList = ratings.stream().map(rating -> {

			// Get info using RestTemplate

			// ResponseEntity<Hotel> forEntity = restTemplate
			// .getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
			// Hotel.class);
			// Hotel hotel = forEntity.getBody();

			// get info using Feign client
			Hotel hotel = hotelService.getHotel(rating.getHotelId());

			rating.setHotel(hotel);

			return rating;

		}).collect(Collectors.toList());

		user.setRatings(ratingList);

		return user;
	}

	@Override
	public void delete(String userId) {
		userRepository.deleteById(userId);

	}

}
