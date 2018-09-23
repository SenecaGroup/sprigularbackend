package com.senecagroup.sprigularbackend.model;

import java.util.*;

/**
 * Created by sm123tt@gmail.com on 2018-09-23
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

public class CategorySet {

    private final Map<String, Set<Long>> value = new HashMap<>();

    public CategorySet(Set<String> values) {
        for(String name: values) {
            value.put(name, new HashSet<>());
        }
    }

    public int add(String name, long[] ids) {
        Set<Long> categories = getIds(name);
        int count = 0;
        for(Long id: ids) {
            count++;
            categories.add(id);
        }
        return count;
    }

    public boolean add(String name, long id) {
        Set<Long> categoryIds = getIds(name);
        return categoryIds.add(id);
    }

    private Set<Long> getIds(String name) {
        return value.get(name);
    }

    public void remove(String name) {
        value.remove(name);
    }

}
