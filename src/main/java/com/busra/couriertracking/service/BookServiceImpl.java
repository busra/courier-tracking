package com.busra.couriertracking.service;

import com.busra.couriertracking.domain.Book;
import com.busra.couriertracking.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public void saveBook () {
		Book book1 = new Book("1", "bookOsman", "busra");
		Book book2 = new Book("2", "bookOsman2", "busra2");

		bookRepository.save(book1);
		bookRepository.save(book2);
	}

}