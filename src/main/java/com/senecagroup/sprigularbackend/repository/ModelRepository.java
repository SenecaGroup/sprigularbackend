package com.senecagroup.sprigularbackend.repository;

import com.senecagroup.sprigularbackend.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

public interface ModelRepository extends JpaRepository<Model, String> {

    @Query(value = "SELECT M.name FROM Model M")
    List<String> findAllNames();

}
