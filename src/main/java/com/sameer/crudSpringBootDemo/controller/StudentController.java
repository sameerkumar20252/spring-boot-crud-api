package com.sameer.crudSpringBootDemo.controller;

import com.sameer.crudSpringBootDemo.entity.Student;
import com.sameer.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
//        System.out.println(student.getName());
//        System.out.println(student.getEmail());
        Student createdStudent = studentService.createStudent(student);
//        return ResponseEntity.ok(createdStudent);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    //read one student
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    //read one all student
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
         List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(studentList);
    }

    // update student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student studentReq) {
        Student studentResp = studentService.updateStudent(id, studentReq);

        if(studentResp == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    //Delete one record
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record Deleted");
    }

    // Delete all student records
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllStudent() {
        studentService.deleteAllStudent();

        return ResponseEntity.ok("All student records deleted successfully");
    }
}
