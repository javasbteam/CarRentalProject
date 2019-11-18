package com.ivl.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	
//	public User findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
}
