package org.example.app.controller;


import org.example.app.model.Category;
import org.example.app.service.CategoryService;


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
@RequestMapping("/categories")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "categories/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "categories/add";
        }
        categoryService.addCategory(category);
        return "redirect:/categories/all";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String getCategory(@PathVariable Long id, Model model) {
        model.addAttribute("categories",categoryService.getCategoryById(id));
        return "categories/show";

    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories/all";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryService.getCategoryById(id));
        return "categories/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categories/edit";
        } else {
            categoryService.editCategory(category);
            return "redirect:/categories/all";
        }
    }








}

