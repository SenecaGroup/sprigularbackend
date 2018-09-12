package com.senecagroup.sprigularbackend.repository;

import com.senecagroup.sprigularbackend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query("select c.name from Category c where c.name = :name")
    Optional<Category> findByName(@Param("name") String name);

    @Query("select distinct c from Category c where c.parent = :parent")
    List<Category> findByParent(@Param("parent") Category parent);
    
}
