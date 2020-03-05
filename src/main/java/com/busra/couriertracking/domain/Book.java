package com.busra.couriertracking.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Book")
public class Book {

	@Id
	private String id;

	private String name;

	private String author;

	public Book(String id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}

}