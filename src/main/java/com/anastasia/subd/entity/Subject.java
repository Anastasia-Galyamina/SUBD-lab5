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
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Lecturer lecturer;

    @OneToMany
    private List<RecordBook> recordBooks;

    @Override
    public String toString() {
        return "Subject {\n" +
                " id=" + id + ",\n" +
                " name=" + name + ",\n" +
                " lecturer=" + lecturer + ",\n" +
                "}" + "\n";
    }
}