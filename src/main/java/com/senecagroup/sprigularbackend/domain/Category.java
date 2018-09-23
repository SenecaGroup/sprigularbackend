package com.senecagroup.sprigularbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Entity @Getter @Setter @ToString(exclude = "children")
public class Category {

    public static final int MAX_LEVEL = 2;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @Max(2) @Min(0)
    private Integer level;

    @Column(name = "LAST_DOC_UPDATED")
    private LocalDateTime lastDocumentUpdated;

    @JsonIgnore
    @OneToMany(mappedBy = "parent",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> children = new ArrayList<>();

    @OneToMany(mappedBy = "category",
            fetch = FetchType.EAGER,
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "TIME_ID")
    private Time time;

    @JsonIgnore
    @Column(name = "root")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isRoot() {
        return parent == null && level == 0;
    }
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

    public boolean isLeaf() {
        return level == 2 || children == null || children.isEmpty();
    }
}
