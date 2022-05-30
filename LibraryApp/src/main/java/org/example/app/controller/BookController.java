package org.example.app.controller;

import org.example.app.model.Book;
import org.example.repository.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller


public class BookController {

    private static final Logger logger = LoggerFactory.getLogger((BookController.class));

    private final BookRepository bookRepository;


    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    @RequestMapping(value = "/form/book", method = RequestMethod.GET,produces = "text/html; charset=UTF-8")
    public String getForm(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @RequestMapping(value = "/form/book", method = RequestMethod.POST)
    public String handle(@Valid Book book, BindingResult bindingResult) {
        ///sprawdzamy, czy są błędy po walidacji

        if (bindingResult.hasErrors()) {
            logger.error("książka ma nieprawidłowe dane");
            return "redirect:/form/book";
        }


        logger.info(book.toString());
        bookRepository.save(book);
        return "success";
    }
    @GetMapping("/book/findAll")
    @ResponseBody
    public String findAll(){
        List<Book> books;
        books = bookRepository.findAll();
       return books.stream()
               .map(Book::toString)
               .collect(Collectors.joining(" , "));
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "deleted";
    }


}



