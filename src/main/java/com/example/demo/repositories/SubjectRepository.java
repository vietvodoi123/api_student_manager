package com.example.demo.repositories;

import com.example.demo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findByNameSubject(String nameSubject);
    Subject findByMamh(String mamh);
    void deleteByMamh(String mamh);

}
