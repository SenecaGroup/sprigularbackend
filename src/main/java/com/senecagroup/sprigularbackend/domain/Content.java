package com.senecagroup.sprigularbackend.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

import javax.persistence.*;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Entity @Getter @Setter @ToString
@EqualsAndHashCode(of = "id")
public class Content {

    public enum ContentType {
        CODE, NORMAL
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTENT_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContentType type;

    private Integer index;

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private Document document;

    @Column(length = 3000)
    private String data;

    /*
        Set an index which is calculated from the document
        An index is a last index + 1 in the document.contents
        If the document is null
        @throw IllegalArgumentException will occured.
        @return the index
    */
    public int setIndexFromDocument() {
        Assert.notNull(document, "Document must not null");
        int lastIndex = document.nextContentIndex();
        System.out.println(lastIndex);
        this.setIndex(lastIndex);
        return lastIndex;
    }

    public void setDocument(Document document) {
        this.document = document;
        setIndexFromDocument();
    }

}