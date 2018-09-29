package com.senecagroup.sprigularbackend.service;

import com.senecagroup.sprigularbackend.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * Created by sm123tt@gmail.com on 2018-09-23
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

public interface CategoryService {

    Optional<Category> getCategory(long id);

    List<Category> getChildren(Category category);

    List<Category> getAncestors(Category category);

    Category getRoot(Category category);

    boolean isLeaf(Category category);

    List<Category> getCategories();

    List<Category> getChildren(Long id);
}
