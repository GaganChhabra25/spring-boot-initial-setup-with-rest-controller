package com.in28minutes.springboot.repository;

import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    @Autowired
    private StudentService studentService;

    public Optional<Student> getStudentById(String studentId) {
        List<Student> students =  studentService.retrieveAllStudents();
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                Optional<Student> student1 = Optional.of(student);
                return student1;
            }
        }
        return Optional.empty();
    }
}
