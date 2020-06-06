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
public class RecordBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String subject;

    private Integer semester;

    private String reporting;

    private Integer mark;

    @OneToOne
    private Student student;

    @OneToMany
    private List<Subject> subjects;

    @Override
    public String toString() {
        return "RecordBook {\n" +
                " id=" + id + ",\n" +
                " subject=" + subject + ",\n" +
                " semester=" + semester + ",\n" +
                " reporting=" + reporting + ",\n" +
                " mark=" + mark + ",\n" +
                "}" + "\n";
    }
}