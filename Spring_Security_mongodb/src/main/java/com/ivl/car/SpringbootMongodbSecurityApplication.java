package com.ivl.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.ivl.car.domain.Role;
import com.ivl.car.repository.RoleRepository;

@SpringBootApplication
public class SpringbootMongodbSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbSecurityApplication.class, args);
    }
    
    @Bean
    public RestTemplate createRestTemplate() {
    	return new RestTemplate();
    }
    
	/*
	 * @Bean CommandLineRunner init(RoleRepository roleRepository) {
	 * 
	 * return args -> {
	 * 
	 * Role adminRole = roleRepository.findByRole("ADMIN"); if (adminRole == null) {
	 * Role newAdminRole = new Role(); newAdminRole.setRole("ADMIN");
	 * roleRepository.save(newAdminRole); }
	 * 
	 * Role userRole = roleRepository.findByRole("USER"); if (userRole == null) {
	 * Role newUserRole = new Role(); newUserRole.setRole("USER");
	 * roleRepository.save(newUserRole); } };
	 * 
	 * }
	 */
}
