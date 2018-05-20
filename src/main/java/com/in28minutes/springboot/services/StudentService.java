package com.in28minutes.springboot.services;


import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> retrieveAllStudents();

    public Student retrieveStudent(String studentId);

    public List<Course> retrieveCourses(String studentId);

    public Course retrieveCourse(String studentId, String courseId);

    public Course addCourse(String studentId, Course course);
}
