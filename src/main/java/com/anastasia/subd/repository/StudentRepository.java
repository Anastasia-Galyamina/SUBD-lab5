package com.anastasia.subd.repository;

import com.anastasia.subd.entity.Student;
import com.anastasia.subd.model.GroupStudentCountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT new com.anastasia.subd.model.GroupStudentCountModel(s.groupTable.name, COUNT(s)) FROM Student s" +
            " WHERE s.recordBook.mark > :markMoreThan" +
            " GROUP BY s.groupTable.name")
    List<GroupStudentCountModel> getStudentCountGroupedByGroup(@Param("markMoreThan") Integer markMoreThan);
}