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
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Department department;

    @OneToMany
    private List<GroupTable> groupTables;

    @Override
    public String toString() {
        return "Specialization {\n" +
                " id=" + id + ",\n" +
                " name=" + name + ",\n" +
                " department=" + department + ",\n" +
                "}" + "\n";
    }
}