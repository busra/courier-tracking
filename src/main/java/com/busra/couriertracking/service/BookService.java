package com.busra.couriertracking.service;

import com.busra.couriertracking.domain.Book;

import java.util.List;

public interface BookService {

    void saveBook();

    List<Book> findAll();

}