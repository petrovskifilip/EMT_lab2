package com.emt.backend.service;

import com.emt.backend.model.Author;
import com.emt.backend.model.Book;
import com.emt.backend.model.Category;
import com.emt.backend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Optional<Book> save(String name, Category category, Author author, Integer availableCopies) {
        return Optional.of(bookRepository.save(new Book(name, category, author, availableCopies)));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> edit(Long id, Book book) {
        Book bookDB = this.findById(id).orElseThrow(RuntimeException::new);

        bookDB.setAuthor(book.getAuthor());
        bookDB.setCategory(book.getCategory());
        bookDB.setAvailableCopies(book.getAvailableCopies());
        bookDB.setName(book.getName());

        return Optional.of(bookRepository.save(bookDB));
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
