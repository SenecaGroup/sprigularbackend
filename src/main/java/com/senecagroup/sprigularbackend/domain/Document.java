package com.senecagroup.sprigularbackend.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Entity @Getter @Setter @ToString
@EqualsAndHashCode(of = {"id", "title"})
public class Document {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private URL reference;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    Category category;

    @OneToMany(mappedBy = "document",
    orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "DOCUMENT_ID")
    private List<Image> images = new ArrayList<>();

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        if(createdAt.isAfter(updatedAt)) {
//            throw new TimeException()
//        }
//    }
    public static final int INDEX_NOT_FOUND = -1;

    /*
        @return Last Index of contents + 1
        If there is no content, it returns 1
    */
    public int nextContentIndex() {
        int lastIndex = contents
                .stream()
                .mapToInt(Content::getIndex)
                .max()
                .orElse(INDEX_NOT_FOUND);
        return lastIndex == INDEX_NOT_FOUND? 0: lastIndex + 1;
    }

    /*
        Adding @argument content to the contents
        if the index of the content already exists
        @throw ContentIndexConflictException will occur
        Set content.Category to this
        @return the result of the adding content.
    */
    public boolean addContent(Content content) {
//        int index = content.getIndex();
//        Optional<Content> foundContent = contents.stream()
//                .filter(_content -> _content.getIndex() == index)
//                .findFirst();
//        if(foundContent.isPresent()) {
//            throw new ContentIndexConflictException("Conflict content index: " + index);
//        }
        if(!contents.contains(this) && content.getIndex() == null) {
            content.setDocument(this);
            return contents.add(content);
        }
        return false;
    }
}