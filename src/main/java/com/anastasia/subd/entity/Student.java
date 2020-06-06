package com.anastasia.subd.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Person person;

    @ManyToOne
    private GroupTable groupTable;

    @OneToOne(mappedBy = "student")
    private RecordBook recordBook;

    @Override
    public String toString() {
        return "Student {\n" +
                " id=" + id + ",\n" +
                " person=" + person + ",\n" +
                "}" + "\n";
    }
}