package com.busra.couriertracking.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "location")
public class Location {

	@Id
	private String id;

	private String name;

	private String author;

	public Location(String name, String author) {
		this.name = name;
		this.author = author;
	}

}