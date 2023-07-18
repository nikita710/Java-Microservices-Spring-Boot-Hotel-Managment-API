package com.lcwd.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.hotel.entities.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}
