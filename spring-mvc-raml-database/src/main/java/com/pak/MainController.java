package com.pak;

import com.pak.web.model.Student;
import com.pak.web.StudentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
//@RequestMapping("/api")
@RestController
public class MainController implements StudentController {

    @Autowired
    StudentRepository repository;

    @Override
    @GetMapping("/students")
    public ResponseEntity<List<com.pak.Student>> getStudents() {
        try {
            List<com.pak.Student> tutorials = new ArrayList<>();
                  repository.findAll().forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") long id) {
        Optional<com.pak.Student> studentData = repository.findById(id);
        if (studentData.isPresent()) {
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {

        try {
           com.pak.Student _tutorial = repository.save(new com.pak.Student(student.getId(), student.getName(), student.getCode()));
           return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(long id, @RequestBody Student student) {
        Optional<com.pak.Student> studentData = repository.findById(id);
        if (studentData.isPresent()) {
            com.pak.Student _student = studentData.get();
          _student.setId(student.getId());
          _student.setCode(student.getCode());
          _student.setName(student.getName());
            return new ResponseEntity<>(repository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") long id) {

        try {
            //repository.deleteAll();
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    ////////
    /*	@Override
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1l,"code1","om"));
        students.add(new Student(2l,"code2","prakash"));
        students.add(new Student(3l,"code3","riya"));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MainController");
        return ResponseEntity.accepted().headers(headers).body(students);
    }

 */
/*    private List<Student> students = new ArrayList<>();

    @Override
    public ResponseEntity getStudents() {
        return ResponseEntity.ok(students);
    }
    @Override
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> s = students.stream().filter(t -> t.getId().equals(id.toString())).findFirst();
        if (!s.isPresent()) {
            throw new StudentNotFoundException();
        }
        return ResponseEntity.<Student>ok().body(s.get());
    }
    @Override
    public ResponseEntity createStudent(@RequestBody Student s) {
        // overwrite if a todo with the same id is present
        Optional<Student> existingStudent = students.stream().filter(t -> t.getId().equals(((Student) students).getId())).findFirst();
        if (existingStudent.isPresent()) {
        	students.remove(existingStudent.get());
        	students.add(s);
            return ResponseEntity.ok().build();
        }
        Long id = (students.stream().map(Student::getId).sorted().findFirst().orElse((long) 0) + 1);
        students.add(s.withId(id));
        URI uri = UriComponentsBuilder.fromPath("/api/students/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
    */
}
