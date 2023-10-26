package com.springbootcore.springg.controller;

import com.springbootcore.springg.entity.Department;
import com.springbootcore.springg.error.DepartmentNotFoundException;
import com.springbootcore.springg.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;


@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department  )   {
          logger.info("New record inserted in the database");

          return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        return departmentService.getDepartmentById(departmentId);
    }
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){

        return departmentService.getAllDepartments();
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return "department deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name){
        return departmentService.getDepartmentByName(name);
    }
//    @GetMapping("/departments/name/{name}")
//    public List<Department> getAllDepartmentByName(@PathVariable("name") String name){
//        return departmentService.getAllDepartmentByName(name);
//    }
}
