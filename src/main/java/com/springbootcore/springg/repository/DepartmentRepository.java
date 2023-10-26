package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

 public Department findByDepartmentName(String name);

// public List<Department> findByDepartmentName(String name);
}
