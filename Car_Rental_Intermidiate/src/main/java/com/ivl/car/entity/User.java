package com.ivl.car.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    
    private String email;
    @Column(name = "password")
   
    private String password;
    @Column(name = "name")
    
    private String name;
    @Column(name = "last_name")
    
    private String lastName;
    @Column(name = "active")
    private int active;
    
    
    
   

}
