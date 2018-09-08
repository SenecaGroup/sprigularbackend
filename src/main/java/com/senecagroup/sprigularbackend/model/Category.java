package com.senecagroup.sprigularbackend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

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

    /*
        If the Category contains @argument the document @return true
        else @return false
    */
    public boolean contains(Document document) {
        return documents.contains(document);
    }

    /*
        If the Category contains @argument the child Category @return true
        else @return false
    */
    public boolean contains(Category child) {
        return children.contains(child);
    }

    public boolean addDocument(Document document) {
        //Set document.Category to this
        document.setCategory(this);
        if(!contains(document)) {
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
        //Set child.Parent to this
        child.setParent(this);
        if(!contains(child)) {
            return children.add(child);
        }
        return false;
    }

}
