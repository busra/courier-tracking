package com.busra.couriertracking.service;

import com.busra.couriertracking.domain.Book;
import com.busra.couriertracking.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook() {
        try {
            Book book1 = new Book("bookOsman", "busra");
            Book book2 = new Book("bookOsman2", "busra2");
            Book book3 = new Book("bookOsman3", "busra3");
            Book book4 = new Book("bookOsman4", "busra4");

            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
        } catch (Exception e) {
            System.out.println("test");
        }
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}