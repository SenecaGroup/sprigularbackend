package com.senecagroup.sprigularbackend.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by sm123tt@gmail.com on 2018-09-16
 * Project: sprigularbackend
 * Github : http://github.com/Siwoo-Kim
 */

@Getter @Setter @ToString
@Entity @Table(name = "TIME")
public class Time {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "COMPONENT")
    private Component component;

    private Time() {
    }

    public Time(LocalDateTime createdDate, LocalDateTime updatedDate, Component component) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.component = component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(id, time.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
