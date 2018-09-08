package com.senecagroup.sprigularbackend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity @Getter @Setter @ToString
public class Content {

    public enum ContentType {
        CODE, NORMAL
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTENT_ID")
    private Long id;
    private ContentType type;
    private int index;
    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private Document document;
    @Column(length = 3000)
    private String data;


}
