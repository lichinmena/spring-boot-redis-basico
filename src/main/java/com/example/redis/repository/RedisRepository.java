/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.redis.repository;

import com.example.redis.domain.Student;
import java.util.Map;

/**
 *
 * @author luis
 */
public interface RedisRepository 
{
    Map<String, Student> findAll();
    Student findById(String id);
    void save(Student student);
    void delete(String id);
    
}
