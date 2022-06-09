package org.example.app.controller;



import org.example.app.model.User;
import org.example.app.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@Primary
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "users/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/add";
        }
        userService.addUser(user);
        return "redirect:/users/all";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String getCategory(@PathVariable Long id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "users/show";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "users/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/edit";
        } else {
            userService.editUser(user);
            return "redirect:/users/all";
        }
    }
}
