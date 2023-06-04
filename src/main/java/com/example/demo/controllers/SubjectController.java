package com.example.demo.controllers;

import com.example.demo.model.ResponeObject;
import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/Subjects")
public class SubjectController {
    @Autowired
    private SubjectRepository repository;

    @GetMapping("")
    List<Subject> getAllSubject(){
        return  repository.findAll();
    }

    @PostMapping("/insert")
    ResponseEntity<ResponeObject> insertSubject(@RequestBody Subject newSubject){
        List<Subject> foundSubject = repository.findByNameSubject(newSubject.getNameSubject().trim());
        if(foundSubject.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponeObject("false","subject already taken","")
            );
        }
        else {
            repository.save(newSubject);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","insert a subject sucsessfully",newSubject)
            );
        }
    }
    @DeleteMapping("/{mamh}")
    ResponseEntity<ResponeObject> deleteSubject(@PathVariable String mamh){
        Subject foundSubject = repository.findByMamh(mamh);

        if(foundSubject==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("false","cannot to delete subject","")
            );

        }
        else {
            repository.deleteByMamh(mamh);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","delete a subject sucsessfuly","")
            );
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponeObject> updateSubject(@PathVariable Long id,@RequestBody Subject updateSub){
        Optional<Subject> udatedStudent = Optional.of(repository.findById(id).map(student -> {
            student.setMamh(updateSub.getMamh());
            student.setNameSubject(updateSub.getNameSubject());
            student.setSoTinChi(updateSub.getSoTinChi());
            student.setNameTeacher(updateSub.getNameTeacher());

            return repository.save(student);
        }).orElseGet(() -> {
            updateSub.setId(id);
            return repository.save(updateSub);
        }));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok","update student sucsessfuly",udatedStudent)
        );
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponeObject> deleteSubject(@PathVariable Long id){
        boolean exists =repository.existsById(id);

        if(exists){
            repository.deleteById(id);
             return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","delete subject sucsessfuly","")
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("false","cannot to delete subject","")
            );
        }
    }
}
