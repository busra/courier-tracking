package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

	@Override
	public <S extends Book> S save(S entity) {
		return null;
	}

	@Override
	public <S extends Book> List<S> saveAll(Iterable<S> iterable) {
		return null;
	}

	@Override
	public Optional<Book> findById(String s) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(String s) {
		return false;
	}

	@Override
	public List<Book> findAll() {
		return null;
	}

	@Override
	public Iterable<Book> findAllById(Iterable<String> strings) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(String s) {

	}

	@Override
	public void delete(Book entity) {

	}

	@Override
	public void deleteAll(Iterable<? extends Book> entities) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public List<Book> findAll(Sort sort) {
		return null;
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Book> S insert(S s) {
		return null;
	}

	@Override
	public <S extends Book> List<S> insert(Iterable<S> iterable) {
		return null;
	}

	@Override
	public <S extends Book> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends Book> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends Book> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public <S extends Book> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Book> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends Book> boolean exists(Example<S> example) {
		return false;
	}
}