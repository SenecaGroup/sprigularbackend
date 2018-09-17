package com.senecagroup.sprigularbackend.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Entity @Getter @Setter @ToString
public class Document {

    public static final int INDEX_NOT_FOUND = -1;
    public static final int FIRST_INDEX = 0;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCUMENT_ID")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    Category category;

    @OneToMany(mappedBy = "document",
    orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Paragraph> paragraphs = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "TIME_ID")
    private Time time;

    private Integer index;

    private Integer views;

    private Integer reactions;

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
        int lastIndex = paragraphs
                .stream()
                .mapToInt(Paragraph::getIndex)
                .max()
                .orElse(INDEX_NOT_FOUND);
        return lastIndex == INDEX_NOT_FOUND ? FIRST_INDEX : lastIndex + 1;
    }

    /*
        Adding @argument content to the contents
        if the index of the content already exists
        @throw ContentIndexConflictException will occur
        Set content.Category to this
        @return the result of the adding content.
    */
    public boolean addParagraph(Paragraph paragraph) {
//        int index = content.getIndex();
//        Optional<Content> foundContent = contents.stream()
//                .filter(_content -> _content.getIndex() == index)
//                .findFirst();
//        if(foundContent.isPresent()) {
//            throw new ContentIndexConflictException("Conflict content index: " + index);
//        }
        if(paragraphs.contains(paragraph)) {
           return false;
        }
        if(paragraph.getIndex() != null) {
            Optional<Paragraph> foundOne = paragraphs.stream()
                    .filter(_p -> _p.getIndex() == paragraph.getIndex())
                    .findFirst();
            if(foundOne.isPresent()) {
                throw new ContentIndexConflictException("Conflict content index: " + paragraph.getIndex());
            }
        }
        if(paragraph.getDocument() != this) {
            paragraph.setDocument(this);
        }
        return paragraphs.add(paragraph);
    }
}
