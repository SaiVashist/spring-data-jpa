package com.vashist.spring.data.jpa.repository;

import com.vashist.spring.data.jpa.entity.Guardian;
import com.vashist.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder().
                emailId("emailId@email.com")
                .firstName("vashist")
                .lastName("sai")
             //   .guardianEmail("gar@gmail.com")
               // .guardianMobile("1234567890")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("tatha@email.com")
                .name("krishan")
                .mobile("7777777777")
                .build();
        Student student = Student.builder()
                .firstName("SHivam")
                .lastName("dube")
                .emailId("shivam@email.com")
                .guardian(guardian)
                .build()
                ;
        studentRepository.save(student);
    }

    @Test
    public void getAllStudents(){
        List<Student> students =
                studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void getByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("vashist");
        System.out.println(students);
    }
    @Test
    public void getByFirstNameContain(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("sh");
        System.out.println(students);
    }

}