package org.example.app.service;

import org.example.app.model.Book;

import org.example.app.model.Category;
import org.example.repository.BookRepository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class JpaBookService implements BookService{

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addBook(Book bookToAdd) {
        bookRepository.save(bookToAdd);
    }

    @Override
    public void editBook(Book bookToEdit) {
        bookRepository.save(bookToEdit);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByCategoryJpql(Long id) {
        return bookRepository.findByCategoryJpql(id);
    }

}