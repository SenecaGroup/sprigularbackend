package com.senecagroup.sprigularbackend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Entity @Getter @Setter @ToString
public class Model {

    private String name;
    private URL url;

}
