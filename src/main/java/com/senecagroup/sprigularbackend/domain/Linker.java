package com.senecagroup.sprigularbackend.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by sm123tt@gmail.com on 2018-09-16
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Entity @Table(name = "LINKER")
@Getter @Setter @ToString
public class Linker {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "TARGET_ID")
    private Paragraph targetParagraph;

    private String selector;

}
