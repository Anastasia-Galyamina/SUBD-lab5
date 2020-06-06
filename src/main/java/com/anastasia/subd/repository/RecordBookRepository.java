package com.anastasia.subd.repository;

import com.anastasia.subd.entity.RecordBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordBookRepository extends JpaRepository<RecordBook, Integer> {
}