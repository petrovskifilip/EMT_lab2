package com.emt.backend.service;

import com.emt.backend.model.Author;
import com.emt.backend.model.Book;
import com.emt.backend.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> save(String name, Category category, Author author, Integer availableCopies);

    Optional<Book> findById(Long id);

    Optional<Book> edit(Long id, Book book);

    void delete(Long id);

    List<Book> getAllBooks();
}
