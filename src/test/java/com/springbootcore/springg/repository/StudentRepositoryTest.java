package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Guardian;
import com.springbootcore.springg.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student= Student.builder()
                .emailId("brijeshkme@gmail.com")
                .firstName("brijesh")
                .lastName("chauhan")
                //.guardianName("hayeda")
                //.guardianEmail("hayedayusf@af.com")
                //.getGuardianMobile("+9389233487934")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithEmbeddedGuardian(){
        Guardian guardian=Guardian.builder()
                .email("hayeda@nr.com")
                .mobile("93247938489")
                .name("hayeda")
                .build();
        Student student=Student.builder()
                .emailId("sona@gmail.om")
                .guardian(guardian)
                .firstName("sona")
                .lastName("yadav")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void findAllStudent(){
        List<Student> stdentList=studentRepository.findAll();

        System.out.println("all the students"+stdentList);
    }

    @Test
    public void findStudentByName(){
        Student student=studentRepository.findStudentByName("sona");

        System.out.println(student);

    }

    @Test
    public void findAllStudentUsingNativeQuery(){
        List<Student> studentList=studentRepository.findAllStudentUsingQuery();
        System.out.println("ttotal student are : "+ studentList);
        for( Student s : studentList){
            System.out.println(s.getStudentId()+"  "+s.getGuardian().getName());
        }
    }

    @Test
    public void updateNameForProvidedEmail(){
        studentRepository.updateNameForProvidedEmail("Brijesh Kumar Chauhan",
                "brijeshkme@gmail.com");

    }
}
