package com.senecagroup.sprigularbackend.service;

import com.senecagroup.sprigularbackend.SprigularbackendApplication;
import com.senecagroup.sprigularbackend.configuration.DBConfiguration;
import com.senecagroup.sprigularbackend.domain.Category;
import com.senecagroup.sprigularbackend.domain.Component;
import com.senecagroup.sprigularbackend.domain.Time;
import com.senecagroup.sprigularbackend.repository.CategoryRepository;
import com.senecagroup.sprigularbackend.tester.FixtureFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StopWatch;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Consumer;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by bobsang89@gmail.com on 2018-09-23
 * Project: sprigularbackend
 * Github : http://github.com/SangJun-GitHub
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestCategoryServiceImpl {

    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    CategoryService service;
    List<Category> mock;
    @Before
    public void setup() {
        mock = new ArrayList<>();
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
        c1.addChild(c1_1);
        c1_1.addChild(c1_2);
        mock.add(c1);

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

        c2.addChild(c2_1);
        mock.add(c2);

    }


    @Transactional
    @Test
    public void getCategory() {
        categoryRepository.saveAll(mock);
        Category category = service.getCategory(mock.get(0).getId()).orElse(null);
        assertTrue(category.getId() == mock.get(0).getId());
        System.out.println("getCategory index(0): "+ category);
        profiling(s -> s.getCategory(mock.get(0).getId()), "getCategory");
    }

    @Transactional
    @Test
    public void getChildren(){
        categoryRepository.saveAll(mock);
        Category category = service.getCategory(mock.get(0).getId()).orElse(null);
        List<Category> children = mock.get(0).getChildren();
        for(Category _category : children) {
            category.getChildren().contains(_category);
        }
        assertTrue(children.equals(mock.get(0).getChildren()));
        System.out.println("getChildren index(0-1):" + children);
        profiling(s -> s.getChildren(mock.get(0).getChildren().get(0)), "getChildren");

    }

    @Transactional
    @Test
    public void getAncestors(){
        categoryRepository.saveAll(mock);
        List<Category> category = service.getAncestors(mock.get(0).getChildren().get(0).getChildren().get(0));
        assertTrue(category.contains(mock.get(0)));
        assertTrue(category.contains(mock.get(0).getChildren().get(0)));

        profiling(s -> s.getAncestors(mock.get(0).getChildren().get(0).getChildren().get(0)), "getAncestors");
    }

    @Transactional
    @Test
    public void getRoot(){
        categoryRepository.saveAll(mock);
        Category category = service.getRoot(mock.get(0).getChildren().get(0));
        assertEquals(category, mock.get(0));
        category = service.getRoot(mock.get(0).getChildren().get(0).getChildren().get(0));
        assertEquals(category, mock.get(0));

        profiling(s -> s.getRoot(mock.get(0).getChildren().get(0)), "getRoot");
    }

    @Transactional
    @Test
    public void isLeaf(){
        categoryRepository.saveAll(mock);
        assertFalse(service.isLeaf(mock.get(0)));
        assertFalse(service.isLeaf(mock.get(0).getChildren().get(0)));
        assertTrue(service.isLeaf((mock.get(0).getChildren().get(0).getChildren().get(0))));
        profiling(s -> s.isLeaf(mock.get(0)), "isLeaf");
    }


    public void profiling(Consumer<CategoryService> consumer, String name) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(name);
        for(int i=0; i<50000; i++) {
            consumer.accept(service);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}

