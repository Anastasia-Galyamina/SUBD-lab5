package com.anastasia.subd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GroupStudentCountModel {

    private final String groupName;

    private final Long studentCount;

    @Override
    public String toString() {
        return "Student {\n" +
                " groupName=" + groupName + ",\n" +
                " studentCount=" + studentCount + ",\n" +
                "}" + "\n";
    }
}