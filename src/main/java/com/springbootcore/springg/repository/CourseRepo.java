package com.springbootcore.springg.repository;

import com.springbootcore.springg.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> , PagingAndSortingRepository<Course,Long> {

    Page<Course> findByCourseTitleContaining(String title, Pageable pageable);

}
