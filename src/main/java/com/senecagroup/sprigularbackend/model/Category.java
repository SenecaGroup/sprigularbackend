package com.senecagroup.sprigularbackend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Getter @Setter @ToString
@EqualsAndHashCode(of = "name")
public class Category {

    @Id
    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> children = new ArrayList<>();

    @OneToMany(mappedBy = "category",
            fetch = FetchType.EAGER,
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    public boolean addDocument(Document document) {
        //Set document.Category to this
        document.setCategory(this);
        if(!documents.contains(document)) {
            return documents.add(document);
        }
        return false;
    }

    public boolean removeDocument(Document document) {
        //Set document.Category to null
        if(document.getCategory() == this) {
            document.setCategory(null);
        }
        return documents.remove(document);
    }

    public boolean addChild(Category child) {
        child.setParent(this);
        if(!children.contains(child)) {
            return children.add(child);
        }
        return false;
    }

}
