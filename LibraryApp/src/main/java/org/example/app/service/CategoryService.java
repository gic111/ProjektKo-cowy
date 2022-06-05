package org.example.app.service;


import org.example.app.model.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);

    void addCategory(Category categoryToAdd);

    void editCategory(Category categoryToEdit);

    void deleteCategory(Long id);

    List<Category> findAllCategories();
}
