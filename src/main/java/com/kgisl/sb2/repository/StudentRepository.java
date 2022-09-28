package com.kgisl.sb2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.sb2.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
