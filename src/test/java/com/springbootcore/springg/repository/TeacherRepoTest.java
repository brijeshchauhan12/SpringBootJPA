package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Course;
import com.springbootcore.springg.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher(){

        Course course=Course.builder()
                .courseTitle("math")
                .credit(10)
                .build();

        Course course1=Course.builder()
                .courseTitle("Science")
                .credit(9)
                .build();
        List<Course> c=new ArrayList<>();
        c.add(course);
        c.add(course1);

        Teacher teacher= Teacher.builder()
                //.courses(c)
                .firstName("Brijpal Chauhan")
                .lastName("Chauhan")
                .build();

        teacherRepo.save(teacher);
    }

}