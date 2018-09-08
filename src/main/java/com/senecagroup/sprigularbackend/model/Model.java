package com.senecagroup.sprigularbackend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Entity @Getter @Setter @ToString
@EqualsAndHashCode(of = "name")
public class Model {

    @Id
    private String name;

    private URL url;

}
