package com.senecagroup.sprigularbackend.dev;

import com.senecagroup.sprigularbackend.domain.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFixtureFactory {

    @Autowired
    FixtureFactory fixtureFactory;

    @Test
    public void testFixtureModels() {
        assertNotNull(fixtureFactory.fixtureModels());
        assertFalse(fixtureFactory.fixtureModels().isEmpty());
        //fixtureFactory.fixtureModels().forEach(System.out::println);
    }

    @Test
    public void testFixtureCategories() {
        assertNotNull(fixtureFactory.fixtureCategories());
        assertFalse(fixtureFactory.fixtureCategories().isEmpty());
        fixtureFactory.fixtureCategories()
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void testFixtureContent(){
        assertNotNull(fixtureFactory.fixtureContent());
        assertFalse(fixtureFactory.fixtureContent().isEmpty());
        fixtureFactory.fixtureContent()
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void testFixtureDocument(){
        List<Content> contents = fixtureFactory.fixtureContent();
        assertNotNull(fixtureFactory.fixtureDocument(contents));
        assertFalse(fixtureFactory.fixtureDocument(contents).isEmpty());
        fixtureFactory.fixtureDocument(contents)
                .stream()
                .forEach(System.out::println);
    }
}
