package com.anastasia.subd.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String surname;

    private String patrinymic;

    @Override
    public String toString() {
        return "Person {\n" +
                " id=" + id + ",\n" +
                " name=" + name + ",\n" +
                " surname=" + surname + ",\n" +
                " patrinymic=" + patrinymic + ",\n" +
                "}" + "\n";
    }
}