package com.coding.LearnSpring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByemail(String email);

    @Query("SELECT $ from Student $ WHERE $.email LIKE %:domain")
    List<Student> findByDomain(@Param("domain")String domain);
}
