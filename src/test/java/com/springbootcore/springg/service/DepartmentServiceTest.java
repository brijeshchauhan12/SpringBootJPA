package com.springbootcore.springg.service;

import com.springbootcore.springg.entity.Department;
import com.springbootcore.springg.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                .departmentName("IT")
                .departmentAddress("Hauz Khas")
                .departmentCode("IT007")
                .departmentID(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(department);

    }
    @Test
    @DisplayName("Get data based on valid department")
    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
       String departmentName="IT";

       Department found=departmentService.getDepartmentByName(departmentName);

       assertEquals(departmentName, found.getDepartmentName());

    }
}