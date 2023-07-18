package com.lcwd.hotel.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Hotel_Service")
public class Hotel {
	@Id
	private String id;
	private String name;
	private String location;
	private String about;
}
