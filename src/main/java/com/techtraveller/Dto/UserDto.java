package com.techtraveller.Dto;

import com.techtraveller.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	  private String userId;
	    private String email;
	    private String name;
	    private String phoneNumber;
	    private Role role;
	    private String nationality;
	    private String gender;
	    private String address;
	    private String password;
	    private String emailToken;
	    private Boolean emailVerify;
	    private Boolean isActive;
    
}
