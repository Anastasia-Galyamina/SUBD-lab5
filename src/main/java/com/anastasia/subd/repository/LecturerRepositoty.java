package com.anastasia.subd.repository;

import com.anastasia.subd.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepositoty extends JpaRepository<Lecturer, Integer> {
}