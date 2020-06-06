package com.anastasia.subd.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Person person;

    @OneToMany
    private List<Subject> subject;

    @Override
    public String toString() {
        return "Lecturer {\n" +
                " id=" + id + ",\n" +
                " person=" + person + ",\n" +
                "}" + "\n";
    }
}