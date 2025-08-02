package com.techtraveller.Entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String email;
    private String name;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String nationality;
    private String gender;
    private String address;
    private String password;
    private String emailToken;
    private Boolean emailVerify;
    private Boolean isActive;
}
