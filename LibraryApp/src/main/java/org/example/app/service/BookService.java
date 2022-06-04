package org.example.app.service;


import org.example.app.model.Book;

import java.util.List;

public interface BookService {

    Book getBookById(Long id);

    void addBook(Book bookToAdd);

    void editBook(Book bookToEdit);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}