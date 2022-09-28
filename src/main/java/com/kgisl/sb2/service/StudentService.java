package com.kgisl.sb2.service;

import java.util.List;

import com.kgisl.sb2.model.Student;

public interface StudentService {
    public List<Student> getStudents();
    public Student findStudentById(Integer id);
    public Student createStudent(Student student);
    public Student updateStudent(Integer id,Student student);
    public void deleteStudentById(Integer id);  
}
