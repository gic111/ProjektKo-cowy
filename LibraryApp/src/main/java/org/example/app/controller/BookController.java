package org.example.app.controller;

import org.example.app.model.Book;
import org.example.app.service.BookService;
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
@RequestMapping("/admin/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showPosts(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "allBooks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "addBook";
        } else {
            bookService.addBook(book);
            return "redirect:/admin/books/all";
        }
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "show";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "updateBook";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "updateBook";
        } else {
            bookService.editBook(book);
            return "redirect:/admin/books/all";
        }
    }

}



