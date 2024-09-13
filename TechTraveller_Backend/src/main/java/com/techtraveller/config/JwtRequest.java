package com.techtraveller.config;

import com.techtraveller.Entity.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private String email;
	private String password;
}
