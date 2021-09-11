/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.redis.repository;

import com.example.redis.domain.Student;
import java.util.Map;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author luis
 */
@Repository
public class StudentRepository implements RedisRepository{

    private static final String KEY = "Student";
    
    private RedisTemplate<String, Student> redisTemplate;
    private HashOperations hashOperations;
    
    
    public StudentRepository(RedisTemplate<String,Student> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    @PostConstruct
    private void init()
    {
        hashOperations = redisTemplate.opsForHash();
    }
    
    @Override
    public Map<String, Student> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Student findById(String id) {
        return (Student) hashOperations.get(KEY, id);
    }

    @Override
    public void save(Student student) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), student);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
    
    
    
}
