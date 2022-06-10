package com.pak;

import com.pak.web.model.Student;
import com.pak.web.StudentController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController implements StudentController {

    @Override
    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1l,"code1","om"));
        students.add(new Student(2l,"code2","prakash"));
        students.add(new Student(3l,"code3","riya"));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MainController");
        return ResponseEntity.accepted().headers(headers).body(students);
    }


    @Override
    public ResponseEntity<?> createStudent(Student student) {
        return null;
    }

    @Override
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(String id) {
        System.out.println("id: "+id);
        Student student = new Student(4l,"code4","ravi");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MainController");
        //return ResponseEntity.ok().headers(headers).body(student);
        return ResponseEntity.accepted().headers(headers).body(student);
    }

    @Override
    public ResponseEntity<?> updateStudent(String id, Student student) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteStudentById(String id) {
        return null;
    }
}
