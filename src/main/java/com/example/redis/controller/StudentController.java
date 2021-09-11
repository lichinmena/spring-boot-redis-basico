/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.redis.controller;

import com.example.redis.domain.Student;
import com.example.redis.repository.StudentRepository;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@RestController
public class StudentController {
    
    
    private StudentRepository studentRepository;
    
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    
    @GetMapping("/students")
    public Map<String, Student> findAll() {
        return studentRepository.findAll();
    }
    
    @GetMapping("/students/{id}")
    public Student findById(@PathVariable String id) {
        return studentRepository.findById(id);
    }
    
    @PostMapping("/students")
    public void createStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }
    
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentRepository.delete(id);
    }
}
