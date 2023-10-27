package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Course;
import com.springbootcore.springg.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {
    @Autowired
    private CourseMaterialRepo courseMaterialRepo;

    @Test
    public void saveCourseMaterial(){

        Course course= Course.builder()
                .courseTitle("HackingNext")
                .credit(23)
                .build();

        CourseMaterial courseMaterial=CourseMaterial.builder()
                .course(course)
                .url("https://briejsh.chauhan.sf.com")
                .build();

        courseMaterialRepo.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterialList=courseMaterialRepo.findAll();
        System.out.println("CourseMaterialAll:::"+courseMaterialList);
    }


}