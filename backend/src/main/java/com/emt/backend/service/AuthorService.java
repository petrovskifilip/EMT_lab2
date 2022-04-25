package com.emt.backend.service;

import com.emt.backend.model.Author;
import com.emt.backend.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> save(String name, String surname, Country country);

    Optional<Author> findById(Long id);

    Optional<Author> edit(Long id, Author author);

    void delete(Long id);

    List<Author> getAllAuthors();

}
