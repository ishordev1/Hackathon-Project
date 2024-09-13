package com.techtraveller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techtraveller.Dto.ApiResponse;
import com.techtraveller.Dto.RoomProviderDto;
import com.techtraveller.Service.RoomProviderService;

import java.util.List;

@RestController
@RequestMapping("/api/room-providers")
public class RoomProviderController {

    @Autowired
    private RoomProviderService roomProviderService;


    @PutMapping("/{id}")
    public ResponseEntity<RoomProviderDto> updateRoomProvider(@PathVariable String id, @RequestBody RoomProviderDto roomProviderDto) {
        RoomProviderDto updatedRoomProvider = roomProviderService.updateRoomProvider(id, roomProviderDto);
       
            return new ResponseEntity<>( updatedRoomProvider, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomProviderDto> getRoomProviderById(@PathVariable String id) {
        RoomProviderDto roomProvider = roomProviderService.getRoomProviderById(id);
       
            return new ResponseEntity<>( roomProvider, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoomProviderDto>> getAllRoomProviders() {
        List<RoomProviderDto> roomProviders = roomProviderService.getAllRoomProviders();
        return new ResponseEntity<>(roomProviders, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRoomProvider(@PathVariable String id) {
        roomProviderService.deleteRoomProvider(id);
        ApiResponse apiResponse=ApiResponse.builder().message("room provider delete successflly")
        		.success(true)
        		.Status(HttpStatus.OK).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
    }
}
