package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}