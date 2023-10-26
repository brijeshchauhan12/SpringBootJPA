package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT ea.* from tbl_student ea where ea.first_name=:name"
    )
    public Student findStudentByName(@Param("name") String name);

   @Query(
           nativeQuery = true,
           value = "select a.* from tbl_student a"
   )
    public List<Student> findAllStudentUsingQuery();

   @Modifying
   @Transactional
   @Query(
           value = "update tbl_student set first_name=?1 where email_address=?2",
           nativeQuery = true
   )
   public void updateNameForProvidedEmail(String name, String email);
}

