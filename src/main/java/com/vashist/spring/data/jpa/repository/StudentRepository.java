package com.vashist.spring.data.jpa.repository;

import com.vashist.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull(String lastName);

    public List<Student> findByGuardianName(String gName);

    public List<Student>  findByFirstNameAndLastName(String firstName , String lastName);



}
