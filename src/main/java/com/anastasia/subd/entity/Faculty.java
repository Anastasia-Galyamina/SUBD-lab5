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
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany
    @JoinTable(name = "department")
    private List<Department> departments;

    @Override
    public String toString() {
        return "Faculty {\n" +
                " id=" + id + ",\n" +
                " name=" + name + ",\n" +
                "}" + "\n";
    }
}