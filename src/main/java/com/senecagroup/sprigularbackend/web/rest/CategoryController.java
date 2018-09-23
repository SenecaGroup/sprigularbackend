package com.senecagroup.sprigularbackend.web.rest;

import com.senecagroup.sprigularbackend.domain.Category;
import org.hibernate.service.spi.InjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2018-09-23
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@RestController("/category")
public class CategoryController {

    @GetMapping
    public List<Category> categories() {
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setName("dummy");
        categories.add(category);
        return categories;
    }
}
