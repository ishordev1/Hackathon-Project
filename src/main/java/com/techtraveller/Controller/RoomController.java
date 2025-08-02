package com.techtraveller.Controller;

import com.techtraveller.Dto.RoomDto;
import com.techtraveller.Service.RoomService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/{ownerId}")
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto, @PathVariable String ownerId) {
    	RoomDto room = roomService.createRoom(roomDto, ownerId);
    	System.out.println("test"+room);
        return new  ResponseEntity<>(room,HttpStatus.CREATED);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable String roomId, @RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(roomService.updateRoom(roomId, roomDto));
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable String roomId) {
        return ResponseEntity.ok(roomService.getRoomById(roomId));
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<RoomDto>> getRoomsByOwner(@PathVariable String ownerId) {
        return ResponseEntity.ok(roomService.getRoomsByOwner(ownerId));
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable String roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.noContent().build();
    }
}
