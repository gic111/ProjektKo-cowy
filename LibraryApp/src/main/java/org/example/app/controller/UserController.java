package org.example.app.controller;

import org.example.app.model.User;
import org.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger((UserController.class));

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/form/user", method = RequestMethod.GET,produces = "text/html; charset=UTF-8")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @RequestMapping(value = "/form/user", method = RequestMethod.POST)
    public String handle(@Valid User user, BindingResult bindingResult) {
        ///sprawdzamy, czy są błędy po walidacji

        if (bindingResult.hasErrors()) {
            logger.error("użytkownik ma nieprawidłowe dane");
            return "redirect:/form/user";
        }


        logger.info(user.toString());
        userRepository.save(user);
        return "success";
    }
    @GetMapping("/user/findAll")
    @ResponseBody
    public String findAll(){
        List<User> users;
        users = userRepository.findAll();
        return users.stream()
                .map(User::toString)
                .collect(Collectors.joining(" , "));
    }

    @RequestMapping("/user/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "deleted";
    }


}
