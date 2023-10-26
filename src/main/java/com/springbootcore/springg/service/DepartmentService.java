package com.springbootcore.springg.service;

import com.springbootcore.springg.entity.Department;
import com.springbootcore.springg.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartment(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

  public  List<Department> getAllDepartments();

  public Department getDepartmentByName(String name);

//    public List<Department> getAllDepartmentByName(String name);
}
