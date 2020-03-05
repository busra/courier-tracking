package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookDaoImpl implements BookDao {

    private BookRepository bookRepository;

    BookDaoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

}