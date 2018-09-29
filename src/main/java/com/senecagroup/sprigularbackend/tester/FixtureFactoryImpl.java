package com.senecagroup.sprigularbackend.tester;

import com.senecagroup.sprigularbackend.domain.Category;
import com.senecagroup.sprigularbackend.domain.Component;
import com.senecagroup.sprigularbackend.domain.Time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by bobsang89@gmail.com on 2018-09-23
 * Project: sprigularbackend
 * Github : http://github.com/SangJun-GitHub
 */
public class FixtureFactoryImpl implements FixtureFactory {
    @Override
    public List<Category> categories() {
        List<Category> categories = new ArrayList<>();

        LocalDateTime t = LocalDateTime.now();
        Component com = new Component();
        Time time = new Time(t,t, com);

        Category c1 = new Category();
        c1.setName("Languages");
        c1.setParent(null);
        List<Category> children1_1 = new ArrayList<>();
        c1.setChildren(children1_1);
        c1.setDocuments(null);
        c1.setLevel(0);
        c1.setTime(time);
        c1.setLastDocumentUpdated(t);

        Category c1_1 = new Category();
        c1_1.setName("Object Oriented");
        c1_1.setParent(c1);
        c1_1.setDocuments(null);
        List<Category> children1_2 = new ArrayList<>();
        c1_1.setChildren(children1_2);
        c1_1.setLevel(1);
        c1_1.setTime(time);
        c1_1.setLastDocumentUpdated(t);

        Category c1_2 = new Category();
        c1_2.setName("Java");
        c1_2.setParent(c1_2);
        c1_2.setDocuments(null);
        c1_2.setLevel(2);
        c1_2.setTime(time);
        c1_2.setLastDocumentUpdated(t);

        categories.add(c1);

        Category c2 = new Category();
        c2.setName("Tip's");
        c2.setParent(null);
        List<Category> children2_1 =new ArrayList<>();
        c2.setChildren(children2_1);
        c2.setDocuments(null);
        c2.setLevel(0);
        c2.setTime(time);
        c2.setLastDocumentUpdated(t);

        Category c2_1 = new Category();
        c2_1.setName("Git");
        c2_1.setParent(c2);
        c2_1.setChildren(null);
        c2_1.setDocuments(null);
        c2_1.setLevel(1);
        c2_1.setTime(time);
        c2_1.setLastDocumentUpdated(t);

        categories.add(c2);

         return categories;
        }
    }

