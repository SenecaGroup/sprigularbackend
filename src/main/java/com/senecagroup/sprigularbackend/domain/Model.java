package com.senecagroup.sprigularbackend.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

/**
 * Created by sm123tt@gmail.com on 2018-09-08
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Entity @Getter @Setter @ToString
@EqualsAndHashCode(of = "name")
public class Model {

    @Id
    private String name;

    private URL url;

}
