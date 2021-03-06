package com.senecagroup.sprigularbackend.service.impl;

import com.senecagroup.sprigularbackend.domain.Category;
import com.senecagroup.sprigularbackend.model.CategorySet;
import com.senecagroup.sprigularbackend.repository.CategoryRepository;
import com.senecagroup.sprigularbackend.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sm123tt@gmail.com on 2018-09-23
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {


    @Inject
    CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getCategory(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getChildren(Category category) {
        return category.getChildren();
    }

    @Override
    public List<Category> getAncestors(Category category) {
        List<Category> result = new LinkedList<>();
        getParent(result, category);
        return result;
    }

    private void getParent(List<Category> result, Category category) {
        Category parent = category.getParent();
        if(parent == null) {
            return;
        }
        result.add(parent);
        getParent(result, parent);
    }

    @Override
    public Category getRoot(Category category) {
        if(category.isRoot()) {
            return category;
        }
        Category parent = category.getParent();
        return getRoot(parent);
    }

    @Override
    public boolean isLeaf(Category category) {
        return category.isLeaf();
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getChildren(Long id) {
        return getCategory(id)
                .map(parent -> getChildren(parent))
                .orElse(null);
    }

    public List<CategorySet> getCategorySet(int level) {
        List<Category> categories = categoryRepository.findByLevel(level);
        Set<String> names = categories.stream()
                .map(Category::getName)
                .collect(Collectors.toSet());
        return null;
    }
}
