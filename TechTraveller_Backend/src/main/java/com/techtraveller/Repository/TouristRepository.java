package com.techtraveller.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtraveller.Entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, String> {

}
