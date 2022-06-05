package org.example.app.controller;

import org.example.app.model.Category;
import org.example.repository.CategoryRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Primary
public class CategoryController {


    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("category", new Category());
        return "category";
    }
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "category";
        }
        categoryRepository.save(category);
        return "success";
    }

    @RequestMapping("/category/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable Long id, @PathVariable String name) {
        Category category = categoryRepository.getOne(id);
        category.setName(name);
        categoryRepository.save(category);
        return category.toString();
    }

    @RequestMapping("/category/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.toString();
    }

    @RequestMapping("/category/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable Long id) {
        Category category = categoryRepository.getOne(id);
        categoryRepository.delete(category);
        return "deleted";
    }






}

