package com.techtraveller.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtraveller.Entity.RoomProvider;

public interface RoomProviderRepository extends JpaRepository<RoomProvider, String> {

}
