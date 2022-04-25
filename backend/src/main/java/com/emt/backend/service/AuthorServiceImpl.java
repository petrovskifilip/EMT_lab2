package com.emt.backend.service;

import com.emt.backend.model.Author;
import com.emt.backend.model.Country;
import com.emt.backend.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Override
    public Optional<Author> save(String name, String surname, Country country) {
        return Optional.of(authorRepository.save(new Author(name, surname, country)));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> edit(Long id, Author author) {
        Author authorDB = this.findById(id).orElseThrow(RuntimeException::new);

        authorDB.setName(author.getName());
        authorDB.setCountry(author.getCountry());
        authorDB.setSurname(author.getSurname());

        return Optional.of(authorRepository.save(authorDB));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
