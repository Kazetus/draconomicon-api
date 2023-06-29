package com.draconomicon.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Hasher{
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public String hash(String password) {
		return passwordEncoder.encode(password);
	}
	public boolean testHash(String password, String hash) {
		if(passwordEncoder.matches(password, hash)) {
			return true;
		} else {
			return false;
		}
	}
}
