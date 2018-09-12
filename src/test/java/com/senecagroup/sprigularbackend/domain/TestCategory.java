package com.senecagroup.sprigularbackend.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static junit.framework.TestCase.*;

/**
 * Created by bobsang89@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/SangJun-GitHub
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCategory {

    List<Category> categories = new ArrayList<>();

    @Before
    public void setup() {
        Category category = new Category();
        category.setName("DB");
        categories.add(category);

        category = new Category();
        category.setName("JAVASCRIPT");
        categories.add(category);

        category = new Category();
        category.setName("JAVA");
        categories.add(category);

        category = new Category();
        category.setName("TYPESCRIPT");
        categories.add(category);

        category = new Category();
        category.setName("ANGULAR");
        categories.add(category);

        assertNotNull(categories);
        assertTrue(categories.size() == 5);
    }

//    public boolean addDocument(Document document) {
//        //Set document.Category to this
//        document.setCategory(this);
//        if(!documents.contains(document)) {
//            return documents.add(document);
//        }
//        return false;
//    }


    @Test
    public void addDocumentTest(){
        Document document = new Document();
        Category category = categories.get(0);
        assertTrue(category.addDocument(document));
        assertFalse(category.addDocument(document));
        assertEquals(document.getCategory(), category);
    }

//    public boolean removeDocument(Document document) {
//        //Set document.Category to null
//        if(document.getCategory() == this) {
//            document.setCategory(null);
//        }
//        return documents.remove(document);
//    }
    @Test
    public void removeDocumentTest(){
        Document document = new Document();
        Category category = categories.get(0);
        assertTrue(category.addDocument(document));
        assertTrue(category.removeDocument(document));
        assertFalse(category.getDocuments().contains(document));
    }

//    public boolean addChild(Category child) {
//        child.setParent(this);
//        if(!children.contains(child)) {
//            return children.add(child);
//        }
//        return false;
//    }

    @Test
    public void addChildTest(){
        Category parent = categories.get(0);
        Category child = categories.get(1);
        assertTrue(parent.addChild(child));
        assertFalse(parent.addChild(child));
    }

}
