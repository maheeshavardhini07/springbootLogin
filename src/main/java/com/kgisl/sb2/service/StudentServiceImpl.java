package com.kgisl.sb2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgisl.sb2.model.Student;
import com.kgisl.sb2.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    public StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Integer id) {
        studentRepository.findById(id);
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Optional<Student> s = studentRepository.findById(id);
        student = s.get();
        student.setId(student.getId());
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setEmail(student.getEmail());

        studentRepository.save(student);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
    
}
