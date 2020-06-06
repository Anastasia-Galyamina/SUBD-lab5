package com.anastasia.subd.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Faculty faculty;

    @Override
    public String toString() {
        return "Department {" + "\n" +
                " id=" + id + ",\n" +
                " name=" + name + ",\n" +
                " faculty=" + faculty + ",\n" +
                "}\n";
    }
}