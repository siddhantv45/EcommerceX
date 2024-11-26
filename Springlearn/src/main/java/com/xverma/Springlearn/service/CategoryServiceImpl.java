package com.xverma.Springlearn.service;

import com.xverma.Springlearn.model.Category;
import com.xverma.Springlearn.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private Long manageId=1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(manageId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"no such element found"));

        categoryRepository.delete(category);
        return "Successfully deleted the item";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category category1 = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"no such element found"));
        category.setCategoryId(categoryId);
        category1 = categoryRepository.save(category);

       return category1;
    }
}
