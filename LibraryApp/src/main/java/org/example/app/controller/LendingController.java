package org.example.app.controller;

import org.example.app.model.Book;

import org.example.app.model.Lending;
import org.example.app.model.User;
import org.example.app.service.BookService;
import org.example.app.service.LendingService;
import org.example.app.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@Primary
@RequestMapping("/lend")
public class LendingController {

    private final LendingService lendingService;
    private final BookService bookService;
    private final UserService userService;


    public LendingController(LendingService lendingService, BookService bookService, UserService userService) {
        this.lendingService = lendingService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showCategories(Model model) {
        model.addAttribute("lendings", lendingService.findAllLendings());
        return "lendings/all";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addLendForm(Model model) {
        model.addAttribute("lendings", new Lending());
        model.addAttribute("books", booksList());
        model.addAttribute("users", usersList());
        return "lendings/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLending(@Valid Lending lending, BindingResult result) {
        if (result.hasErrors()) {
            return "lendings/add";
        } else {
            lendingService.addLending(lending);
            return "redirect:/lendings/all";
        }
    }


    @ModelAttribute("books")
    public List<Book> booksList() {
        return this.bookService.findAllBooks();
    }
    @ModelAttribute("users")
    public List<User> usersList() {
        return this.userService.findAllUsers();
    }
}
