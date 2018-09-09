package com.senecagroup.sprigularbackend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        if(createdAt.isAfter(updatedAt)) {
//            throw new TimeException()
//        }
//    }
    /*
        @return Last Index of contents + 1
        If there is no content, it returns 1
    */
    public int nextContentIndex() {
        int lastIndex = contents
                .stream()
                .mapToInt(Content::getIndex)
                .max()
                .orElse(0);
        return lastIndex == 0? 0: lastIndex + 1;
    }

    /*
        Adding @argument content to the contents
        if the index of the content already exists
        @throw ContentIndexConflictException will occur
        Set content.Category to this
        @return the result of the adding content.
    */
    private boolean addContent(Content content) {
//        int index = content.getIndex();
//        Optional<Content> foundContent = contents.stream()
//                .filter(_content -> _content.getIndex() == index)
//                .findFirst();
//        if(foundContent.isPresent()) {
//            throw new ContentIndexConflictException("Conflict content index: " + index);
//        }
        if(content.getIndex() != null) {
            throw new ContentIndexConflictException("Not added content must not have index");
        }
        content.setDocument(this);
        if(!contents.contains(this)) {
            content.setIndexFromDocument();
            return contents.add(content);
        }
        return false;
    }
}
