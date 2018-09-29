package com.senecagroup.sprigularbackend.web.rest;

import com.senecagroup.sprigularbackend.domain.Category;
import com.senecagroup.sprigularbackend.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2018-09-23
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    @GetMapping
    public List<Category> categories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Category category(@PathVariable Long id) {
        return categoryService.getCategory(id).orElse(null);
    }

    @GetMapping("/children/{id}")
    public List<Category> children(@PathVariable Long id) {
        return categoryService.getChildren(id);
    }

}
