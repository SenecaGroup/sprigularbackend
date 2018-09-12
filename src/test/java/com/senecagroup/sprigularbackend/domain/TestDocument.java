package com.senecagroup.sprigularbackend.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by bobsang89@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/SangJun-GitHub
 */
public class TestDocument {
    List<Document> documents = new ArrayList<>();

    @Before
    public void setup(){
        Document document = new Document();
        document.setId(1L);
        documents.add(document);

        document = new Document();
        document.setId(2L);
        documents.add(document);

        document = new Document();
        document.setId(3L);
        documents.add(document);

        document = new Document();
        document.setId(4L);
        documents.add(document);

        document = new Document();
        document.setId(5L);
        documents.add(document);

    }

//    public int nextContentIndex() {
//        int lastIndex = contents
//                .stream()
//                .mapToInt(Content::getIndex)
//                .max()
//                .orElse(0);
//        return lastIndex + 1;
//    }

    @Test
    public void nextContentIndexTest(){
        Document document = documents.get(0);
        assertTrue(document.nextContentIndex() == 1);
        Content content1 = new Content();
        content1.setDocument(document);
        content1.setIndexFromDocument();
        // => 1
        document.getContents().add(content1);
        System.out.println(document.nextContentIndex());
        assertTrue(document.nextContentIndex() == 2);
        Content content2 = new Content();
        // => index = 0
        content2.setDocument(document);
        content2.setIndexFromDocument();
        document.getContents().add(content2);
        assertTrue(document.nextContentIndex() == 3);
    }

//    private boolean addContent(Content content) {
////        int index = content.getIndex();
////        Optional<Content> foundContent = contents.stream()
////                .filter(_content -> _content.getIndex() == index)
////                .findFirst();
////        if(foundContent.isPresent()) {
////            throw new ContentIndexConflictException("Conflict content index: " + index);
////        }
//        if(content.getIndex() != null) {
//            throw new ContentIndexConflictException("Not added content must not have index");
//        }
//        if(!contents.contains(this)) {
//            content.setDocument(this);
//            return contents.add(content);
//        }
//        return false;
//    }

    @Test
    public void addContentTest(){
        Document document = documents.get(0);
        Content content1 = new Content();
        Content content2 = new Content();
        document.addContent(content1);
        assertTrue(document.getContents().size() == 1);
        assertTrue(content1.getIndex() == 0);

        document.addContent(content1);
        assertFalse(document.getContents().size() == 2);
        assertTrue(content1.getIndex() == 0);

        document.addContent(content2);
        assertTrue(document.getContents().size() == 2);
        System.out.println(content2.getIndex());
        assertTrue(content2.getIndex() == 1);

        Content content3 = new Content();
        document.addContent(content3);
        assertTrue(document.getContents().size() == 3);
        assertTrue(content3.getIndex() == 2);
    }
}
