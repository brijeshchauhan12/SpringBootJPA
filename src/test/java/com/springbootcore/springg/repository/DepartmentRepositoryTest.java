package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department department=Department.builder()
                .departmentID(34L)
                .departmentCode("afg")
                .departmentAddress("afgkandahar")
                .departmentName("hayeda")
                .build();
        entityManager.persist(department);

    }
    @Test
    @Disabled
    public void Test_particular_record_from_repository_layer(){
        Department department=departmentRepository.findById(34L).get();
        assertEquals(department.getDepartmentName(),"hayeda");
    }
}