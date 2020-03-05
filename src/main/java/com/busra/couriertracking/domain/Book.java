package com.busra.couriertracking.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "book")
public class Book {

	@Id
	private String id;

	private String name;

	private String author;

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

}