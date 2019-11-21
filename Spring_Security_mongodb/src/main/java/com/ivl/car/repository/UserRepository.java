/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivl.car.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ivl.car.domain.User;

/**
 *
 * @author didin
 */
public interface UserRepository extends MongoRepository<User, String> {
    
    public User findByEmail(String email);
    
}
