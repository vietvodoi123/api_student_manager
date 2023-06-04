package com.example.demo.controllers;


import com.example.demo.model.Inrollment;
import com.example.demo.model.ResponeObject;
import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Students")
public class StudentController {
//    DI
    @Autowired
    private StudentRepository repository;

    @GetMapping("")
    List<Student> getAllStudents(){
        return repository.findAll();
    }

//    find by id
    @GetMapping("/{id}")
    ResponseEntity<ResponeObject> findStudentById(@PathVariable Long id){

        Optional<Student> foundStudent = repository.findById(id);

        return foundStudent.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("ok","query student sucsessfully",foundStudent)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("false","Cannot find student with id = "+id,"")
                );
    }

//    insert new student with POST
//    raw,JSON
    @PostMapping("/insert")
    ResponseEntity<ResponeObject> insertStudent(@RequestBody Student newStudent){
        List<Student> foundStudent = repository.findByHoTen(newStudent.getHoTen().trim());
        if (foundStudent.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponeObject("false","student name already taken","")
            );
        }
        else {
            repository.save(newStudent);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","insert a student sucsessfully",newStudent)
            );
        }
    }
//    update,insert
    @PutMapping("/update/{id}")
    ResponseEntity<ResponeObject> updateStudent(@RequestBody Student newStudent, @PathVariable Long id ){
        Optional<Student> udatedStudent = Optional.of(repository.findById(id).map(student -> {
            student.setMasv(newStudent.getMasv());
            student.setHoTen(newStudent.getHoTen());
            student.setNgaySinh(newStudent.getNgaySinh());
            student.setGioiTinh(newStudent.getGioiTinh());
            student.setDiaChi(newStudent.getDiaChi());
            return repository.save(student);
        }).orElseGet(() -> {
            newStudent.setId(id);
            return repository.save(newStudent);
        }));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok","update student sucsessfuly",udatedStudent)
        );
    }


// delete
    @DeleteMapping("/{id}")
    ResponseEntity<ResponeObject> deleteStudent(@PathVariable Long id){
        boolean exists = repository.existsById(id);

        return exists?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("ok","delete student sucsessfuly","")
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("false","cannot to delete student","")
                );
    }
}
