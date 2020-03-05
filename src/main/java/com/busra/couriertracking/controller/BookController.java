package com.busra.couriertracking.controller;


import com.busra.couriertracking.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/saveBook")
	public void saveBook() {
		bookService.saveBook();
	}

}