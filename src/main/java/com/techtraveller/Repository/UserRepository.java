package com.techtraveller.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtraveller.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{
public User findByEmail(String email);
Optional<User> findUserByEmailToken(String emailToken);
Optional<User> findUserByEmail(String email);

}
