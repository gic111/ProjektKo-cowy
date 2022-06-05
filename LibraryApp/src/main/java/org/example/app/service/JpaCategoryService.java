package org.example.app.service;

import org.example.app.model.Category;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class JpaCategoryService implements CategoryService {


    private  final CategoryRepository categoryRepository;

    public JpaCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addCategory(Category categoryToAdd) {
        categoryRepository.save(categoryToAdd);

    }

    @Override
    public void editCategory(Category categoryToEdit) {
        categoryRepository.save(categoryToEdit);

    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
