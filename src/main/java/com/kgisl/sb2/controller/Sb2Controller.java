package com.kgisl.sb2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb2.model.Student;

@RestController
@RequestMapping("/home")
public class Sb2Controller {
    @GetMapping("/")
    public List<Student> welcome() {
        List<Student> cus = new ArrayList<Student>();
        Student c1 = new Student();
        c1.setId(57);
        c1.setFirstName("Maheesha");
        c1.setLastName("Vardhini");
        c1.setEmail("Mahi@gmail.com");
        cus.add(c1);
        return cus;
    }
}
