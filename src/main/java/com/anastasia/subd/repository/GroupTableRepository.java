package com.anastasia.subd.repository;

import com.anastasia.subd.entity.GroupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTableRepository extends JpaRepository<GroupTable, Integer> {
}