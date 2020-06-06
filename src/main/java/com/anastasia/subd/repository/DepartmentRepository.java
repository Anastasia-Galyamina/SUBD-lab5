package com.anastasia.subd.repository;

import com.anastasia.subd.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> getAllByFaculty_Id(Integer id);
}