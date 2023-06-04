package com.example.demo.database;


import com.example.demo.repositories.InrollmentRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.repositories.SubjectRepository;
import com.example.demo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDataBase(StudentRepository studentRepository,
                                   UserRepository userRepository,
                                   SubjectRepository subjectRepository,
                                   InrollmentRepository inrollmentRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };
    }
}
