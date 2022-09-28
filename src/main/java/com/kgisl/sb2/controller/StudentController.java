package com.kgisl.sb2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb2.model.Student;
import com.kgisl.sb2.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Student>> getAllStudents(){
       return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        Student student = studentService.findStudentById(id);
        return student;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Student> createTeam(@RequestBody Student student){
        Student actualStudent = studentService.createStudent(student);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(actualStudent, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") int id, @RequestBody Student student){
        Student stu = studentService.updateStudent(id, student);
        return new ResponseEntity<>(stu, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable("id") int id){
        Student stu1 = studentService.findStudentById(id);
        if(stu1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
