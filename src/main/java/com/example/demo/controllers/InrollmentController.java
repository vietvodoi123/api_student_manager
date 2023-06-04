package com.example.demo.controllers;

import com.example.demo.model.Inrollment;
import com.example.demo.model.ResponeObject;
import com.example.demo.model.Student;
import com.example.demo.repositories.InrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Inroll")
public class InrollmentController {
    @Autowired
    private InrollmentRepository repository;

    @GetMapping("")
    List<Inrollment> getAllInrollment(){
        return repository.findAll();
    }

    @PostMapping("/insert")
    ResponseEntity<ResponeObject> insertInroll(@RequestBody Inrollment newInroll){
        List<Inrollment> foundInroll = repository.findByMasv(newInroll.getMasv());
        List<Inrollment> foundInroll1 = (List<Inrollment>) foundInroll.stream().filter(item-> item.getMamh().equals(newInroll.getMamh())).toList();

        if(foundInroll1.size()>0){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("false","mon hoc da dang ky roi","")
            );
        }
        else {
            repository.save(newInroll);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","dang ky thanh cong",newInroll)
            );
        }
    }
    @GetMapping("/{masv}")
     List<Inrollment> getAllInrollmentByMasv(@PathVariable String masv){
        List<Inrollment> foundInrollment = repository.findByMasv(masv);
        return foundInrollment;
    }

    List<Inrollment> getAllInrollmentByMamh(String mamh){
        List<Inrollment> foundInrollment = repository.findByMamh(mamh);
        return foundInrollment;
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ResponeObject> updateInrollment(@PathVariable Long id,@RequestBody Inrollment updateIr){
        Optional<Inrollment> udatedStudent = Optional.of(repository.findById(id).map(student -> {
            student.setMasv(updateIr.getMasv());
            student.setMamh(updateIr.getMamh());
            student.setScore(updateIr.getScore());

            return repository.save(student);
        }).orElseGet(() -> {
            updateIr.setId(id);
            return repository.save(updateIr);
        }));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok","update inrollment sucsessfuly",udatedStudent)
        );
    }
}
