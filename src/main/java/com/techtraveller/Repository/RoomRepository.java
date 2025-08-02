package com.techtraveller.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtraveller.Entity.Room;

public interface RoomRepository extends JpaRepository<Room, String>{
	List<Room> findByOwnerUserId(String ownerId);
}
