package com.busra.couriertracking.controller;


import com.busra.couriertracking.domain.Book;
import com.busra.couriertracking.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

	private BookService bookService;

	BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/saveBook")
	public void saveBook() {
		bookService.saveBook();
		List<Book> bookList = bookService.findAll();
		System.out.println();
	}

}