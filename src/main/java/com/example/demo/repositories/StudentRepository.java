package com.example.demo.repositories;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByHoTen(String hoTen);
}
