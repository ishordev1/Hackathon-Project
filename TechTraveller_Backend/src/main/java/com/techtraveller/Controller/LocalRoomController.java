package com.techtraveller.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techtraveller.Dto.ApiResponse;
import com.techtraveller.Dto.LocalRoomDto;
import com.techtraveller.Service.LocalRoomService;

import java.util.List;

@RestController
@RequestMapping("/api/localrooms")
public class LocalRoomController {

    @Autowired
    private LocalRoomService localRoomService;

    @PostMapping("/{roomProvider}")
    public ResponseEntity<LocalRoomDto> createLocalRoom(@RequestBody LocalRoomDto localRoomDto,
    		@PathVariable String roomProvider) {
        LocalRoomDto createdLocalRoom = localRoomService.createLocalRoom(localRoomDto, roomProvider);
        return new ResponseEntity<>(createdLocalRoom, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<LocalRoomDto> updateLocalRoom(@PathVariable String id,
                                                        @RequestBody LocalRoomDto localRoomDto,
                                                        @RequestParam String roomProviderId) {
        LocalRoomDto updatedLocalRoom = localRoomService.updateLocalRoom(localRoomDto, id, roomProviderId);
        return new ResponseEntity<>(updatedLocalRoom, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalRoomDto> getLocalRoomById(@PathVariable String id) {
        LocalRoomDto localRoomDto = localRoomService.getLocalRoomById(id);
        return new ResponseEntity<>(localRoomDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LocalRoomDto>> getAllLocalRooms() {
        List<LocalRoomDto> localRooms = localRoomService.getAllLocalRooms();
        return new ResponseEntity<>(localRooms, HttpStatus.OK);
    }

    @GetMapping("/provider/{roomProviderId}")
    public ResponseEntity<List<LocalRoomDto>> getAllLocalRoomsByProvider(@PathVariable String roomProviderId) {
        List<LocalRoomDto> localRooms = localRoomService.getAllLocalRoomsRoomProviderId(roomProviderId);
        return new ResponseEntity<>(localRooms, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteLocalRoom(@PathVariable String id) {
        localRoomService.deleteLocalRoom(id);
        return new ResponseEntity<>(new ApiResponse("Local Room deleted successfully", true,HttpStatus.OK), HttpStatus.NO_CONTENT);
    }
}

