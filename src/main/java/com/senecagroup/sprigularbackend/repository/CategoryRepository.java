package com.senecagroup.sprigularbackend.repository;

import com.senecagroup.sprigularbackend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2018-09-23
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByParentOrderById(Category category);

    List<Category> findByLevel(int level);

}
