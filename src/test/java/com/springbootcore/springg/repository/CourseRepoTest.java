package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Course;
import com.springbootcore.springg.entity.Teacher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
         PageRequest pagesWithThreeRecords= PageRequest.of(0,3);
         PageRequest pagesWithTwoRecords= PageRequest.of(1,2);
         List<Course> courseList=courseRepo.findAll(pagesWithThreeRecords).getContent();

         long totalElements = courseRepo.findAll(pagesWithTwoRecords).getTotalElements();
         System.out.println("totalElements+\"   \"+courseList = " + totalElements+"   "+courseList);


     }
     @Test
    public void findAllSortingPages(){
         Pageable pagesSortbyTitle=PageRequest.of(0,2,
                 Sort.by("courseTitle")
         );

         Pageable pagesortByCreditDesc=PageRequest.of(0,2,
                 Sort.by("credit").descending()
                 );
         Pageable pagesSortByTitleAndCreditDesc=PageRequest.of(0,2,
                 Sort.by("courseTitle").descending()
                         .and(Sort.by("credit").ascending())
                 );

         List<Course> courseListt=courseRepo.findAll(pagesSortbyTitle).getContent();

         System.out.println("courseListt = " + courseListt);

     }

     @Test
     @Disabled
    public void findByCourseTitleContainingg(){
         Pageable firstPage10Records=PageRequest.of(0,10);
         List<Course> courseList=
                 courseRepo.findByCourseTitleContaining("H",firstPage10Records).getContent();
         System.out.println("courseList = " + courseList);

     }


}