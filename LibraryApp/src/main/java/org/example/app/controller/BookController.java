package org.example.app.controller;


import org.example.app.model.Book;
import org.example.app.model.Category;
import org.example.app.service.BookService;
import org.example.app.service.CategoryService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.util.List;

@Primary
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;


    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showPosts(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "books/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categories());
        return "books/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/add";
        } else {
            bookService.addBook(book);
            return "redirect:/books/all";
        }
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/show";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("categories",categories());
        return "books/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/edit";
        } else {
            bookService.editBook(book);
            return "redirect:/books/all";
        }
    }
    @ModelAttribute("categories")
    public List<Category> categories() {
        return this.categoryService.findAllCategories();
    }

}
