package com.in28minutes.springboot.restcontroller;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.model.ws.StudentWS;
import com.in28minutes.springboot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;



    @GetMapping("/students/{studentId}/courses")
    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
        return studentService.retrieveCourses(studentId);
    }

    @GetMapping("/students/{studentId}/courses/{courseId}")
    public Course retrieveDetailsForCourse(@PathVariable String studentId,
                                           @PathVariable String courseId) {
        return studentService.retrieveCourse(studentId, courseId);
    }

    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<Void> registerStudentForCourse(
            @PathVariable String studentId, @RequestBody Course newCourse) {

        Course course = studentService.addCourse(studentId, newCourse);

        if (course == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(name = "/student/create"  , consumes = "application/json",  method = RequestMethod.POST)
    public ResponseEntity<Void> createStudent(@RequestBody  @Valid Student student, BindingResult bindingResult) {
        System.out.println("=======");
        studentService.createStudent(student);
        if(bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(fieldError -> {
                System.out.println (fieldError.getField() + " - " + fieldError.getDefaultMessage());
            });
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(value = "/api/students"  , produces = "application/json",  method = RequestMethod.GET)
    public  List<Student> getStudents(){
        return studentService.retrieveAllStudents();
    }

    @RequestMapping(value = "/student/{studentId}"  , method = RequestMethod.GET, produces = "application/json")
    public  ResponseEntity<Student> readStudentById( @PathVariable String studentId) {
       Optional<Student> student = studentService.getStudentById(studentId);
       Student student2 = student.
               orElse(new Student("No Student exist with this ID"));

        System.out.println("---" + student2);
        return new ResponseEntity(student2, HttpStatus.OK);
    }

}
