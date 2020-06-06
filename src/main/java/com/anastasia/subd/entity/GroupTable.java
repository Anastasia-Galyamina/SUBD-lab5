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
public class GroupTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Specialization specialization;

    @OneToMany
    private List<Student> students;

    @Override
    public String toString() {
        return "GroupTable {\n" +
                " id=" + id + ",\n" +
                " name=" + name + ",\n" +
                " specialization=" + specialization + ",\n" +
                "}" + "\n";
    }
}