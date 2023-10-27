package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Course;
import com.springbootcore.springg.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepoTest {
     @Autowired
     private  CourseRepo courseRepo;
     @Test
     public void getAllTheCourses(){
         List<Course> courseList=courseRepo.findAll();
         System.out.println("courseList = " + courseList);

     }

     @Test
    public void saveCourse(){
         Teacher teacher=Teacher.builder()
                 .lastName("Verma")
                 .firstName("Neeraj")
                 .build();
         Course course=Course.builder()
                 .credit(19)
                 .courseTitle("Hindi+Science+English")
                 .teacher(teacher)
                 .build();


         courseRepo.save(course);
     }

     @Test
     public  void findAllPagination(){
         Pageable pagesWithThreeRecords= (Pageable) PageRequest.of(0,3);
         Pageable pagesWithTwoRecords= (Pageable) PageRequest.of(1,2);
         List<Course> courseList=courseRepo.findAll(pagesWithThreeRecords).getContent();

         Long totalElements =courseRepo.findAll(pagesWithThreeRecords);
         System.out.println("totalElements+\"   \"+courseList = " + totalElements+"   "+courseList);


     }

}