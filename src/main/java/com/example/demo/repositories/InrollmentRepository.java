package com.example.demo.repositories;

import com.example.demo.model.Inrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InrollmentRepository extends JpaRepository<Inrollment,Long> {
    List<Inrollment> findByMasv(String masv);
    List<Inrollment> findByMamh(String mamh);

}
