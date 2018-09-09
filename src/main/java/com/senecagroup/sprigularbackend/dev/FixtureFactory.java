package com.senecagroup.sprigularbackend.dev;

import com.senecagroup.sprigularbackend.model.Category;
import com.senecagroup.sprigularbackend.model.Model;
import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Service
public class FixtureFactory {

    @Value("${app.hostname}")
    private URL url;
    public static final char URL_SEPARATOR = '/';


    public List<Model> fixtureModels() {
        try{
            List<Model> models = new ArrayList<>();
            Model model = new Model();
            model.setName("HOME");
            models.add(model);
            model.setUrl(new URL(url.toString() + model.getName().toLowerCase()));
            model = new Model();
            model.setName("ABOUT");
            model.setUrl(new URL(url.toString() +  model.getName().toLowerCase()));
            models.add(model);
            model = new Model();
            model.setName("TIPS");
            model.setUrl(new URL(url.toString() +  model.getName().toLowerCase()));
            models.add(model);
            model = new Model();
            model.setName("LANGUAGES");
            model.setUrl(new URL(url.toString() +  model.getName().toLowerCase()));
            models.add(model);
            return models;
        }catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> fixtureCategories()  {
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setName("LANGUAGES");
        Category child = new Category();
        child.setName("JAVA");
        category.addChild(child);
        child = new Category();
        child.setName("JAVASCRIPT");
        category.addChild(child);
        child = new Category();
        child.setName("HTML");
        category.addChild(child);
        categories.add(category);

        category = new Category();
        category.setName("Database");
        child = new Category();
        child.setName("MongoDB");
        category.addChild(child);
        child = new Category();
        child.setName("Oracle");
        category.addChild(child);
        child = new Category();
        child.setName("Postgresql");
        category.addChild(child);
        categories.add(category);

        return categories;
    }
}
